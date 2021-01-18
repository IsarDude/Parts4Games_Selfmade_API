package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.MemoryListBusinessController;

@Path("/memoryList")
public class MemoryListService {
	
	private MemoryListBusinessController memoryListBusinessController = new MemoryListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCPUList(@QueryParam("storageCapacity") String storageCapacity, @QueryParam("type") String type,
			@QueryParam("rotationSpeed") String rotationSpeed, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
	
		try {
			return Response.ok(memoryListBusinessController.getMemoryList(storageCapacity, type, rotationSpeed, brandName, budget)).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}

