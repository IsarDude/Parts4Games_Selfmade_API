package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.Motherboard;

import javax.ws.rs.*;

@Path("/config/{configId}/motherboard")
public class MotherboardService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public Response createMotherboard(@PathParam("configId") int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.addMotherboardToConfig(configId, aMotherboard);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"creatred\"}").type("application/json").build();
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Response changeMotherboard(int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.changeMotherboard(configId, aMotherboard);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
		}
		return  Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteMotherboard(@PathParam("configId") int configId) {
		int control = ConfigurationController.getInstance().deleteMotherboard(configId);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	
	
	
}