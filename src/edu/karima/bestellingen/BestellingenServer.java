package edu.karima.bestellingen;

import org.restlet.*;
import org.restlet.data.Protocol;



public class BestellingenServer {

	public static void main(String[] args) {
		
		try {
			// Create a new Component.
		    Component component = new Component();
	
		    // Add a new HTTP server listening on port 8181.
		    component.getServers().add(Protocol.HTTP, 8181);
	
		    // Attach the sample application.
		    component.getDefaultHost().attach("/bestelling", BestellingResource.class);
		    component.getDefaultHost().attach("/bestelling/{bestelling_id}", BestellingResource.class);
		    component.getDefaultHost().attach("/bestelling/{bestelling_id}/product",BestellingProductenResource.class);
		    component.getDefaultHost().attach("/bestelling/{bestelling_id}/product/{product_id}", BestellingProductResource.class);
		    
			component.start();
		} 
	    catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}


