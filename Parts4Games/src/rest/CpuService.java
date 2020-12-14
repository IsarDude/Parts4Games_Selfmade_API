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

import data.CPU;

@Path("/config/{configId}/cpu")
public class CpuService {
	
	@POST // Bei POST auf die URL der Klasse
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public CPU createCPU(@PathParam("configId") int configId , CPU aCpu) {
		
		return aCpu;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response changeCPU(@PathParam("config") int configId, CPU aCpu) {
		return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response deleteCPU(@PathParam("config") int configId) {
		
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
	}
	
	
	
	
}
