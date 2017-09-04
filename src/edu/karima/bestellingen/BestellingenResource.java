package edu.karima.bestellingen;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.karima.bestellingen.XMLParser;

public class BestellingenResource extends ServerResource {

	@Get("html")
	public String getBestellingen() {
		XMLParser parser = new XMLParser();
		return parser.getBestellingen();
	}
	
	@Post("txt")
	public String addBestelling(String bestelling) {
		XMLParser parser = new XMLParser();
		return parser.addBestelling(bestelling);
	}

}