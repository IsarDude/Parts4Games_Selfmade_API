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
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			RAM ram = conf.addRAMToConfig(configId, aRam);
			if(ram == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check RAM Object\"}").build();
		    }
			return Response.ok(ram).build();
		} catch (Exception e) {
			return Response.status(500)
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
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			RAM ram = conf.changeRAM(configId, aRam);
			if(ram == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check RAM Object\"}").build();
		    }
			return Response.ok(ram).build();
		} catch (Exception e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRAM(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
				return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
			}
			boolean isDeleted = conf.deleteRAM(configId);
			if(isDeleted) {
				return Response.status(200).entity("{\"state\":\" 200 Deleted\"}").type(MediaType.APPLICATION_JSON).build();	
			}
			return Response.status(404).entity("{\"state\":\"404 Config Not Found for ID: " + configId + "\"}").type(MediaType.APPLICATION_JSON).build();
			} catch (Exception e) {
				return Response.status(500)
						.type(MediaType.APPLICATION_JSON)
						.entity(e.getMessage())
						.build();
			}
	}
}