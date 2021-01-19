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
import data.PowerAdaptor;

@Path("/config/{configId}/powerAdaptor")
public class PowerAdaptorService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPowerAdaptor(@PathParam("configId") int configId, PowerAdaptor aPowerAdaptor) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			PowerAdaptor powerAdaptor = conf.addPowerAdaptorToConfig(configId, aPowerAdaptor);
			if(powerAdaptor == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check Power Adaptor Object\"}").build();
		    }
			return Response.ok(powerAdaptor).build();
		}catch(Exception e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePowerAdaptor(@PathParam("configId") int configId, PowerAdaptor aPowerAdaptor) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			PowerAdaptor powerAdaptor = conf.changePowerAdaptor(configId, aPowerAdaptor);
			if(powerAdaptor == null) {
		        return Response.status(422).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"422 Unprocessable Entity. Check Power Adaptor Object\"}").build();
		    }
			return Response.ok(powerAdaptor).build();
		}catch(Exception e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePowerAdaptor(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
				return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
			}
			boolean isDeleted = conf.deletePowerAdaptor(configId);
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