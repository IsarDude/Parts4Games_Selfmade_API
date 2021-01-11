package rest;



import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.AdaptorListBusinessController;

@Path("/AdaptorList")
public class PowerAdaptorListService {
	
	private AdaptorListBusinessController PowerAdaptorListBusinessController = new AdaptorListBusinessController();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(String keywords) {
		try {
			return Response.ok(PowerAdaptorListBusinessController.getPowerAdaptorList(keywords)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
