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
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMotherboard(@PathParam("configId") int configId, Motherboard aMotherboard) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			Motherboard motherboard = conf.addMotherboardToConfig(configId, aMotherboard);
			if(motherboard == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check Motherboard Object\"}").build();
		    }
			return Response.ok(motherboard).build();
		} catch (IOException e) {
			return Response.status(500)
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
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			Motherboard motherboard = conf.changeMotherboard(configId, aMotherboard);
			if(motherboard == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check Motherboard Object\"}").build();
		    }
			return Response.ok(motherboard).build();
		} catch (IOException e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}	
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMotherboard(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
				return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
			}
			boolean isDeleted = conf.deleteMotherboard(configId);
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