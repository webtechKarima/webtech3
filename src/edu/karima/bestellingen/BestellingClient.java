package edu.karima.bestellingen;
import org.restlet.resource.ClientResource;


public class BestellingClient {

     public static void main(String[] args) {
           
             try {
            	ClientResource resource = new ClientResource("http://localhost:8081/Bestellingen/bestelling");
            	// Post a new bestelling
            	String bestelling = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            	bestelling += "<bestelling naam=\"Karima\" adres=\"Heidestraat\" datum=\"13/07/2016\" productnaam=\"New Macbook pro\" hoeveelheid=\"1\" id=\"25\"><uri>bestelling/25</uri>";
            	bestelling += "<description>De volgende loop</description>";
            	bestelling += "<bestellingen></bestellingen></bestelling>";
        		resource.post(bestelling);
        		// get the response
            	System.out.println(resource.getResponseEntity().getText());
            }
            catch (Exception e) {
                System.out.println("In main : " + e.getMessage());
            }
        }
    }
