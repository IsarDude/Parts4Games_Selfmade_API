package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.GPU;

import java.io.IOException;

import javax.ws.rs.*;

@Path("/config/{configId}/gpu")
public class GpuService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public GPU createGPU(@PathParam("configId") int configId, GPU aGPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.addGpuToConfig(configId, aGPU);
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public GPU changeGPU(int configId, GPU aGPU) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.changeGPU(configId, aGPU);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteGPU(@PathParam("configId") int configId) {
		try {
			ConfigurationController.getInstance().deleteGPU(configId);
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		} catch (IOException e) {
			return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
		
			
		
		
		
		
				
	}
	
	
	
	
}
