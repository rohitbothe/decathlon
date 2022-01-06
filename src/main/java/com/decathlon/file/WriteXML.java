package com.decathlon.file;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.decathlon.model.DecathlonAthlete;
/**
 *@author Rohit Bothe 
 */
public class WriteXML {

	/** 
     * This method creates XML file at given location. 
     * @param List<DecathlonAthlete> finalList This method takes input as list of DecathlonAthlete which is sorted based on Rank.
     * @param outputPath This takes input as output path for XML file.
     */  
	public void createXML(List<DecathlonAthlete> finalList, String outputPath) {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("Decatholon");
			doc.appendChild(rootElement);

			finalList.forEach(decathlonAthlete -> {
				Element athlete = doc.createElement("Athlete");
				rootElement.appendChild(athlete);
				athlete.appendChild(
						WriteXML.createNode(doc, athlete, "AthleteName", decathlonAthlete.getAthleteName()));
				athlete.appendChild(WriteXML.createNode(doc, athlete, "AthleteScore",
						decathlonAthlete.getAthleteScore().toString()));
				athlete.appendChild(
						WriteXML.createNode(doc, athlete, "AthleteRank", decathlonAthlete.getAthleteRank()));
				Element events = doc.createElement("Events");
				athlete.appendChild(events);

				decathlonAthlete.getEvents().forEach(event -> {
					Element eventElement = doc.createElement(event.getName());
					events.appendChild(eventElement);

					eventElement.appendChild(WriteXML.createNode(doc, events, "Result", event.getResult()));
					eventElement.appendChild(WriteXML.createNode(doc, events, "Score", event.getScore().toString()));
				});
			});

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("",outputPath));

			transformer.transform(source, console);
			transformer.transform(source, file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
     * This method creates XML Node from input details. 
     * @param doc Takes input as XML document.
     * @param element Takes input as XML Element.
     * @param name This takes input as XML element name.
     * @param value This takes input as value of XML element.
     * @return Node Gives output of XML node.
     */  
	private static Node createNode(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}