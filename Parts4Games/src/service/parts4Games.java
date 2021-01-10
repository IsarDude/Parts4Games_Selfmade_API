package service;

import javax.json.stream.JsonGenerator;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("*") // reagiert auf alle Anfragen auf die URL 
public class parts4Games extends ResourceConfig {
	 public parts4Games() {
		 packages("rest").register(DeclarativeLinkingFeature.class); // Wo liegen die Klassen der Ressourcen?
			property(JsonGenerator.PRETTY_PRINTING, true); // Wie wird JSON generiert?
	 }
}
