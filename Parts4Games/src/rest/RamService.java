package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.RAM;

import java.io.IOException;

import javax.ws.rs.*;

@Path("/config/{configId}/ram")
public class RamService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public RAM createRAM(@PathParam("configId") int configId, RAM aRam) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.addRAMToConfig(configId, aRam);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public RAM changeRAM(int configId, RAM aRam) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.changeRAM(configId, aRam);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteRAM(@PathParam("configId") int configId) {
		try {
			ConfigurationController.getInstance().deleteRAM(configId);
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
	
			
		
	
		
	}
	
	
	
	
}