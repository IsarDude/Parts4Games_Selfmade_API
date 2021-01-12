package business;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.RAM;

public class RamListBusinessController {
	
	public List<RAM> getRamList(String queryKeyword) throws IOException{
		try {
			String uri = "open.api.ebay.com/shopping?version=1157&appid=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&responseencoding=JSON&"
					+ "callname=FindProducts&QueryKeywords=" + queryKeyword + "&PageNumber=1";
			
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String responseString = response.readEntity(String.class);
	        
	        //Aufbereitung der Daten. Erstelle Ram Objects stecke die in eine Ram Liste und gebe die zurück.
	        
	        return null;    
	        
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*try {
	        Client client = Client.create();
	        WebResource webResource = client.resource("https://svcs.ebay.com/services/search/FindingService/v1?");
	        webResource.queryParam("OPERATION-NAME", "findItemsAdvanced")
	        			.queryParam("SERVICE-VERSION", "1.0.0")
	       				.queryParam("SECURITY-APPNAME", "AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34")
	       				.queryParam("x", "x");
	        ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);
	        if (response.getStatus() != 200) {
	    	   throw new RuntimeException("Failed : HTTP error code : "
	    			   + response.getStatus());
	        }
	        
	        //Objectumwandlung um mit response arbeiten zu können überhaupt nötig? Wir befüllen mit der response ja kein Object bei uns.
	        
	        String output = response.getEntity(String.class);
	        System.out.println("Output from Server .... \n");
	        System.out.println(output);
	        
	        //How to return JSON?
	        return null;
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		return null;
	    	}*/
		
		
			
		/* LOW LEVEL IMPLEMENTIERUNG (deprecated)
		//Get-request to Ebay API: Get all rams with specified requirements as JSON and return as JSON
		
		//Frage: Sollen wir JSON returnen oder eine List? Im Endpoint wird nämlich produces "JSON" angegeben.
			
		//ItemFilter sind produktunabhängige Filter
		//AspectFilter sind produktspezifische Filter
		String urlString = "https://svcs.ebay.com/services/search/FindingService/v1?"
				+ "OPERATION-NAME=findItemsAdvanced&"
				+ "SERVICE-VERSION=1.0.0&"
				+ "SECURITY-APPNAME=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&"
				+ "RESPONSE-DATA-FORMAT=JSON&"
				+ "categoryId=170083" //ID für Festplatten
				+ "descriptionSearch=true&" //"true" bedeutet, auch die Artikelbeschreibungen werden auf die keywords hin durchsucht
				//ToDo: Max & Min Price als Parameter später dynamisch in den url-String einfügen
				//ToDo: Nur Sofortkauf Angebote zurückliefern, um reale Preise zu haben
				+ "itemFilter(0).name=MaxPrice&"
				+ "itemFilter(0).value=200.00&"
				+ "itemFilter(0).paramName=Currency&"
				+ "itemFilter(0).paramValue=EUR&"
				+ "itemFilter(1).name=MinPrice&"
				+ "itemFilter(1).value=1.00&"
				+ "itemFilter(1).paramName=Currency&"
				+ "itemFilter(1).paramValue=EUR&"
				//ToDo: AspectNames & Values später dynamisch in den url-String einfügen
				+ "aspectFilter(0).aspectName=Brand&"
				+ "aspectFilter(0).aspectValueName=Crucial&"
				+ "aspectFilter(1).aspectName=Total%20Capacity&"
				+ "aspectFilter(1).aspectValueName=8%20GB&"
				+ "aspectFilter(2).aspectName=Type&"
				+ "aspectFilter(2).aspectValueName=DDR3%20SDRAM&"
				//Frage: Sind die keywords als query bei uns tatsächlich gut für das Suchergebnis?
				+ "keywords=" + model + "%20" + Integer.toString(frequency);
				
		URL obj = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JSONObject ramList = new JSONObject(response.toString());
			return ramList;
		} else {
			return null;
		}*/
	}
}