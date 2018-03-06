package CompanyUtility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		 List<String> readAllLines = Files.readAllLines(Paths.get("D:\\Sources\\12.5.0.0.0_core_supp_installer\\SOURCE\\FCUBS_14.0.0.0.0\\test.txt"));
//		 List<String> readAllLines = Files.readAllLines(Paths.get("C:\\Users\\cmjoshi\\Desktop\\path.txt"));
		for (String fileName : readAllLines) {
			String functionID = "";
			int count = 0;
			
		try {
			Document doc = docBuilder.parse(new File(fileName));
			//functionID = fileName;
			// normalize text representation
			doc.getDocumentElement().normalize();
//			System.out.println("Root element of the doc is " + doc.getDocumentElement().getChildNodes().item(1).getNodeValue().trim());
			
			NodeList rootChildren = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < rootChildren.getLength(); i++) {
				Node item = rootChildren.item(i);
				
				if(item.getNodeType() == Node.ELEMENT_NODE &&(item.getNodeName().equals("FUNCTION_ID") ||item.getNodeName().equals("ENTITY_ID"))) {
//					functionId =  item.getNodeValue();
					functionID = item.getFirstChild().getTextContent().trim();
					functionID = (functionID== null || functionID.equals("0") || functionID.isEmpty() ) ? fileName:functionID;
					System.out.print( functionID +"\t");
				}
			}

			NodeList blockFields = doc.getElementsByTagName("RAD_BLK_FIELDS");
			int totaldataBlocks = blockFields.getLength();
			//System.out.println("Total no of Blocks : " + totaldataBlocks);

			for (int i = 0; i < blockFields.getLength(); i++) {

				boolean required = false;
				boolean textField = false;
				Node firstDataBlock = blockFields.item(i);
				if (firstDataBlock.getNodeType() == Node.ELEMENT_NODE) {

					Element firstElement = (Element) firstDataBlock;

					NodeList childNodes = firstElement.getChildNodes();
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node item = childNodes.item(j);

						if (item.getNodeType() == Node.ELEMENT_NODE && item.getNodeName().equals("REQUIRED")
								&& item.getFirstChild() != null
								&& item.getFirstChild().getTextContent().trim().equals("Y")) {
							required = true;

						}
						if (item.getNodeType() == Node.ELEMENT_NODE && item.getNodeName().equals("DISPLAY_TYPE")
								&& item.getFirstChild() != null
								&& item.getFirstChild().getTextContent().trim().equals("TEXT")) {
							textField = true;

						}
					}
				}

				if (required && textField) {
					/*System.out.println("REQUIRED & Text for : "
							+ firstDataBlock.getAttributes().getNamedItem("ID").getTextContent());*/
					count++;
				}

			} // end of for loop with s var
			
			if(functionID.isEmpty() && count == 0) {
				System.out.print(fileName);
			} else {
				System.out.print(count);
				
			}
			
			System.out.println();
		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());
		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		}
	}

	public static NodeList selectNodeList(Node contextNode, String xpathStr) throws XPathExpressionException {
		return (NodeList) XPATH.evaluate(xpathStr, contextNode, XPathConstants.NODESET);
	}

	public static Node selectSingleNode(Node contextNode, String xpathStr) throws XPathExpressionException {
		return (Node) XPATH.evaluate(xpathStr, contextNode, XPathConstants.NODE);
	}

}
