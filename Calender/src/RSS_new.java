import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

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

public class RSS_new {

	public ArrayList<Item> itemList;

	public ArrayList<Item> getInfo() {

		itemList = new ArrayList<Item>();

		URL inputFile = null;
		try {
			inputFile = new URL("https://mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} // läser
			// från
			// en
			// URL

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Document doc = null;
		try {
			doc = (Document) dBuilder.parse(inputFile.toString());
			// doc = (Document) dBuilder.parse(inputFile);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Node) doc.getDocumentElement()).normalize();

		XPath xPath = XPathFactory.newInstance().newXPath();

		String expression = "//item"; // // plockar item från hela xml trädet
		try {
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Item item = new Item();
				Node nNode = nodeList.item(i);
				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String title = eElement.getElementsByTagName("title").item(0).getTextContent();
					item.setTitle(title);
					// System.out.println("Title: "+title);

					String time = eElement.getElementsByTagName("content:encoded").item(0).getTextContent();
					time = time.trim();
					// System.out.println("time: "+time.length());
					int j = time.indexOf("</strong>");
					// System.out.println("length: "+ j);
					try {
						if (time.length() > 100) {
							String timeExact = time.substring(j + 10, j + 30);
							// System.out.println("Sub: "+timeExact);
							item.setTimeExact(timeExact);
							String timeStart = time.substring(j + 21, j + 26);
							item.setTimeStart(timeStart);
							String timeEnd = time.substring(j + 43, j + 48);
							item.setTimeEnd(timeEnd);

						}
					} catch (Exception e) {
					}

					String description = eElement.getElementsByTagName("description").item(0).getTextContent();
					item.setDescription(description);
					// System.out.println("description: "+description);

					itemList.add(item);

				}

			}
		} catch (XPathExpressionException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
		
		for (Item i : itemList) {
			// System.out.println("osorterad " +i.getTimeExact().toString());
		}
		Collections.sort(itemList);
		for (Item i : itemList) {
			System.out.println("sorterad  " + i.getTimeExact().toString());
			System.out.println("Titel:  " + i.getTitle().toString());
			System.out.println("Start:  " + i.getTimeStart().toString());
			System.out.println("Slut:  " + i.getTimeEnd().toString());
			System.out.println("Beskrivning:  " + i.getDescription().toString() + "\n");

		}
		return itemList;

	}

}
