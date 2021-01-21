package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.RAMListBusinessController;
import data.RAM;

@Path("/ramList")
public class RAMListService {
	
	private RAMListBusinessController ramListBusinessController = new RAMListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(@QueryParam("ramCapacity") String ramCapacity, @QueryParam("ramType") String ramType,
			@QueryParam("brandName") String brandName, @QueryParam("busSpeed") String busSpeed, @QueryParam("budget") String budget) {
	
		try {
			List<RAM> ramList = ramListBusinessController.getRamList(ramCapacity, ramType, brandName, busSpeed, budget);
			if(ramList.size() == 0) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No RAMs Found. Check Query Param Values\"}").build();
			}
			return Response.ok(ramList).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}