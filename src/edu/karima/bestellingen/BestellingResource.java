package edu.karima.bestellingen;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class BestellingResource extends ServerResource {

	@Get("html")
	public String getRace() {
		String bestelling_id = getAttribute("bestelling_id");
		XMLParser parser = new XMLParser();
		return parser.getBestelling(bestelling_id);
	}
	
	@Post("txt")
	public String addRunner(String runner) {
		String bestelling_id = getAttribute("bestelling_id");
		XMLParser parser = new XMLParser();
		return parser.addProduct(bestelling_id, runner);
	}

}
