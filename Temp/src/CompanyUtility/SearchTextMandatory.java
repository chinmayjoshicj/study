package CompanyUtility;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SearchTextMandatory {

	private static final XPath XPATH = XPathFactory.newInstance().newXPath();
		public static void main(String[] args) throws Exception 
		{	
			try {
				DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			    Document doc = docBuilder.parse (new File("C:\\Users\\Dell\\Desktop\\rad.xml.txt"));

			    // normalize text representation
			    doc.getDocumentElement().normalize();
			    System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			    NodeList listOfBooks = doc.getElementsByTagName("book");
			    int totalBooks = listOfBooks.getLength();
			    System.out.println("Total no of books : " + totalBooks);

			    for(int i=0; i<listOfBooks.getLength() ; i++) {

			        Node firstBookNode = listOfBooks.item(i);
 			        if(firstBookNode.getNodeType() == Node.ELEMENT_NODE) {

			            Element firstElement = (Element)firstBookNode;                              
			            System.out.println("Year :"+firstElement.getAttribute("year"));

			            //-------
			            NodeList firstNameList = firstElement.getElementsByTagName("title");
			            Element firstNameElement = (Element)firstNameList.item(0);

			            NodeList textFNList = firstNameElement.getChildNodes();
			            System.out.println("title : " + ((Node)textFNList.item(0)).getNodeValue().trim());
			        }
			    }//end of for loop with s var
			} catch (SAXParseException err) {
			    System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
			    System.out.println(" " + err.getMessage ());
			} catch (SAXException e) {
			    Exception x = e.getException ();
			    ((x == null) ? e : x).printStackTrace ();
			} catch (Throwable t) {
			    t.printStackTrace ();
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

