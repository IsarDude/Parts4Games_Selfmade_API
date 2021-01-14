package business;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private String title;
	private String price;
	
	private Map<String, String> filteredTitlesAndPrices;
	
	public List<RAM> getRamList(String ramCapacity, String budget) throws IOException{
		/* Vorgehensweise:
		 * filterTitlesAndPrices(getRamTitlesAndPrices())
		 * List<RAM> erstellen
		 * Mit jedem key aus der Hashmap jetzt ram = JsonToObject(getRamSpecifics(key)) UND ram.setPrice(map.getValue(key))
		 * List<RAM> mit ram füllen
		 * Liste returnen
		 */
		
		try {
			filterTitlesAndPrices(getRamTitlesAndPrices(ramCapacity, budget));
			List<RAM> ramList = new ArrayList<RAM>();
			filteredTitlesAndPrices = new HashMap<String, String>();
			for (Map.Entry<String, String> entry : filteredTitlesAndPrices.entrySet()) {
				RAM ramDO = JsonToObject(getRamSpecifics(entry.getKey()));
				ramDO.setPrice(entry.getValue());
				ramList.add(ramDO);
			}

			return ramList;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}				
	}
	private String getRamTitlesAndPrices(String ramCapacity, String budget) throws IOException{
		//Anfrage an Ebay-findItemsAdvanced-API

		try {
			String uri = "https://svcs.ebay.com/services/search/FindingService/v1?"
					+ "OPERATION-NAME=findItemsAdvanced&"
					+ "SERVICE-VERSION=1.0.0&"
					+ "SECURITY-APPNAME=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&"
					+ "RESPONSE-DATA-FORMAT=JSON&"
					+ "categoryId=170083"
					+ "descriptionSearch=false&" 
					+ "itemFilter(0).name=MaxPrice&"
					+ "itemFilter(0).value=" + budget + "&" //Format: 200.00
					+ "itemFilter(0).paramName=Currency&"
					+ "itemFilter(0).paramValue=EUR&"
					+ "aspectFilter(0).aspectName=Total%20Capacity&"
					+ "aspectFilter(0).aspectValueName=" + ramCapacity + "%20GB&"
					+ "aspectFilter(1).aspectName=Number%20of%20Modules&" 
					+ "aspectFilter(1).aspectValueName=1";

			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String ramSpecificsJSON = response.readEntity(String.class);
	        
	        return ramSpecificsJSON;
  
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void filterTitlesAndPrices(String json) {
		/*Aus JSON den Titel* & Preis parsen und die RAM Bezeichnung/Preis in filteredTitlesAndPrices stecken. ACHTUNG: Nur die nehmen, wo $..listingInfo.*.listingType.* == "FixedPrice"
		*Nur die nehmen, wo die Titel:
			- in den ersten 2 Wörtern kein Satzzeichen an erster Stelle oder nach dem Lerzeichen haben
			- in den ersten 2 Wörtern Samsung, Crucial, Ballistix, A-tech, Corsair, Kingston, XPG, SK, G.SKILL, Ramaxel enthalten ist*/

		//Prüfen ob Titel bereits in Hashmap vorhanden ist. Falls nein, Titel/Preis hinzufügen. Falls ja, Preis vergleichen und billigeren Titel/Preis nehmen
		//Insgesamt 10 Objekte wollen wir haben
		//Wenn Hashmap 10 hat, dann aufhören
		
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		for (int i = 0; filteredTitlesAndPrices.size() < 10; i++) {
			List<String> listingTypes = JsonPath.read(document, "$..item.[" + i + "].listingInfo.*.listingType.*");
			String currentListingType = listingTypes.get(0);
			if (currentListingType == "FixedPrice") { //Wenn das Angebot ein Sofortkauf ist
				List<String> titles = JsonPath.read(document, "$..item.[" + i + "].title.*");
				String currentTitle = titles.get(0);
				List<String> prices = JsonPath.read(document, "$..item.[" + i + "].sellingStatus.*.currentPrice.*.__value__");
				String currentPrice = prices.get(0);
				if (titles.size() != 0 && prices.size() != 0 && checkTitle(currentTitle)) { //Wenn der Titel sinnvoll ist
					if (compareTitles(currentTitle)) { //Wenn der Titel noch nicht in filteredTitlesAndPrices vorhanden ist, füge Titel und Preis zu filteredTitlesAndPrices hinzu
						title = currentTitle;
						price = currentPrice;
						filteredTitlesAndPrices.put(title, price);
					} else { //Wenn der Titel bereits in filteredTitlesAndPrices vorhanden ist, vergleiche Preise und nimm den billigeren
						if (comparePrices(currentTitle, currentPrice)) {
							title = currentTitle;
							price = currentPrice;
							filteredTitlesAndPrices.put(title, price);
						}
					}
				}
			}
		}
	}
	
	private boolean checkTitle(String title) {
		/*true falls:
		 * in den ersten 2 Wörtern kein Satzzeichen an erster Stelle oder nach dem Lerzeichen steht
		 * in den ersten 2 Wörtern Samsung, Crucial, Ballistix, A-tech, Corsair, Kingston, XPG, SK, G.SKILL, Ramaxel enthalten ist
		 */

		return false;
	}
	
	private boolean compareTitles(String key) {
		/*true falls:
		 * der übergebene key noch nicht in filteredTitlesAndPrices vorhanden ist 
		 */
		if (filteredTitlesAndPrices.containsKey(key)) {
			return true;
		}
		return false;
		
	}
	
	private boolean comparePrices(String key, String price) {
		/*true falls:
		 * der übergebene Preis niedriger ist als der aktuelle Preis vom key in filteredTitlesAndPrices
		 */
		int storedPrice = Integer.parseInt(filteredTitlesAndPrices.get(key));
		int newPrice = Integer.parseInt(price);
		if (newPrice < storedPrice) {
			return true;
		}
		return false;
	}
	
	private String getRamSpecifics(String ramIdentifier) throws IOException{
		//Anfrage an Ebay-FindProducts-API
		
		try {
			String uri = "https://open.api.ebay.com/shopping?"
						+ "version=1157&"
						+ "appid=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&"
						+ "responseencoding=JSON&"
						+ "callname=FindProducts&"
						+ "QueryKeywords=" + ramIdentifier
						+ "&PageNumber=1";
			
			Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target(uri);
	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        Response response = invocationBuilder.get(Response.class); 
	        String ramSpecificsJSON = response.readEntity(String.class);
	        
	        return ramSpecificsJSON;
  
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private RAM JsonToObject(String json) {
		//Holt die RAM Eigenschaften aus der JSON und erstellt daraus ein RAM Objekt
		
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

        List<String> productIDs = JsonPath.read(document, "$..ProductID[?(@.Type == 'EAN')].Value");
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
        
        String price = null;
        
        RAM ramDO = new RAM(productID, brand, model, totalcapacity, type, busSpeed, fotoURL, price);
        
        return ramDO;  
	}
}