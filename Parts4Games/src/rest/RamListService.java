package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.RamListBusinessController;

@Path("/ramList")
public class RamListService {
	
	private RamListBusinessController ramListBusinessController = new RamListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(@QueryParam("brand") String brand, @QueryParam("model") String model, @QueryParam("capacity") String capacity) {
	
		try {
			return Response.ok(ramListBusinessController.getRamList(brand, model, capacity)).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
	

