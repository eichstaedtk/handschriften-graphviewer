package de.eichstaedt.handschriftengraphviewer.infrastructure.xml;


import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGEN;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESITZER_SEIT;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BUCHBINDER_HERSTELLUNG;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_PROVENIENZ_HERSTELLUNG;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_SIGNATURE;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_TITEL;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_VORBESITZER;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOEPERSCHAFTS_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOERPERSCHAFTS_NAME;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOERPERSCHAFTS_ORT;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOERPERSCHAFTS_VON_JAHR;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_PERSON_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_PERSON_NAME;

import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import de.eichstaedt.handschriftengraphviewer.domain.Buchbinder;
import de.eichstaedt.handschriftengraphviewer.domain.Koerperschaft;
import de.eichstaedt.handschriftengraphviewer.domain.Person;
import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import de.eichstaedt.handschriftengraphviewer.domain.ProvenienzTyp;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.ProvenienzRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */

@Service
public class XMLService {

  @Autowired
  public XMLService(
      ProvenienzRepository provenienzRepository) {
    this.provenienzRepository = provenienzRepository;
  }

  private static final Logger logger = LoggerFactory.getLogger(XMLService.class);

  private ProvenienzRepository provenienzRepository;

  public void   loadingXMLData() {

    logger.info("Start loading data from xml file ...");

    try {

      Document xmlDoc = prepareDocument(ResourceUtils.getFile("classpath:Bonn.xml"),false);


      NodeList beschreibungen = findNodesByXPath(xmlDoc, BESCHREIBUNGEN);

      Koerperschaft bonn = new Koerperschaft("30002387","Universitäts- und Landesbibliothek Bonn","Bonn");

      List<Provenienz> provenienzen = new ArrayList<>();


      for (int i = 0 ; i < beschreibungen.getLength();i++)
      {

        String xmlBeschreibung = nodeToString(beschreibungen.item(i));

        Document beschreibungsDoc = prepareDocument(xmlBeschreibung,false);

        logger.info("XML processing for Beschreibung {} ", i);

        Beschreibungsdokument beschreibungsdokument = new Beschreibungsdokument(findXMLValueByXPath(beschreibungsDoc,
            BESCHREIBUNGS_ID)
            ,findXMLValueByXPath(beschreibungsDoc,BESCHREIBUNGS_TITEL)
            ,findXMLValueByXPath(beschreibungsDoc,
            BESCHREIBUNGS_SIGNATURE));

        Provenienz besitzer = new Provenienz(ProvenienzTyp.Besitzer,bonn,beschreibungsdokument,findXMLValueByXPath(beschreibungsDoc,
            BESCHREIBUNGS_BESITZER_SEIT),
            String.valueOf(LocalDate.now().getYear()));

        provenienzen.add(besitzer);


        NodeList vorbesitzer = findNodesByXPath(beschreibungsDoc, BESCHREIBUNGS_VORBESITZER);

        for (int v = 0 ; v < vorbesitzer.getLength();v++)
        {
          String xmlVorbesitzer = nodeToString(vorbesitzer.item(v));

          Document vorbesitzerDoc = prepareDocument(xmlVorbesitzer,false);

          Provenienz vp = null;

          if(findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_ID) != null && !findXMLValueByXPath(vorbesitzerDoc,
              BESCHREIBUNGS_PERSON_ID).isEmpty()) {
            Person p = new Person(
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_ID),
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_NAME),
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_NAME));

             vp = new Provenienz(ProvenienzTyp.Vorbesitzer,p,beschreibungsdokument,"","");
          }

