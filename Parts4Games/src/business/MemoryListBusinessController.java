package business;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.Memory;

public class MemoryListBusinessController {
	
	public List<Memory> getMemoryList(String queryKeyword) throws IOException{
		try {
			String uri = "open.api.ebay.com/shopping?version=1157&appid=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&responseencoding=JSON&"
					+ "callname=FindProducts&QueryKeywords=" + queryKeyword + "&PageNumber=1";
			
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String responseString = response.readEntity(String.class);
	        
	        //Aufbereitung der Daten. Erstelle Memory Objects stecke die in eine Memory Liste und gebe die zurück.
	        
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