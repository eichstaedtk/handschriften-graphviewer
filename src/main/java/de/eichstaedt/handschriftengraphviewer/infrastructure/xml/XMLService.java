package de.eichstaedt.handschriftengraphviewer.infrastructure.xml;


import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.AUTORENSCHAFTEN;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.AUTORENSCHAFTEN_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.AUTORENSCHAFTEN_NAME;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGEN;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESITZER_SEIT;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_BESCHREIBUNG_LEVEL2;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_BESCHREIBUNG_LEVEL3;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL2;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL3;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_LEVEL2;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_LEVEL3;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_LEVEL3_ONLY;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_NAME_LEVEL2;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BESTANDTEILE_NAME_LEVEL3;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_BUCHBINDER_HERSTELLUNG;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOEPERSCHAFTS_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOERPERSCHAFTS_NAME;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOERPERSCHAFTS_ORT;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_KOERPERSCHAFTS_VON_JAHR;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_ORTE;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_PERSON_ID;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_PERSON_NAME;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_PROVENIENZ_HERSTELLUNG;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_SIGNATURE;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_TITEL;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_VORBESITZER_KOEPERSCHAFT;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.BESCHREIBUNGS_VORBESITZER_PERSON;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.DIGITALISATE;
import static de.eichstaedt.handschriftengraphviewer.infrastructure.xml.AbstractHIDAXPATHValues.DIGITALISAT_NAME;

