package business;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class MotherboardListController {
	public List<String> getMotherboardList(int aSocket, int aFrontSideBus, String aFormfactor, String aCompany, String aModel, String aChipset, String aDdrMemory, float aPrice){
		//Get-request to Ebay API: Get all motherboards with specified requirements as JSON
		//Convert JSON to List and return
		
		
		
		//geändert nach:  https://gist.github.com/aphexmunky/11399575
		try {

	        Client client = ClientBuilder.newClient();

	        WebTarget target = client.target("https://open.api.ebay.com/shopping?");

	        target.queryParam("callname", "FindProducts")
	       				.queryParam("appid", "AndreSch-Parts4Ga-PRD-ff78dd8ce-c7680d34")
	       				.queryParam("version", "1137")
	       				.queryParam("QueryKeywords", "GPU");

	        Response response = target.request("application/json")
                   .get(Response.class);

	        if (response.getStatus() != 200) {
	    	   throw new RuntimeException("Failed : HTTP error code : "
	    			   + response.getStatus());
	        }

	        String output = response.readEntity(String.class);
	        
	        //Objectumwandlung  
	       
	        System.out.println("Output from Server .... \n");
	        System.out.println(output);
	        
	        return null;

	    	} catch (Exception e) {

	    		e.printStackTrace();
	    	}
		return null;
	}
}
