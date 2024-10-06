import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WsdlElementNameTest {

  @Test
  public void assertElementNames() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
    String xmlUrl = "http://dneonline.com/calculator.asmx?WSDL"; // Replace with your actual XML URL

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    XPath xpath = XPathFactory.newInstance().newXPath();

//    String expression = "//wsdl:portType/wsdl:operation/element/@name"; // XPath expression to select element names
    String expression = "//wsdl:definitions.wsdl:portType.s:schema.s:element.name";
    Document doc = factory.newDocumentBuilder().parse(xmlUrl);

    String elementNames = (String) xpath.evaluate(expression, doc, XPathConstants.STRING);

    // Process each element name
    for (String name : elementNames.split(" ")) {
      System.out.println("Element Name: " + name);
//       Add your custom assertions here
      Assert.assertEquals(name, "Add");
    }
  }
}
