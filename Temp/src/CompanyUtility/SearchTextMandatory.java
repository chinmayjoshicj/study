package CompanyUtility;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SearchTextMandatory {

	private static final XPath XPATH = XPathFactory.newInstance().newXPath();
		public static void main(String[] args) throws Exception 
		{	
			DocumentBuilder builder = null;
			try 
			{
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				
				builder =  builderFactory.newDocumentBuilder();
			    Document document = builder.parse(
			            new FileInputStream("C:\\Users\\cmjoshi\\Desktop\\RADXMLs\\GEDCOLLT_RAD.xml"));
			    
			    //String expression = "/Employees/Employee[@type='admin']/firstname";
			    String expression = "/Employees/Employee[@emplid='3333']/email";
			    
			    //NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
				System.out.println(expression);
				NodeList nodeList = (NodeList) XPATH.compile(expression).evaluate(document, XPathConstants.NODESET);
				for (int i = 0; i < nodeList.getLength(); i++) {
				    System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
				}
			} 
			catch (Exception e) {
			    e.printStackTrace();
			}
		}

		public static NodeList selectNodeList(Node contextNode, String xpathStr) throws XPathExpressionException 
		{
			return (NodeList) XPATH.evaluate(xpathStr, contextNode, XPathConstants.NODESET);
		}

		public static Node selectSingleNode(Node contextNode, String xpathStr) throws XPathExpressionException 
		{
			return (Node) XPATH.evaluate(xpathStr, contextNode, XPathConstants.NODE);
		}

}

