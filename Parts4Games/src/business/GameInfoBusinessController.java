package business;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jayway.jsonpath.JsonPath;

import data.GameInfo;

public class GameInfoBusinessController {

	public GameInfo getGameInfoRec(int gameId) throws IOException{
		
		try {
			String uri = "https://store.steampowered.com/api/appdetails/?appids=" + gameId;
			
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String json = response.readEntity(String.class);
	        
	        //Response parsen nach PC_Requirements Rec
	        //GameInfo Object erstellen und füllen
	        //Zurückgeben
	        
	        String recHardwareReq = JsonPath.read(json, "$.data.pc_requirements.recommended");
	        GameInfo gameInfo = new GameInfo(recHardwareReq);
	      
	        return gameInfo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public GameInfo getGameInfoMin(int gameId) throws IOException{
			
			try {
				String uri = "https://store.steampowered.com/api/appdetails/?appids=" + gameId;
				
				Client client = ClientBuilder.newClient();
		        WebTarget webTarget = client.target(uri);
		        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		        Response response = invocationBuilder.get(Response.class); 
		        String json = response.readEntity(String.class);
		        
		        //Response parsen nach PC_Requirements Min 
		        //GameInfo Object erstellen und füllen
		        //Zurückgeben
		        
		        String minHardwareReq = JsonPath.read(json, "$.data.pc_requirements.minimum");
		        GameInfo gameInfo = new GameInfo(minHardwareReq);
		      
		        return gameInfo;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
