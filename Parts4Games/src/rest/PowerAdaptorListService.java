package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.PowerAdaptorListBusinessController;

@Path("/AdaptorList")
public class PowerAdaptorListService {
	
	private PowerAdaptorListBusinessController PowerAdaptorListBusinessController = new PowerAdaptorListBusinessController();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(@QueryParam("maximumPower") String maximumPower,
			@QueryParam("formFactor") String formFactor, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
		try {
			return Response.ok(PowerAdaptorListBusinessController.getPowerAdaptorList(maximumPower, formFactor, brandName, budget)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
