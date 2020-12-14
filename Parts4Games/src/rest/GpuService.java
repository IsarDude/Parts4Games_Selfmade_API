package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.GPU;

import javax.ws.rs.*;

@Path("/config/{configId}/gpu")
public class GpuService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public Response createGPU(@PathParam("configId") int configId, GPU aGPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.addGpuToConfig(configId, aGPU);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"creatred\"}").type("application/json").build();
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Response changeGPU(int configId, GPU aGPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.changeGPU(configId, aGPU);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
		}
		return  Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteGPU(@PathParam("configId") int configId) {
		int control = ConfigurationController.getInstance().deleteGPU(configId);
		if(control != -1) {
			
		
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();		
	}
	
	
	
	
}
