package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.Motherboard;

import java.io.IOException;

import javax.ws.rs.*;

@Path("/config/{configId}/motherboard")
public class MotherboardService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public Motherboard createMotherboard(@PathParam("configId") int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.addMotherboardToConfig(configId, aMotherboard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
			
		
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Motherboard changeMotherboard(int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.changeMotherboard(configId, aMotherboard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteMotherboard(@PathParam("configId") int configId) {
		try {
			ConfigurationController.getInstance().deleteMotherboard(configId);
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
		
			
		
		
	}
	
	
	
	
}