package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.PowerAdaptorBusinessController;
import data.PowerAdaptorDO;

@Path("/config/{configId}/powerAdaptor")
public class PowerAdaptorService {
	
	@Inject 
	private PowerAdaptorBusinessController powerAdaptorBusinessController;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addPowerAdaptor(@PathParam("configId") String configId, PowerAdaptorDO powerAdaptorDO) {
		try {
			powerAdaptorBusinessController.addPowerAdaptor(powerAdaptorDO);
			return Response.status(200).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changePowerAdaptor(@PathParam("configId") String configId, PowerAdaptorDO powerAdaptorDO) {
		try {
			powerAdaptorBusinessController.changePowerAdaptor(powerAdaptorDO);
			return Response.status(200).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response changePowerAdaptor(@PathParam("configId") String configId) {
		try {
			powerAdaptorBusinessController.deletePowerAdaptor();
			return Response.status(204).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}