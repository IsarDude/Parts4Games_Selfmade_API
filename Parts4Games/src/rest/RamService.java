package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.RAM;

import javax.ws.rs.*;

@Path("/config/{configId}/ram")
public class RamService {
	
	@POST
	@Produces( MediaType.TEXT_PLAIN )
	public Response createRAM(@PathParam("configId") int configId, RAM aRam) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.addRAMToConfig(configId, aRam);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"creatred\"}").type("application/json").build();
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Response changeRAM(int configId, RAM aRam) {
		ConfigurationController conf = ConfigurationController.getInstance();
		int control = conf.changeRAM(configId, aRam);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
		}
		return  Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteRAM(@PathParam("configId") int configId) {
		int control = ConfigurationController.getInstance().deleteRAM(configId);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	
	
	
}