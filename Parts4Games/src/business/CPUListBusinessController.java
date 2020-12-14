package business;

import java.util.List;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CPUListBusinessController {

	public List<String> getCPUList(int socket, int frequency, int cores, String company, String model, int generation, float price){
		
		//Get-request to Ebay API: Get all cpu's with specified requirements as JSON
		//Convert JSON to List and return
	    try {

	        Client client = Client.create();

	        WebResource webResource = client.resource("https://open.api.ebay.com/shopping?");

	        webResource.queryParam("callname", "FindProducts")
	       				.queryParam("appid", "AndreSch-Parts4Ga-SBX-87cee19be-50a4120f")//invalid appid??
	       				.queryParam("version", "1137")
	       				.queryParam("QueryKeywords", "CPU");

	        ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

	        if (response.getStatus() != 200) {
	    	   throw new RuntimeException("Failed : HTTP error code : "
	    			   + response.getStatus());
	        }

	        String output = response.getEntity(String.class);
	        
	        //Objectumwandlung um mit response arbeiten zu können 
	       
	       

	        System.out.println("Output from Server .... \n");
	        System.out.println(output);

	    	} catch (Exception e) {

	    		e.printStackTrace();

	    	}
		
		
		return null;
	}
}
