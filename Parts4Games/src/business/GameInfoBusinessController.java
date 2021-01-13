package business;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jayway.jsonpath.JsonPath;

import data.GameInfo;

public class GameInfoBusinessController {
	private String minHardwareReq;
	private String recHardwareReq;
	
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
	        
	        List<String> recHardwareReqs = JsonPath.read(json, "$..data.pc_requirements.recommended");
	        if(recHardwareReqs.size() != 0) {
	        	recHardwareReq = recHardwareReqs.get(0);
	        }else {
	        	recHardwareReq = null;
	        }
	      
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
		        
		        List<String> minHardwareReqs = JsonPath.read(json, "$..data.pc_requirements.minimum");
		        if(minHardwareReqs.size() != 0) {
		        	minHardwareReq = minHardwareReqs.get(0);
		        }else {
		        	minHardwareReq = null;
		        }
		        
		        GameInfo gameInfo = new GameInfo(minHardwareReq);
		      
		        return gameInfo;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
