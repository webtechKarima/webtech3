package edu.karima.bestellingen;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import edu.karima.bestellingen.XMLParser;

/**
 * This resource represents all producten for a bestelling instance
 */
public class BestellingProductenResource extends ServerResource {

	@Get("html")
	public String getRunners() {
		String bestelling_id = getAttribute("bestelling_id");
		XMLParser parser = new XMLParser();
		return parser.getProducten(bestelling_id);
	}

}
