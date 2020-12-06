package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.MemoryListBusinessController;

@Path("/memoryList")
public class MemoryListService {

	@Inject
	private MemoryListBusinessController memoryListBusinessController;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(String company, String model, int version, int capacity, int speed) {
		try {
			return Response.ok(memoryListBusinessController.getMemoryList(company, model, version, capacity, speed)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
}
	

