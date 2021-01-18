package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import java.io.IOException;

import javax.ws.rs.*;

import data.CPU;

@Path("/config/{configId}/cpu")
public class CPUService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCPU(@PathParam("configId") int configId , CPU aCpu) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.addCpuToConfig(configId, aCpu)).build();
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
	public Response changeCPU(@PathParam("configId") int configId, CPU aCpu) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.changeCPU(configId, aCpu)).build();
		} catch (IOException e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCPU(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		boolean isDeleted = conf.deleteCPU(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}	
}
