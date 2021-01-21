package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.PowerAdaptorListBusinessController;
import data.PowerAdaptor;

@Path("/powerAdaptorList")
public class PowerAdaptorListService {
	
	private PowerAdaptorListBusinessController PowerAdaptorListBusinessController = new PowerAdaptorListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPowerAdaptorList(@QueryParam("maximumPower") String maximumPower,
			@QueryParam("formFactor") String formFactor, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
		try {
			List<PowerAdaptor> powerAdaptorList = PowerAdaptorListBusinessController.getPowerAdaptorList(maximumPower, formFactor, brandName, budget);
			if(powerAdaptorList.size() == 0) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No Power Adaptors Found. Check Query Param Values\"}").build();
			}
			return Response.ok(powerAdaptorList).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
