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
	
	ConfigurationController configurationController = ConfigurationController.getInstance();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPowerAdaptor(@PathParam("configId") int configId, PowerAdaptor powerAdaptor) {
		try {
			configurationController.addPowerAdaptorToConfig(configId, powerAdaptor);
			return Response.status(201).build();
		}catch(Exception e) {
			e.printStackTrace();
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
		try {
			configurationController.changePowerAdaptor(configId, powerAdaptor);
			return Response.status(200).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePowerAdaptor(@PathParam("configId") int configId) {
		try {
			configurationController.deletePowerAdaptor(configId);
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