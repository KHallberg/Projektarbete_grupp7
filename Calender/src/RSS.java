import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class RSS {


	public static void main(String[] args) throws MalformedURLException {
		
		
		URL inputFile = new URL("https://mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");  // läser från en URL
		
	         //File inputFile = new File("rss/rss.xml");  // läsa från en url istället
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = null;

	         try {
				dBuilder = dbFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	         Document doc = null;
			try {
				doc = (Document) dBuilder.parse(inputFile.toString());
				//doc = (Document) dBuilder.parse(inputFile);
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         ((Node) doc.getDocumentElement()).normalize();

	         XPath xPath =  XPathFactory.newInstance().newXPath();

	         String expression = "//item";	   // // plockar item från hela xml trädet     
	         try {
				NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
				for (int i = 0; i < nodeList.getLength(); i++) {
		            Node nNode = nodeList.item(i);
		            System.out.println("\nCurrent Element :" 
		               + nNode.getNodeName());
		            
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element eElement = (Element) nNode;
		                
		               
		                System.out.println();
		               
		                String title=eElement
	                     .getElementsByTagName("title") 
	                     .item(0)
	                     .getTextContent();
		                System.out.println(title);
		               
		                
		                String time=eElement
		                		.getElementsByTagName("content:encoded") 
			                     .item(0)
			                     .getTextContent();
				                System.out.println(time);
				                
		                
		                String description=eElement
		                		.getElementsByTagName("description") 
			                     .item(0)
			                     .getTextContent();
				                System.out.println(description);
				                
		                
		                
		                
		                
		                
		            }
		            
				}
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
