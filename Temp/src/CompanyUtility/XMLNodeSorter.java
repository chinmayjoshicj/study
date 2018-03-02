package CompanyUtility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class XMLNodeSorter {

	public static void sortChildNodes(Node node, boolean descending, Comparator<Node> comparator, boolean removeEmpty) {

		List<Node> nodes = new ArrayList<>();
		List<Node> emptyNodes = new ArrayList<>();
		NodeList childNodeList = node.getChildNodes();
		if (childNodeList.getLength() > 0) {
			for (int i = 0; i < childNodeList.getLength(); i++) {
				Node tNode = childNodeList.item(i);
				sortChildNodes(tNode, descending, comparator, removeEmpty);
				if (tNode.getNodeType() == Node.TEXT_NODE) {
					String content = ((Text) tNode).getTextContent().trim();
					tNode.setTextContent(content);
					if (content.isEmpty()) {
						emptyNodes.add(tNode);
					} else {
						nodes.add(tNode);
					}
				} else if (!removeEmpty || tNode.getFirstChild() != null) {
					nodes.add(tNode);
				} else if (removeEmpty && tNode.getAttributes()!=null && tNode.getAttributes().getLength() == 0) {
					emptyNodes.add(tNode);
				}

			}

			// remove duplicates start//
			List<Node> dupNodes = findDuplicates(nodes);
			// remove empty + duplicate nodes
			emptyNodes.addAll(dupNodes);
			for (Node element : emptyNodes) {
				node.removeChild(element);
			}
			nodes.removeAll(dupNodes);
			// remove duplicates end//

			Comparator<Node> comp = (comparator != null) ? comparator : new DefaultNodeNameComparator();
			if (descending) {
				Collections.sort(nodes, Collections.reverseOrder(comp));
			} else {
				Collections.sort(nodes, comp);
			}

			for (Node element : nodes) {
				node.appendChild(element);
			}
		}

	}

	private static List<Node> findDuplicates(List<Node> nodes) {

		List<Node> duplicates = new ArrayList<>();

		for (int i = 0; i < nodes.size(); i++) {
			Node node1 = nodes.get(i);

			// Check Only leaf nodes
			if (node1.getNodeType() != Node.TEXT_NODE && !duplicates.contains(node1) && node1.getFirstChild() != null) {
				for (int j = i + 1; j < nodes.size(); j++) {
					Node node2 = nodes.get(j);
					if (node1.isEqualNode(node2)) {
						duplicates.add(node2);
					}
				}
			}
		}
		return duplicates;
	}

	public static void formatXml(File xmlSrc) {
		try {
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-15");
			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			FileInputStream inStream = new FileInputStream(xmlSrc);
			Source xmlSource = new SAXSource(new InputSource(inStream));

			StreamResult res = new StreamResult(new ByteArrayOutputStream());
			serializer.transform(xmlSource, res);
			String content = new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray(), "ISO-8859-15");

			inStream.close();

			PrintWriter writer = new PrintWriter(xmlSrc);
			writer.write(content);
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Formatting:" + xmlSrc);
		}
	}

	public void sortBulkXML(String folderPath) {
		File folder = new File(folderPath);
		File files[] = folder.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				sortBulkXML(file.getAbsolutePath());
			} else if ((true | "UIXML".equals(file.getParentFile().getName())) && file.getName().endsWith(".xml")) {
				System.out.println("Processing :" + file);
				sortXML(file);
			}
		}
	}

	private void sortXML(File file) {
		try {
			Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
			sortChildNodes(dom.getFirstChild(), false, new DefaultNodeNameComparator(), true);
			Transformer transform = TransformerFactory.newInstance().newTransformer();
			StreamResult result = new StreamResult(file);
			transform.transform(new DOMSource(dom), result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		formatXml(file);

	}

	public static void main(String[] args) throws Exception {
//		new XMLNodeSorter().sortXML(new File("D:\\tmp\\sssssTVCL.xml"));
		new XMLNodeSorter().sortXML(new File("C:\\Users\\cmjoshi\\Desktop\\FCUBS_12.3.0.0.0\\SILINL---XML\\A.txt"));
//		new XMLNodeSorter().sortXML(new File("C:/Users/cmjoshi/Desktop/RAD_Issue_1/exp/Refreshed/STDBRANC_RAD.xml"));
//		new XMLNodeSorter().sortBulkXML("d:/tmp");
//		new XMLNodeSorter().sortBulkXML("C:\\Users\\sarrathi\\Desktop\\NACA_SERVER");
//		new XMLNodeSorter().sortBulkXML("C:\\Users\\sarrathi\\Desktop\\NACA_MYWL");
		 System.out.println("Completed....");
	}

}

class DefaultNodeNameComparator implements Comparator<Node> {

	public int compare(Node arg0, Node arg1) {
		return arg0.getNodeName().compareTo(arg1.getNodeName());
	}

}

class MyComparator implements Comparator<Node> {

	public int compare(Node arg0, Node arg1) {

		if (arg0 instanceof Element && arg1 instanceof Element) {
			return ((Element) arg0).getAttribute("id").compareTo(((Element) arg1).getAttribute("id"));
		} else {
			return (arg0).getNodeName().compareTo((arg1).getNodeName());
		}

	}

}