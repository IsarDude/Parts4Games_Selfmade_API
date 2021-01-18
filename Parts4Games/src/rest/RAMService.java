package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.RAM;

import javax.ws.rs.*;

@Path("/config/{configId}/ram")
public class RAMService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
	public Response createRAM(@PathParam("configId") int configId, RAM aRam) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.addRAMToConfig(configId, aRam)).build();
		} catch (Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changeRAM(@PathParam("configId") int configId, RAM aRam) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.changeRAM(configId, aRam)).build();
		} catch (Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRAM(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		boolean isDeleted = conf.deleteRAM(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
}