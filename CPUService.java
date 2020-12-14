package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.CPU;

import javax.ws.rs.*;

@Path("/config/{configId}/cpu")
public class CPUService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public Response createCPU(@PathParam("configId") int configId, CPU aCPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.addCpuToConfig(configId, aCPU);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"creatred\"}").type("application/json").build();
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Response changeCPU(int configId, CPU aCPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.changeCPU(configId, aCPU);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
		}
		return  Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteCPU(@PathParam("configId") int configId) {
		int control = ConfigurationController.getInstance().deleteCPU(configId);
		if(control != -1) {
			
		
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		
	}
	
	
	
	
}
