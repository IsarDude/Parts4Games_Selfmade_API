package business;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.GameInfo;

public class GameInfoBusinessController {

	public List<GameInfo> getGameInfoRec(int gameId)  throws IOException{
		
		try {
			String uri = "https://store.steampowered.com/api/appdetails/?appids=" + gameId;
			
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String responseString = response.readEntity(String.class);
	        
	        //Response parsen nach PC_Requirements Rec
	        //GameInfo Object erstellen und füllen
	        //Zurückgeben
	        
	        return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getGameInfoMin(int gameId)  throws IOException{
			
			try {
				String uri = "https://store.steampowered.com/api/appdetails/?appids=" + gameId;
				
				Client client = ClientBuilder.newClient();
		        WebTarget webTarget = client.target(uri);
		        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		        Response response = invocationBuilder.get(Response.class); 
		        String responseString = response.readEntity(String.class);
		        
		        //Response parsen nach PC_Requirements Min 
		        //GameInfo Object erstellen und füllen
		        //Zurückgeben
		        
		        return responseString;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
