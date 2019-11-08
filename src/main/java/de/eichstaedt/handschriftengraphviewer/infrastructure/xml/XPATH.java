package de.eichstaedt.handschriftengraphviewer.infrastructure.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Created by konrad.eichstaedt@gmx.de on 2019-11-08.
 */
public class XPATH {

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
