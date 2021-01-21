package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.CPUListBusinessController;
import data.CPU;

@Path("/cpuList")
public class CPUListService {
	
	private CPUListBusinessController cpuListBusinessController = new CPUListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCPUList(@QueryParam("processorType") String processorType, @QueryParam("socketType") String socketType,
			@QueryParam("numberOfCores") String numberOfCores, @QueryParam("clockSpeed") String clockSpeed, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
	
		try {
			List<CPU> cpuList = cpuListBusinessController.getCPUList(processorType, socketType, numberOfCores, clockSpeed, brandName, budget);
			if(cpuList.size() == 0) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No CPUs Found. Check Query Param Values\"}").build();
			}
			return Response.ok(cpuList).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
	

