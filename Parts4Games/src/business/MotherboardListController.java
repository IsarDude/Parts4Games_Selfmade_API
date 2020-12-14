package business;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MotherboardListController {
	public List<String> getMotherboardList(int aSocket, int aFrontSideBus, String aFormfactor, String aCompany, String aModel, String aChipset, String aDdrMemory, float aPrice){
		//Get-request to Ebay API: Get all motherboards with specified requirements as JSON
		//Convert JSON to List and return
		
		try {

	        Client client = Client.create();

	        WebResource webResource = client.resource("https://open.api.ebay.com/shopping?");

	        webResource.queryParam("callname", "FindProducts")
	       				.queryParam("appid", "AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34")//invalid appid??
	       				.queryParam("version", "1137")
	       				.queryParam("QueryKeywords", "GPU");

	        ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

	        if (response.getStatus() != 200) {
	    	   throw new RuntimeException("Failed : HTTP error code : "
	    			   + response.getStatus());
	        }

	        String output = response.getEntity(String.class);
	        
	        //Objectumwandlung  
	       
	       

	        System.out.println("Output from Server .... \n");
	        System.out.println(output);

	    	} catch (Exception e) {

	    		e.printStackTrace();

	    	}
	}
}
