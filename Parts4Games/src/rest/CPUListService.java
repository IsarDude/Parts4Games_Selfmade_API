package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.CPUListBusinessController;

@Path("/cpuList")
public class CPUListService {
	
	private CPUListBusinessController cpuListBusinessController = new CPUListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCPUList(@QueryParam("processorType") String processorType, @QueryParam("socketType") String socketType,
			@QueryParam("numberOfCores") String numberOfCores, @QueryParam("clockSpeed") String clockSpeed, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
	
		try {
			return Response.ok(cpuListBusinessController.getCPUList(processorType, socketType, numberOfCores, clockSpeed, brandName, budget)).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
	

