package rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import java.io.IOException;

import javax.ws.rs.*;

import data.CPU;

@Path("/config/{configId}/cpu")
public class CpuService {
	
	
	@POST // Bei POST auf die URL der Klasse
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public CPU createCPU(@PathParam("configId") int configId , CPU aCpu) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.addCpuToConfig(configId, aCPU);
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response changeCPU(@PathParam("config") int configId, CPU aCpu) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return conf.changeCPU(configId, aCPU);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response deleteCPU(@PathParam("config") int configId) {
		try {
			ConfigurationController.getInstance().deleteCPU(configId);
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		} catch (IOException e) {
			return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
	}
	
	
	
	
}
