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

import data.GPU;


public class GpuListBusinessController {
	
	

	String shoppingUrl = "http://open.api.ebay.com/shopping";
	String version = "1157";
	String appid = "AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34";
	String responsencoding = "JSON";
	String callname = "FindProducts";
	String pageNumber = "1";

	public List<GPU> getGPUList(String keywords){
		
		
		String keyword = "gtx 1080";
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
		
		GPU temp = new GPU();
		
		List<String> brand = JsonPath.read(json, "$..NameValueList[0].Value[0]" );
		List<String> ProductEAN = JsonPath.read(json, "$..ProductID[0].Value" );
		List<String> CompatibleSlot = JsonPath.read(json, "$..NameValueList[6].Value[0]" );
		List<String> ChipsetManufacturer = JsonPath.read(json, "$..NameValueList[8].Value[0]" );
		List<String> ChipsetSlotMemory = JsonPath.read(json, "$..NameValueList[10].Value[0]" );
		
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
