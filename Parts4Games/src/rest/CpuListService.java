package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.CpuListBusinessController;

@Path("/cpuList")
public class CpuListService {
/*
	@Inject
	private CpuListBusinessController CpuListBusinessController;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCPUList(int socket, int frequency, int cores, String company, String model, int generation, float price) {
		try {
			return Response.ok(CpuListBusinessController.getCPUList(socket, frequency, cores, company, model, generation, price)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
	*/
}
	

