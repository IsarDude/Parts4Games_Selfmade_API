package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.RAMListBusinessController;

@Path("/ramList")
public class RAMListService {
	
	private RAMListBusinessController ramListBusinessController = new RAMListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(@QueryParam("ramCapacity") String ramCapacity, @QueryParam("ramType") String ramType,
			@QueryParam("brandName") String brandName, @QueryParam("busSpeed") String busSpeed, @QueryParam("budget") String budget) {
	
		try {
			return Response.ok(ramListBusinessController.getRamList(ramCapacity, ramType, brandName, busSpeed, budget)).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}