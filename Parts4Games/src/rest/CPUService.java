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
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			CPU cpu = conf.addCpuToConfig(configId, aCpu);
			if(cpu == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check CPU Object\"}").build();
		    }
			return Response.ok(cpu).build();
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
	public Response changeCPU(@PathParam("configId") int configId, CPU aCpu) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			CPU cpu = conf.changeCPU(configId, aCpu);
			if(cpu == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check CPU Object\"}").build();
		    }
			return Response.ok(cpu).build();
		} catch (IOException e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCPU(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
		if(configId <= 0) {
			return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		}
		boolean isDeleted = conf.deleteCPU(configId);
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
