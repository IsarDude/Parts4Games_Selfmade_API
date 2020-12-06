package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import model.GPU;

@Path("/config/{configId}/gpu")
public class GpuRessource {
	
	@POST // Bei POST auf die URL der Klasse
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public GPU createGPU(@PathParam("configId") int configId , GPU aGpu) {
		
		return gpu;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response changeGPU(@PathParam("config") int configId, GPU aGpu) {
		return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response deleteGPU(@PathParam("config") int configId) {
		
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
	}
	
	
	
	
}
