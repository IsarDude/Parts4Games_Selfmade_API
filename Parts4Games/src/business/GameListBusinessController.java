package business;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.GameIdentifier;

public class GameListBusinessController{
	
	public List<GameIdentifier> getGameList(String gameName) throws IOException{ 
		
		try {
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target("https://api.steampowered.com/ISteamApps/GetAppList/v2");
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class);
	        String responseString = response.readEntity(String.class);
	        
	        //Die Liste parsen nach dem gamename
	        //GameIdentifier Objects erstellen und füllen
	        //Diese in eine Liste packen
	        //Zurückgeben
	        
	        return null;
	        

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
