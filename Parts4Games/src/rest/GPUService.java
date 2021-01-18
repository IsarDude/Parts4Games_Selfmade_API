package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.GPU;

import java.io.IOException;

import javax.ws.rs.*;

@Path("/config/{configId}/gpu")
public class GPUService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
	public Response createGPU(@PathParam("configId") int configId, GPU aGPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.addGpuToConfig(configId, aGPU)).build();
		} catch (Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
	public Response changeGPU(@PathParam("configId") int configId, GPU aGPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.changeGPU(configId, aGPU)).build();
		} catch (IOException e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces( MediaType.APPLICATION_JSON)
	public Response deleteGPU(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		boolean isDeleted = conf.deleteGPU(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
}
