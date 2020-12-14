package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import business.RamListBusinessController;

@Path("/motherboardList")
public class MotherboardListService {
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getMotherboardList(int aSocket, int aFrontSideBus, String aFormfactor, String aCompany, String aModel, String aChipset, String aDdrMemory, float aPrice) {
		try {
			return Response.ok(getList(aSocket, aFrontSideBus, aFormfactor, aCompany, aModel, aChipset, aDdrMemory, aPrice)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
	
	//GET-Request to Ebay API: gets a list with all motherboards requirements as JSON
	private List<String> getList(int aSocket, int aFrontSideBus, String aFormfactor, String aCompany, String aModel, String aChipset, String aDdrMemory, float aPrice){
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("https://open.api.ebay.com/shopping?");
			
			webResource.queryParam("callname", "FindProducts").queryParam("appid", "AndreSch-Parts4Ga-SBX-87cee19be-50a4120f")
																.queryParam("version", "1137")
																.queryParam("QueryKeywords", "Motherboard");
			
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
		    	   throw new RuntimeException("Failed : HTTP error code : "
		    			   + response.getStatus());
		        }
			
			 String output = response.getEntity(String.class);
		        
		     //Objectumwandlung an dieser Stelle
			 //evtl eine klasse dafür erstellen, welche diese Aufgabe übernimmt...diese funktion wird ja öfters benötigt
			 
			 
			 System.out.println("Output from Server .... \n");
		     System.out.println(output);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
}