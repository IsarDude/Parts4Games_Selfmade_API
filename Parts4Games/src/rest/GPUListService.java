package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.GPUListBusinessController;

@Path("/gpuList")
public class GPUListService {
	
	private GPUListBusinessController gpuListBusinessController = new GPUListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGPUList(@QueryParam("chipsetManufacturer") String chipsetManufacturer, @QueryParam("compatibleSlot") String compatibleSlot,
			@QueryParam("memoryType") String memoryType, @QueryParam("memorySize") String memorySize, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
	
		try {
			return Response.ok(gpuListBusinessController.getGPUList(chipsetManufacturer, compatibleSlot, memoryType, memorySize, brandName, budget)).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
	
