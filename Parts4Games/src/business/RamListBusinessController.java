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
			filteredTitlesAndPrices = new HashMap<String, String>();
			filterTitlesAndPrices(getRamTitlesAndPrices(ramCapacity, budget));
			List<RAM> ramList = new ArrayList<RAM>();
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
					+ "categoryId=170083&"
					+ "descriptionSearch=false&" 
					+ "itemFilter(0).name=MaxPrice&"
					+ "itemFilter(0).value=" + budget + ".00&" //Format: 200.00
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
		/* Aus JSON den Titel & Preis parsen und die RAM Bezeichnung/Preis in filteredTitlesAndPrices stecken. ACHTUNG: Nur Sofortkäufe beachten
		 * Nur die nehmen, wo die Titel:
		 * 	- in den ersten 2 Wörtern kein Satzzeichen an erster Stelle haben
		 * 	- in den ersten 2 Wörtern Samsung, Crucial, Ballistix, A-tech, Corsair, Kingston, XPG, SK, G.SKILL, Ramaxel enthalten ist
		 * Prüfen ob Titel bereits in Hashmap vorhanden ist. Falls nein, Titel/Preis hinzufügen. Falls ja, Preis vergleichen und billigeren Titel/Preis nehmen
		 * Insgesamt sollen 10 sinnvolle RAM-Objekte in der Hashmap gespeichert werden
		 */
		
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		for (int i = 0; filteredTitlesAndPrices.size() < 10; i++) {
			
			List<String> listingTypes = JsonPath.read(document, "$..item.[" + i + "]..listingType.*");
			String currentListingType = listingTypes.get(0);
			String neededListingType = "FixedPrice";
			if (currentListingType.equals(neededListingType)) { //Wenn das Angebot ein Sofortkauf ist
				List<String> titles = JsonPath.read(document, "$..item.[" + i + "].title.*");
				String currentTitle = titles.get(0);
				System.out.println("CURRENTTITLE: "+ currentTitle);
				String[] currentTitleSplitted = currentTitle.split("\\s+"); //Nur die ersten 2 Wörter aus dem Gesamttitel benutzen für weiteres Vorgehen
				String titlePartOne = currentTitleSplitted[0].replaceAll("\\s+", "");
				String titlePartTwo = currentTitleSplitted[1].replaceAll("\\s+", "");
				String titleForQuery = titlePartOne + " " + titlePartTwo;
				System.out.println("TITLEFORQUERY: "+ titleForQuery);
				List<String> prices = JsonPath.read(document, "$..item.[" + i + "].sellingStatus.*.currentPrice.*.__value__");
				String currentPrice = prices.get(0);
				System.out.println("CURRENTPRICE: "+ currentPrice);
				if (titles.size() != 0 && prices.size() != 0 && checkTitle(titlePartOne,titlePartTwo)) { //Wenn der Titel sinnvoll ist
					if (compareTitles(titleForQuery)) { //Wenn der Titel noch nicht in filteredTitlesAndPrices vorhanden ist, füge Titel und Preis zu filteredTitlesAndPrices hinzu
						System.out.println("TITEL WAR NOCH NICHT IN HASHMAP");
						title = titleForQuery;
						price = currentPrice;
						filteredTitlesAndPrices.put(title, price);
						System.out.println("TITEL & PREIS STORED");
						System.out.println(" ");
					} else { //Wenn der Titel bereits in filteredTitlesAndPrices vorhanden ist, vergleiche Preise und nimm den billigeren
						if (comparePrices(titleForQuery, currentPrice)) {
							System.out.println("TITEL WAR BEREITS IN HASHMAP. NEHME NIEDRIGEREN PREIS");
							title = titleForQuery;
							price = currentPrice;
							filteredTitlesAndPrices.put(title, price);
						}
					}
				}
			}
		}
	}
	
	private boolean checkTitle(String titlePart1, String titlePart2) {
		/*true falls:
		 * die Titel-Teile beide mit einem Buchstaben anfangen oder einer Zahl
		 * die Titel-Teile als letzten Buchstaben entweder einen Buchstaben oder eine Zahl haben
		 * die Titel-Teile eins davon enthalten: Samsung, Crucial, Ballistix, A-tech, Corsair, Kingston, XPG, SK, G.SKILL, Ramaxel
		 */
		
		System.out.println("ENTERED CHECKTITLE");
		System.out.println("TITLEPART1: " + titlePart1);
		System.out.println("TITLEPART2: " + titlePart2);
		
		String featuredBrand1 = "Samsung";
		String featuredBrand2 = "Crucial";
		String featuredBrand3 = "Ballistix";
		String featuredBrand4 = "A-tech";
		String featuredBrand5 = "Corsair";
		String featuredBrand6 = "Kingston";
		String featuredBrand7 = "XPG";
		String featuredBrand8 = "SK";
		String featuredBrand9 = "G.SKILL";
		String featuredBrand10 = "Ramaxel";
		String featuredBrand11 = "HyperX";
		
		//string.substring(string.length() - 1) letzte Char vom String als String
		//int lastIndexOf(String substring) gibt index von diesem Char
		//Character.isLetterOrDigit(string.charAt(i)) checkt of Stelle i ein Buchstabe oder Zahl ist
		//Vereint: Character.isLetterOrDigit(titlePart1.charAt(titlePart1.lastIndexOf(titlePart1.substring(titlePart1.length() - 1))))
		
		
		if ((Character.isDigit(titlePart1.charAt(0)) || Character.isLetter(titlePart1.charAt(0)) ||  Character.isLetterOrDigit(titlePart1.charAt(titlePart1.lastIndexOf(titlePart1.substring(titlePart1.length() - 1))))) && (Character.isDigit(titlePart2.charAt(0)) || Character.isLetter(titlePart2.charAt(0))) ||  Character.isLetterOrDigit(titlePart2.charAt(titlePart2.lastIndexOf(titlePart2.substring(titlePart2.length() - 1))))) {
			System.out.println("PASSED FIRST TEST");
			if (titlePart1.toLowerCase().contains(featuredBrand1.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand2.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand3.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand4.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand5.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand6.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand7.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand8.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand9.toLowerCase()) || 
				titlePart1.toLowerCase().contains(featuredBrand10.toLowerCase()) ||
				titlePart1.toLowerCase().contains(featuredBrand11.toLowerCase()) ||
				titlePart2.toLowerCase().contains(featuredBrand1.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand2.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand3.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand4.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand5.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand6.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand7.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand8.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand9.toLowerCase()) || 
				titlePart2.toLowerCase().contains(featuredBrand10.toLowerCase()) ||
				titlePart2.toLowerCase().contains(featuredBrand11.toLowerCase())) {
				
				System.out.println("PASSED SECOND TEST");
				System.out.println("GOOD TITLE DETECTED");
				
				return true;
			}
		}
		System.out.println("BAD TITLE DETECTED");
		System.out.println(" ");
		return false;
	}
	
	private boolean compareTitles(String key) {
		/*true falls:
		 * der übergebene key noch nicht in filteredTitlesAndPrices vorhanden ist 
		 */
		if (filteredTitlesAndPrices.containsKey(key)) {
			return false;
		}
		return true;
		
	}
	
	private boolean comparePrices(String key, String price) {
		/*true falls:
		 * der übergebene Preis niedriger ist als der aktuelle Preis vom key in filteredTitlesAndPrices
		 */
		System.out.println("STOREDPRICE: " + filteredTitlesAndPrices.get(key));
		float storedPrice = Float.valueOf(filteredTitlesAndPrices.get(key));
		float newPrice = Float.valueOf(price);
		if (newPrice < storedPrice) {
			System.out.println("STORED PRICE IS WORSE THAN NEW PRICE");
			return true;
		}
		System.out.println("STORED PRICE IS BETTER THAN NEW PRICE");
		System.out.println(" ");
		return false;
	}
	
	private String getRamSpecifics(String ramIdentifier) throws IOException{
		//Anfrage an Ebay-FindProducts-API
		
		String goodRamIdentifier = ramIdentifier.replaceAll("\\s+", "%20");
		System.out.println("");
		System.out.println("RAMIDENTIFIER: " + goodRamIdentifier);
		try {
			String uri = "https://open.api.ebay.com/shopping?"
						+ "version=1157&"
						+ "appid=AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34&"
						+ "responseencoding=JSON&"
						+ "callname=FindProducts&"
						+ "QueryKeywords=" + goodRamIdentifier +"&"
						+ "PageNumber=1";
			
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
        if(totalcapacities.size() != 0) {
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