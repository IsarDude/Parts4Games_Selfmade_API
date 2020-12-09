package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.GPUListBuisnessController;

@Path("/gpuList")
public class GPUListService {

	@Inject
	private GPUListBuisnessController GPUListBuisnessController;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCPUList(int frequency, int memory, String company, String model, String generation, float price) {
		try {
			return Response.ok(GPUListBuisnessController.getGPUList(frequency, memory, company, model, generation, price)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
}
	

