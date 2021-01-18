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
	public Response addPowerAdaptor(@PathParam("configId") int configId, PowerAdaptor powerAdaptor) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.addPowerAdaptorToConfig(configId, powerAdaptor)).build();
		}catch(Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePowerAdaptor(@PathParam("configId") int configId, PowerAdaptor powerAdaptor) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.changePowerAdaptor(configId, powerAdaptor)).build();
		}catch(Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePowerAdaptor(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		boolean isDeleted = conf.deletePowerAdaptor(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
}