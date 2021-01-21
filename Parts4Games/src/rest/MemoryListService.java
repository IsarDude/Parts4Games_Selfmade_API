package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.MemoryListBusinessController;
import data.Memory;

@Path("/memoryList")
public class MemoryListService {
	
	private MemoryListBusinessController memoryListBusinessController = new MemoryListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMemoryList(@QueryParam("storageCapacity") String storageCapacity, @QueryParam("type") String type,
			@QueryParam("rotationSpeed") String rotationSpeed, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
	
		try {
			List<Memory> memoryList = memoryListBusinessController.getMemoryList(storageCapacity, type, rotationSpeed, brandName, budget);
			if(memoryList.size() == 0) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No Memories Found. Check Query Param Values\"}").build();
			}
			return Response.ok(memoryList).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}

