package business;

import java.util.List;

<<<<<<< HEAD
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GPUListBusinessController {
	
	public List<String> getGPUList(int frequency, int memory, String company, String model, String generation, float price){
		//Get-request to Ebay API: Get all gpus's with specified requirements as JSON
		//Convert JSON to List and return
		
		try {

	        Client client = Client.create();

	        WebResource webResource = client.resource("https://open.api.ebay.com/shopping?");

	        webResource.queryParam("callname", "FindProducts")
	       				.queryParam("appid", "AndreSch-Parts4Ga-SBX-87cee19be-50a4120f")//invalid appid??
	       				.queryParam("version", "1137")
	       				.queryParam("QueryKeywords", "GPU");

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
	}
}