import de.eichstaedt.handschriftengraphviewer.domain.Autor;
import de.eichstaedt.handschriftengraphviewer.domain.Beschreibungsdokument;
import de.eichstaedt.handschriftengraphviewer.domain.Buchbinder;
import de.eichstaedt.handschriftengraphviewer.domain.Digitalisat;
import de.eichstaedt.handschriftengraphviewer.domain.DokumentElement;
import de.eichstaedt.handschriftengraphviewer.domain.Koerperschaft;
import de.eichstaedt.handschriftengraphviewer.domain.Ort;
import de.eichstaedt.handschriftengraphviewer.domain.Person;
import de.eichstaedt.handschriftengraphviewer.domain.Provenienz;
import de.eichstaedt.handschriftengraphviewer.domain.ProvenienzTyp;
import de.eichstaedt.handschriftengraphviewer.infrastructure.repository.BeschreibungsdokumentRepository;
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
import java.util.UUID;
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
      BeschreibungsdokumentRepository beschreibungsdokumentRepository,
      ProvenienzRepository provenienzRepository) {
    this.beschreibungsdokumentRepository = beschreibungsdokumentRepository;
    this.provenienzRepository = provenienzRepository;
  }

  private static final Logger logger = LoggerFactory.getLogger(XMLService.class);

  private BeschreibungsdokumentRepository beschreibungsdokumentRepository;

  private ProvenienzRepository provenienzRepository;

  public void   loadingXMLData() {

    logger.info("Start loading data from xml file ...");

    try {

      Document xmlDoc = prepareDocument(ResourceUtils.getFile("classpath:Bonn.xml"),false);


      NodeList beschreibungen = findNodesByXPath(xmlDoc, BESCHREIBUNGEN);

      Koerperschaft bonn = new Koerperschaft("30002387","Universitäts- und Landesbibliothek Bonn",new Ort("Bonn"));

      List<Beschreibungsdokument> beschreibungsdokumente = new ArrayList<>();

      List<Provenienz> provenienzen = new ArrayList<>();

      for (int i = 0 ; i < beschreibungen.getLength();i++)
      {

        String xmlBeschreibung = nodeToString(beschreibungen.item(i));

        Document beschreibungsDoc = prepareDocument(xmlBeschreibung,false);

        logger.info("XML processing for Beschreibung {} ", i);

        Beschreibungsdokument beschreibungsdokument = new Beschreibungsdokument(findXMLValueByXPath(beschreibungsDoc,
            BESCHREIBUNGS_ID).replaceAll("[^\\d.]", "")
            ,findXMLValueByXPath(beschreibungsDoc,BESCHREIBUNGS_TITEL)
            ,findXMLValueByXPath(beschreibungsDoc,
            BESCHREIBUNGS_SIGNATURE));

        Provenienz besitzer = new Provenienz(UUID.randomUUID().toString(),ProvenienzTyp.Besitzer,bonn,findXMLValueByXPath(beschreibungsDoc,
            BESCHREIBUNGS_BESITZER_SEIT),
            String.valueOf(LocalDate.now().getYear()),beschreibungsdokument);

        provenienzen.add(besitzer);


        NodeList vorbesitzerKoerperschaft = findNodesByXPath(beschreibungsDoc, BESCHREIBUNGS_VORBESITZER_KOEPERSCHAFT);

        for (int v = 0 ; v < vorbesitzerKoerperschaft.getLength();v++)
        {
          String xmlVorbesitzer = nodeToString(vorbesitzerKoerperschaft.item(v));

          Document vorbesitzerDoc = prepareDocument(xmlVorbesitzer,false);

          Provenienz vp = null;

          if(findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOEPERSCHAFTS_ID) != null && !findXMLValueByXPath(vorbesitzerDoc,
              BESCHREIBUNGS_KOEPERSCHAFTS_ID).isEmpty()) {
            Koerperschaft k = new Koerperschaft(
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOEPERSCHAFTS_ID),
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOERPERSCHAFTS_NAME).replaceAll("[<>]",""),
                new Ort(findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_KOERPERSCHAFTS_ORT)));

             vp = new Provenienz(UUID.randomUUID().toString(),ProvenienzTyp.Vorbesitzer,k,findXMLValueByXPath(vorbesitzerDoc,
                 BESCHREIBUNGS_KOERPERSCHAFTS_VON_JAHR),"",beschreibungsdokument);
          }


          if(vp != null)
          {
            provenienzen.add(vp);
          }

        }

        NodeList vorbesitzerPerson = findNodesByXPath(beschreibungsDoc, BESCHREIBUNGS_VORBESITZER_PERSON);

        for (int v = 0 ; v < vorbesitzerPerson.getLength();v++) {
          String xmlPerson = nodeToString(vorbesitzerPerson.item(v));

          Document vorbesitzerDoc = prepareDocument(xmlPerson, false);

          Provenienz vp = null;

          if (findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_ID) != null
              && !findXMLValueByXPath(vorbesitzerDoc,
              BESCHREIBUNGS_PERSON_ID).isEmpty()) {
            Person p = new Person(
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_ID),
                findXMLValueByXPath(vorbesitzerDoc, BESCHREIBUNGS_PERSON_NAME)
                    .replaceAll("[<>]", ""));

            vp = new Provenienz(UUID.randomUUID().toString(), ProvenienzTyp.Vorbesitzer, p, findXMLValueByXPath(vorbesitzerDoc,
                BESCHREIBUNGS_KOERPERSCHAFTS_VON_JAHR), "",
                beschreibungsdokument);
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
                findXMLValueByXPath(herstellungDoc, BESCHREIBUNGS_PERSON_NAME).replaceAll("[<>]",""));

            provenienzen.add(new Provenienz(UUID.randomUUID().toString(),ProvenienzTyp.Hersteller,p,"","",beschreibungsdokument));
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
              findXMLValueByXPath(buchbinderDoc, BESCHREIBUNGS_KOERPERSCHAFTS_NAME).replaceAll("[<>]",""),
              new Ort(findXMLValueByXPath(buchbinderDoc, BESCHREIBUNGS_KOERPERSCHAFTS_ORT)));


            beschreibungsdokument.setBuchbinder(k);
        }

        }

        NodeList bestandteile = findNodesByXPath(beschreibungsDoc, BESCHREIBUNGS_BESTANDTEILE_LEVEL2);

        logger.info("Add DokumentenElement {} ", bestandteile.getLength());

        for(int b = 0; b < bestandteile.getLength(); b++)
        {

          String xmlBestandteil = nodeToString(bestandteile.item(b));

          Document bestandteilDoc = prepareDocument(xmlBestandteil,false);

          DokumentElement element = new DokumentElement(findXMLValueByXPath(bestandteilDoc, BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL2),findXMLValueByXPath(bestandteilDoc, BESCHREIBUNGS_BESTANDTEILE_NAME_LEVEL2),
              findXMLValueByXPath(bestandteilDoc, BESCHREIBUNGS_BESTANDTEILE_BESCHREIBUNG_LEVEL2));

          addDigitalisate(bestandteilDoc, element,BESCHREIBUNGS_BESTANDTEILE_LEVEL2);

          addAutorenschaften(bestandteilDoc,element,BESCHREIBUNGS_BESTANDTEILE_LEVEL2);

          NodeList childsT3 = findNodesByXPath(bestandteilDoc, BESCHREIBUNGS_BESTANDTEILE_LEVEL3);

          addElements(element, childsT3);

          beschreibungsdokument.getBestandteile().add(element);

          logger.info("Add DokumentenElement {} ", element);
        }


        NodeList orte = findNodesByXPath(beschreibungsDoc, BESCHREIBUNGS_ORTE);

        for(int o =0;o < orte.getLength();o++)
        {

          Node oNode = orte.item(o);

          beschreibungsdokument.getOrte().add(new Ort(oNode.getAttributes().getNamedItem("Value").getTextContent()));
        }


        beschreibungsdokumente.add(beschreibungsdokument);

      }

      saveAll(beschreibungsdokumente, provenienzen);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void addElements(DokumentElement element, NodeList childsT3) throws Exception {
    for(int n3 = 0; n3 < childsT3.getLength();n3++)
    {
      String xmlChild3 = nodeToString(childsT3.item(n3));

      Document child3Doc = prepareDocument(xmlChild3,false);

      if(findXMLValueByXPath(child3Doc, BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL3) != null && !findXMLValueByXPath(child3Doc, BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL3).isEmpty()) {

        DokumentElement child3 = new DokumentElement(
            findXMLValueByXPath(child3Doc, BESCHREIBUNGS_BESTANDTEILE_ID_LEVEL3),
            findXMLValueByXPath(child3Doc, BESCHREIBUNGS_BESTANDTEILE_NAME_LEVEL3),
            findXMLValueByXPath(child3Doc, BESCHREIBUNGS_BESTANDTEILE_BESCHREIBUNG_LEVEL3));

        addDigitalisate(child3Doc, child3, BESCHREIBUNGS_BESTANDTEILE_LEVEL3_ONLY);

        addAutorenschaften(child3Doc, child3, BESCHREIBUNGS_BESTANDTEILE_LEVEL3_ONLY);

        element.getBestandteile().add(child3);
      }
    }
  }

  private void addDigitalisate(Document doc, DokumentElement element, String xpathLevel) throws Exception {

    NodeList digitalisate = findNodesByXPath(doc, xpathLevel+DIGITALISATE);

    for(int d = 0; d < digitalisate.getLength();d++)
    {
      String xmlDigitalisat = nodeToString(digitalisate.item(d));

      Document digitalisatDoc = prepareDocument(xmlDigitalisat,false);

      Digitalisat digitalisat = new Digitalisat(
          UUID.randomUUID().toString(),findXMLValueByXPath(digitalisatDoc, DIGITALISAT_NAME),"http://bilder.manuscripta-mediaevalia.de/thumbnail/"+findXMLValueByXPath(digitalisatDoc, DIGITALISAT_NAME));

      element.getDigitalisate().add(digitalisat);
    }
  }

  private void addAutorenschaften(Document doc, DokumentElement element, String xpathLevel) throws Exception {

    NodeList autoren = findNodesByXPath(doc, xpathLevel+AUTORENSCHAFTEN);

    for(int d = 0; d < autoren.getLength();d++)
    {
      String xmlAutoren = nodeToString(autoren.item(d));

      Document autorenDoc = prepareDocument(xmlAutoren,false);

      if(findXMLValueByXPath(autorenDoc, AUTORENSCHAFTEN_ID) != null && !findXMLValueByXPath(autorenDoc, AUTORENSCHAFTEN_ID).isEmpty()) {
        Autor autor = new Autor(findXMLValueByXPath(autorenDoc, AUTORENSCHAFTEN_ID),
            findXMLValueByXPath(autorenDoc, AUTORENSCHAFTEN_NAME).replaceAll("[<>]", ""));

        element.getAutoren().add(autor);
      }

    }
  }

  private void saveAll(List<Beschreibungsdokument> beschreibungsdokumente, List<Provenienz> provenienzen) {
    if(!beschreibungsdokumente.isEmpty())
    {
      beschreibungsdokumentRepository.deleteAll();
      provenienzRepository.deleteAll();

      final AtomicInteger counter = new AtomicInteger();

      beschreibungsdokumente.stream()
          .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 20)).values().forEach(l -> {

          beschreibungsdokumentRepository.saveAll(l);

          });

      provenienzen.stream()
          .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 20)).values().forEach(l -> {

        provenienzRepository.saveAll(l);

      });


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
