package edu.karima.bestellingen;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class BestellingenApplication extends Application {

	    /**
	     * Creates a root Restlet that will receive all incoming calls.
	     */
	   @Override
	   public synchronized Restlet createInboundRoot() {

	       Router router = new Router(getContext());

	       router.attach("/bestelling", BestellingenResource.class);
	       router.attach("/bestellingen/{bestelling_id}", BestellingenResource.class);
	       router.attach("/bestellingen/{bestelling_id}/product", BestellingProductenResource.class);
	       router.attach("/bestellingen/{bestelling_id}/product/{product_id}", BestellingProductenResource.class);

	       return router;
	   }
}


