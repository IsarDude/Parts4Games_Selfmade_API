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

import data.RAM;

public class RamListBusinessController {
	
	private String productID;
	private String brand;
	private String model;
	private String busSpeed;
	private String type;
	private String totalcapacity;
	private String fotoURL;
	
	public List<RAM> getRamList(String brandParam, String modelParam, String capacityParam) throws IOException{
	
		try {
			String mediumRamQuery = "Corsair%20Vengeance%2016GB";
			String uri = "https://open.api.ebay.com/shopping?version=1157&appid=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&responseencoding=JSON&callname=FindProducts&" + ""
						+ "QueryKeywords=" + brandParam + "%20" + modelParam + "%20" + capacityParam
						+ "&PageNumber=1";
			
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String json = response.readEntity(String.class);
	        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
	        
	        //Aufbereitung der Daten. Erstelle Ram Objects stecke die in eine Ram Liste und gebe die zurück.
	        
	        List<RAM> ramList = new ArrayList<RAM>();
	        

	        List<String> productIDs = JsonPath.read(document, "$..ProductID[?(@.Type == 'EAN')].Value");
	        System.out.println("ProductIDsListe Größe:" + productIDs.size());
	        if(productIDs.size() != 0) {
	        	productID = productIDs.get(0);
	        }else {
	        	productID = null;
	        }
	        
	        List<String> brands = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Brand')].Value.*");
	        if(brands.size() != 0) {
	        	brand = brands.get(0);
	        }else {
	        	brand = null;
	        }
	        
	        List<String> models = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Model')].Value.*");
	        if(models.size() != 0) {
	        	model = models.get(0);
	        }else {
	        	model = null;
	        }
	        
	        List<String> busSpeeds = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Bus Speed')].Value.*");
	        if(busSpeeds.size() != 0) {
	        	busSpeed = busSpeeds.get(0);
	        }else {
	        	busSpeed = null;
	        }
	        
	        List<String> types = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Type')].Value.*");
	        if(types.size() != 0) {
	        	type = types.get(0);
	        }else {
	        	type = null;
	        }
	        
	        List<String> totalcapacities = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Total Capacity')].Value.*");
	        if(types.size() != 0) {
	        	totalcapacity = totalcapacities.get(0);
	        }else {
	        	totalcapacity = null;
	        }
	        
	        List<String> fotoURLs = JsonPath.read(document, "$..StockPhotoURL");
	        if(fotoURLs.size() != 0) {
	        	fotoURL = fotoURLs.get(0);
	        }else {
	        	fotoURL = null;
	        }
	        
	        float price = 0f;
	        
	        RAM mediumRam = new RAM(productID, brand, model, totalcapacity, type, busSpeed, fotoURL, price);
	        ramList.add(mediumRam);
	        
	        return ramList;    
	        
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
				

			
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