          if(findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOEPERSCHAFTS_ID) != null && !findXMLValueByXPath(vorbesitzerDoc,
              BESCHREIBUNGS_KOEPERSCHAFTS_ID).isEmpty()) {
            Koerperschaft k = new Koerperschaft(
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOEPERSCHAFTS_ID),
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOERPERSCHAFTS_NAME),
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOERPERSCHAFTS_ORT));

             vp = new Provenienz(ProvenienzTyp.Vorbesitzer,k,beschreibungsdokument,findXMLValueByXPath(vorbesitzerDoc,
                 BESCHREIBUNGS_KOERPERSCHAFTS_VON_JAHR),"");
          }


          if(vp != null)
          {
            provenienzen.add(vp);
          }

        }

        NodeList herstellung = findNodesByXPath(beschreibungsDoc, BESCHREIBUNGS_PROVENIENZ_HERSTELLUNG);

        for (int h = 0 ; h < herstellung.getLength();h++)
        {
          String xmlHerstellung = nodeToString(herstellung.item(h));

          Document herstellungDoc = prepareDocument(xmlHerstellung,false);

          if(findXMLValueByXPath(herstellungDoc, BESCHREIBUNGS_PERSON_ID) != null && !findXMLValueByXPath(herstellungDoc,
              BESCHREIBUNGS_PERSON_ID).isEmpty()) {
            Person p = new Person(
                findXMLValueByXPath(herstellungDoc, BESCHREIBUNGS_PERSON_ID),
                findXMLValueByXPath(herstellungDoc, BESCHREIBUNGS_PERSON_NAME),
                findXMLValueByXPath(herstellungDoc, BESCHREIBUNGS_PERSON_NAME));

            provenienzen.add(new Provenienz(ProvenienzTyp.Hersteller,p,beschreibungsdokument,"",""));
          }
        }


        Node buchbinder = findNodeByXPath(beschreibungsDoc, BESCHREIBUNGS_BUCHBINDER_HERSTELLUNG);

        if(buchbinder != null)
        {
          String xmlbuchbinder = nodeToString(buchbinder);

          Document buchbinderDoc = prepareDocument(xmlbuchbinder,false);


          if(findXMLValueByXPath(buchbinderDoc, BESCHREIBUNGS_KOEPERSCHAFTS_ID) != null && !findXMLValueByXPath(buchbinderDoc,
              BESCHREIBUNGS_KOEPERSCHAFTS_ID).isEmpty()) {
          Buchbinder k = new Buchbinder(
              findXMLValueByXPath(buchbinderDoc, BESCHREIBUNGS_KOEPERSCHAFTS_ID),
              findXMLValueByXPath(buchbinderDoc, BESCHREIBUNGS_KOERPERSCHAFTS_NAME),
              findXMLValueByXPath(buchbinderDoc, BESCHREIBUNGS_KOERPERSCHAFTS_ORT),null);


            beschreibungsdokument.setBuchbinder(k);
        }

        }

      }


      if(!provenienzen.isEmpty())
      {
        provenienzRepository.deleteAll();

        final AtomicInteger counter = new AtomicInteger();

        provenienzen.stream()
            .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 20)).values().forEach(l -> {

            provenienzRepository.saveAll(l);

            });

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static Document prepareDocument(File content, boolean namespaceAware)
      throws IOException, SAXException, ParserConfigurationException {

    try (InputStream inputStream = new FileInputStream(
        content); Reader reader = new InputStreamReader(inputStream, "UTF-8");) {

      InputSource source = new InputSource(reader);

      return readSourceIntoDocument(namespaceAware, source);
    }

  }

  private static Document readSourceIntoDocument(boolean namespaceAware, InputSource source)
      throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    dbf.setNamespaceAware(namespaceAware);
    DocumentBuilder db;

    db = dbf.newDocumentBuilder();

    Document document = db.parse(source);

    return document;
  }

  public static String findXMLValueByXPath(Document document, String xpathExpression)
      throws XPathExpressionException {

    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();

    String result = xpath
        .evaluate(xpathExpression, document);

    return result;

  }

  public static NodeList findNodesByXPath(Document document, String xpathExpression)
      throws XPathExpressionException {
    XPath xPath = XPathFactory.newInstance().newXPath();

    return (NodeList) xPath.compile(xpathExpression)
        .evaluate(document, XPathConstants.NODESET);
  }

  public static Node findNodeByXPath(Document document, String xpathExpression)
      throws XPathExpressionException {
    XPath xPath = XPathFactory.newInstance().newXPath();

    return (Node) xPath.compile(xpathExpression)
        .evaluate(document, XPathConstants.NODE);
  }

  public static String nodeToString(Node node) throws Exception {
    try (StringWriter sw = new StringWriter()) {

      TransformerFactory factory = TransformerFactory.newInstance();
      factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
      Transformer transformer = factory.newTransformer();
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
      transformer.setOutputProperty(OutputKeys.INDENT, "no");
      transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      transformer.transform(new DOMSource(node), new StreamResult(sw));

      return sw.toString();
    }
  }

  public static Document prepareDocument(String xml, boolean namespaceaware)
      throws IOException, SAXException, ParserConfigurationException {

    try (StringReader reader = new StringReader(xml);) {

      InputSource source = new InputSource(reader);
      return readSourceIntoDocument(namespaceaware, source);
    }
  }

}
