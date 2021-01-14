package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.Memory;

@Path("/config/{configId}/memory")
public class MemoryService {
	
	ConfigurationController configurationController = ConfigurationController.getInstance();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Memory addMemory(@PathParam("configId") int configId, Memory memory) {
		try {
			
			return configurationController.addMemoryToConfig(configId, memory);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Memory changeMemory(@PathParam("configId") int configId, Memory memory) {
		try {
			
			return configurationController.changeMemory(configId, memory);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response changeMemory(@PathParam("configId") int configId) {
		try {
			configurationController.deleteMemory(configId);
			return Response.status(200).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	
	
}
