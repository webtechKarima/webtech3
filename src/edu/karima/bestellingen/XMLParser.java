package edu.karima.bestellingen;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {
	
	private String INPUTFILE = "/Users/philippepossemiers/Desktop/races.xml";
	
	/** Get all races from the xml file and return them 
	 * in html format
	 */
	public String getBestellingen() {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Bestellingen</h2>";
	        
	        NodeList bestellingen = doc.getElementsByTagName("bestelling");

	        for (int i = 0; i < bestellingen.getLength(); i++) {
	        	 Node nNode = bestellingen.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 result += "<br/><b>Naam klant : </b>" + eElement.getAttribute("naam");
	        	 result += "<br/><b>adres : </b>" + eElement.getAttribute("adres");
	        	 result += "<br/><b>Datum bestelling : </b>" + eElement.getAttribute("datum");
	        	 result += "<br/><b>productnaam : </b>" + eElement.getAttribute("productnaam");
	        	 result += "<br/><b>hoeveelheid : </b>" + eElement.getAttribute("hoeveelheid");
	        	 result += "<br/>";
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get the bestelling with bestelling_id and return them 
	 * in html format
	 */
	public String getBestelling(String bestelling_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Bestelling</h2>";
	        
	        NodeList bestellingen = doc.getElementsByTagName("bestelling");

	        for (int i = 0; i < bestellingen.getLength(); i++) {
	        	
	        	 Node nNode = bestellingen.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(bestelling_id)) {
	        		 result += "<br/><b>Naam klant : </b>" + eElement.getAttribute("naam");
		        	 result += "<br/><b>adres : </b>" + eElement.getAttribute("adres");
		        	 result += "<br/><b>Datum bestelling : </b>" + eElement.getAttribute("datum");
		        	 result += "<br/><b>productnaam : </b>" + eElement.getAttribute("productnaam");
		        	 result += "<br/><b>hoeveelheid : </b>" + eElement.getAttribute("hoeveelheid");
		        	 result += "<br/>";
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get all runners for the race with race_id and return them
	 * in valid html format
	 */
	public String getProducten(String product_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Producten</h2>";
	        
	        NodeList bestellingen = doc.getElementsByTagName("bestelling");

	        for (int i = 0; i < bestellingen.getLength(); i++) {
	        	
	        	 Node bestelling = bestellingen.item(i);
	        	 Element eElement = (Element)bestelling;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase("bestelling_id")) {
	        		 NodeList producten = eElement.getElementsByTagName("product");
	        		 for (int j = 0; j < producten.getLength(); j++) {
	        			 Node product = producten.item(j);
	        			 Element eElement2 = (Element)product;
	        			 result += "<br/><b>Naam : </b>" + eElement2.getAttribute("naam");
		        		 result += "<br/><b>Producent : </b>" + eElement2.getAttribute("producent");
		        		 result += "<br/><b>Prijs : </b>" + eElement2.getAttribute("prijs");
	        		 }
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Delete the bestelling with bestelling_id and return all bestellingen in 
	 * valid format
	 */
	public String deleteRace(String race_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        
	        NodeList bestellingen = doc.getElementsByTagName("bestelling");

	        for (int i = 0; i < bestellingen.getLength(); i++) {
	        	
	        	 Node nNode = bestellingen.item(i);
	        	 Element eElement = (Element)nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase("bestelling_id")) {
	        		 eElement.getParentNode().removeChild(eElement);
	        		 Transformer transformer = TransformerFactory.newInstance().newTransformer();
	                 DOMSource source = new DOMSource(doc);
	                 StreamResult result = new StreamResult(new StringWriter());
	                 transformer.transform(source, result);
	        	 }
	        }

	        return this.getBestellingen();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**
	 * Add a bestelling and return all bestellimngen in
	 * html format
	 */
	public String addBestelling(String xml) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // set validating false to enable copying
        // node from one document to another
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
	        Element element = (Element) doc2.getDocumentElement();
	        // imports a node from doc2 document to doc1, without altering
	        // or removing the source node from the original document
	        Node copiedNode = doc1.importNode(element, true);
	        // adds the node to the end of the list of children of this node
	        doc1.getDocumentElement().appendChild(copiedNode);
	        
	        /*FileWriter fw = new FileWriter(INPUTFILE);
	        fw.write(doc1.toString());
	        fw.close();*/
	        // write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);
	        
	        return this.getBestellingen();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Add a product to bestelling with bestelling_id and 
	 * return all bestellingen in html format
	 */
	public String addProduct(String bestelling_id, String xml) {
		
		// implementation left to students
		
		return this.getBestellingen();
	}
	
	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
}
