package business;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.Motherboard;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class MotherboardListController {
	
	String shoppingUrl = "http://open.api.ebay.com/shopping";
	String version = "1157";
	String appid = "AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34";
	String responsencoding = "JSON";
	String callname = "FindProducts";
	String pageNumber = "1";
	
	
	public List<Motherboard> getMotherboardList(String keywords){
		List<Motherboard> motherboardList = new LinkedList<Motherboard>();
		
		//hier die suchbegriffe
		String expensive = "";
		String medium = "";
		String lowbudget= "";
		
		motherboardList.add(
				JsonToObject(
						MakeRequestToEbay(expensive)
						));
		motherboardList.add(
				JsonToObject(
						MakeRequestToEbay(medium)
						));
		motherboardList.add(
				JsonToObject(
						MakeRequestToEbay(lowbudget)
						));		
		
		return motherboardList;
	}
	
	private String MakeRequestToEbay(String keywords) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(shoppingUrl);
		webTarget = webTarget.queryParam("version", version)
		.queryParam("appid", appid)
		.queryParam("responseencoding", responsencoding)
		.queryParam("callname", callname)
		.queryParam("QueryKeywords", keywords)
		.queryParam("PageNumber", 1);
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response
			= invocationBuilder.get();
		
		String json = response.readEntity(String.class);
<<<<<<< HEAD
		System.out.println(json);
		
		
		Motherboard temp = new Motherboard();
		
		//noch an Motherboard anpassen
		List<String> brand = JsonPath.read(json, "$..NameValueList[0].Value[0]" );
		List<String> ProductEAN = JsonPath.read(json, "$..ProductID[0].Value" );
		List<String> MaximumPower = JsonPath.read(json, "$..NameValueList[2].Value[0]" );
		List<String> formFactor =JsonPath.read(json, "$..NameValueList[3].Value[0]" );
		List<String> photoUrl = JsonPath.read(json, "$..StockPhotoURL");
		System.out.println(brand);
		
		
		System.out.println(response);
		if (response.getStatus() == 200) {
		     StringReader stringReader = new StringReader(webTarget.request(MediaType.APPLICATION_JSON).get(String.class));
		     try (JsonReader jsonReader = Json.createReader(stringReader)) {
		        System.out.println(jsonReader.readObject());
		     }
=======
		return json;
>>>>>>> adaptorListObjectification
	}
	
	public Motherboard JsonToObject(String json) {
		Motherboard temp = new Motherboard();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		//noch an Motherboard anpassen
		List<String> brand = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Brand')].Value[0]");
		List<String> maximumPower = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Maximum Power')].Value[0]");
		List<String> formFactor = JsonPath.read(document, "$..NameValueList[?(@.Name == 'Form Factor')].Value[0]");
		List<String> productIdEAN = JsonPath.read(document, "$..ProductID[?(@.Type == 'EAN')].Value");
		
		if(brand.size()> 0) {
			temp.setBrand(brand.get(0));
		}

		if(maximumPower.size()> 0) {
			temp.setMaximumPower(maximumPower.get(0));
		}
		if(formFactor.size()>0) {
			temp.setFormfactor(formFactor.get(0));
		}
		if(productIdEAN.size()>0) {
			temp.setProductIdEAN(productIdEAN.get(0));
		}
		return temp;
	}
	
}