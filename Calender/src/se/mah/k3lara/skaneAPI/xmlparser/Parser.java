package se.mah.k3lara.skaneAPI.xmlparser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import se.mah.k3.Item;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.control.Helpers;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;

public class Parser {
	
	public static String getItemTitle(String RSSurl) {
		XMLParser parser = new XMLParser();
		String title = "";

		String xml = parser.getXmlFromUrl(RSSurl); // getting XML
		System.out.println("xml: "+xml.length());
		if (xml != null) {
			Document doc = parser.getDomElement(xml); // getting DOM element
			// Get departure and arrival time
			System.out.println("NAME"+doc);
			NodeList nl = doc.getElementsByTagName("item");
			// looping through all item nodes <item>
			System.out.println("length: " + nl.getLength());
			for (int i = 0; i < nl.getLength(); i++) {
				//Item item = new Item();
				Element e = (Element) nl.item(i);	
				title = parser.getValue(e, "title");
				
			}
		}
		return title;
	}
	
	/**
	 * Calls Skånetrafiken API and searches for nest departures from a certain
	 * station returns all lines leaving that station Use this Url to test from
	 * a browser from ubåtshallen:
	 * http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=
	 * 80046 More information
	 * 
	 * @param Station
	 *            departure station
	 * @return a Lines object containing information on lines leaving the
	 *         specified station.
	 */
	
	/*
	public static Lines getStationResults(Station station) {
		boolean debug = false;
		String searchURL = Constants.getStationResultURL(station);
		XMLParser parser = new XMLParser();
		String lineNo;
		Calendar depTime;
		String depTimeDeviation;
		Lines lines = new Lines(station);
		String xml = parser.getXmlFromUrl(searchURL); // getting XML
		if (xml != null) {
			Document doc = parser.getDomElement(xml); // getting DOM element
			// Get departure and arrival time
			NodeList nl = doc.getElementsByTagName("Line"); // Get all nodes of
															// type Line
			for (int i = 0; i < nl.getLength(); i++) { // Iterate all Line
														// elements
				Element e = (Element) nl.item(i); // Get the XML element Line;
				// Get the value for that tag "No"
				lineNo = parser.getValue(e, "No");
				if (debug) {
					System.out.println("LineNo: " + lineNo);
				} // For debugging.....
					// Get the value for the tag "JourneyDateTime" //That is
					// departuretime and date as String
				String journeyDateTime = parser.getValue(e, "JourneyDateTime");
				if (debug) {
					System.out.println("JourneyDateTime: " + journeyDateTime);
				}
				// Convert the String to a Calendar object with a helper method
				// written for this in the Helpers class
				depTime = Helpers.parseCalendarString(journeyDateTime);
				// Get the value for that tag "JourneyDateTime"
				depTimeDeviation = parser.getValue(e, "DepTimeDeviation");
				if (debug) {
					System.out.println("DepTimeDeviation: " + depTimeDeviation);
				}
				// Continue with all other elements in the Line node.......
				// ....

				// Then we got one Line lets create a line object and add it to
				// Lines
				Line l = new Line();
				l.setDepTime(depTime);
				l.setLine(lineNo);
				l.setDepTimeDeviation(depTimeDeviation);
				lines.addLine(l);
				// Ok next Line element
			}
		}
		return lines;
	}
	*/
}
