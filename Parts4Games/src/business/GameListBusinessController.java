package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import data.GameIdentifier;

public class GameListBusinessController{
	
	public List<GameIdentifier> getGameList(String gameName) throws IOException{ 
		
		try {
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target("https://api.steampowered.com/ISteamApps/GetAppList/v2");
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class);
	        String json = response.readEntity(String.class);
	        
	        //Die Liste parsen nach dem gamename
	        //GameIdentifier Objects erstellen und füllen
	        //Diese in eine Liste packen
	        //Zurückgeben
	        List<GameIdentifier> gameIdentifiers = new ArrayList<GameIdentifier>();
	        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
	        int arrayLength = JsonPath.read(document, "$.applist.apps.length()");
	        for (int i = 0; i < arrayLength; i++) {
	        	String curGameName = JsonPath.read(document, "$.applist.apps[" + i + "].name");
	        	if (curGameName.toLowerCase().contains(gameName.toLowerCase())) {
	        		int gameId = JsonPath.read(document, "$.applist.apps[" + i + "].appid");
	        		GameIdentifier gameIdentifier = new GameIdentifier(curGameName, gameId);
	        		gameIdentifiers.add(gameIdentifier);
				}
			}
	        
	        return gameIdentifiers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
