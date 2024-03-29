package business;

import java.io.StringReader;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jayway.jsonpath.JsonPath;

import data.CPU;


public class CpuListBusinessController {
	
	

	String shoppingUrl = "http://open.api.ebay.com/shopping";
	String version = "1157";
	String appid = "AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34";
	String responsencoding = "JSON";
	String callname = "FindProducts";
	String pageNumber = "1";

	public List<CPU> getCPUList(String keywords){
		
		
		String keyword = "Ryzen 3600 x";
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(shoppingUrl);
		webTarget = webTarget.queryParam("version", version)
		.queryParam("appid", appid)
		.queryParam("responseencoding", responsencoding)
		.queryParam("callname", callname)
		.queryParam("QueryKeywords", keyword)
		.queryParam("PageNumber", 1);
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response
			= invocationBuilder.get();
		
		String json = response.readEntity(String.class);
		System.out.println(json);
		
		CPU temp = new CPU();
		
		List<String> brand = JsonPath.read(json, "$..NameValueList[0].Value[0]" );
		List<String> ProductEAN = JsonPath.read(json, "$..ProductID[0].Value" );
		List<String> Cache = JsonPath.read(json, "$..NameValueList[2].Value[0]" );
		List<String> Socket = JsonPath.read(json, "$..NameValueList[4].Value[0]" );
		List<String> NumberOfCores = JsonPath.read(json, "$..NameValueList[5].Value[0]" );
		List<String> ClockSpeed = JsonPath.read(json, "$..NameValueList[7].Value[0]" );
		
		List<String> photoUrl = JsonPath.read(json, "$..StockPhotoURL");
		System.out.println(brand);
		
		
		System.out.println(response);
		if (response.getStatus() == 200) {
		     StringReader stringReader = new StringReader(webTarget.request(MediaType.APPLICATION_JSON).get(String.class));
		     try (JsonReader jsonReader = Json.createReader(stringReader)) {
		        System.out.println(jsonReader.readObject());
		     }
	}
		return null;
	}
}
