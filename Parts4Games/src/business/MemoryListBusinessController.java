package business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource; 

public class MemoryListBusinessController {
	
	public List<String> getMemoryList(String brand, String model, String interFace, String formFactor, String type, float price) throws IOException{
		
		try {
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
	    	}
		
		
		
		/* LOW LEVEL IMPLEMENTIERUNG (deprecated)
		//Get-request to Ebay API: Get all memories with specified requirements as JSON and return as JSON
		
		//Frage: Sollen wir JSON returnen oder eine List? Im Endpoint wird nämlich produces "JSON" angegeben.
			
		//ItemFilter sind produktunabhängige Filter
		//AspectFilter sind produktspezifische Filter
		String urlString = "https://svcs.ebay.com/services/search/FindingService/v1?"
				+ "OPERATION-NAME=findItemsAdvanced&"
				+ "SERVICE-VERSION=1.0.0&"
				+ "SECURITY-APPNAME=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&"
				+ "RESPONSE-DATA-FORMAT=JSON&"
				+ "REST-PAYLOAD&"
				+ "categoryId=182085" //ID für Festplatten
				+ "descriptionSearch=true&" //"true" bedeutet, auch die Artikelbeschreibungen werden auf die keywords hin durchsucht
				//ToDo: Max & Min Price als Parameter später dynamisch in den url-String einfügen
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
				+ "aspectFilter(1).aspectName=Storage%20Capacity&"
				+ "aspectFilter(1).aspectValueName=1%20TB&"
				//Frage: Sind die keywords als query bei uns tatsächlich gut für das Suchergebnis?
				+ "keywords=" + Integer.toString(speed) + "%20" + model + "%20" + Integer.toString(version);
				
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
			
			JSONObject memoryList = new JSONObject(response.toString());
			return memoryList;
		} else {
			return null;
		}*/
	}
}