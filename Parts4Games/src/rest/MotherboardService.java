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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON )
	public Response createMotherboard(@PathParam("configId") int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.addMotherboardToConfig(configId, aMotherboard)).build();
		} catch (IOException e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changeMotherboard(@PathParam("configId") int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.changeMotherboard(configId, aMotherboard)).build();
		} catch (IOException e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMotherboard(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		boolean isDeleted = conf.deleteMotherboard(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
}