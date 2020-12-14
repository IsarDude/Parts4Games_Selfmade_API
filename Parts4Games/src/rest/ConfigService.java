package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;
import data.Config;

@Path("/config")
public class ConfigService {
	
	@POST // Bei POST auf die URL der Klasse
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public int createConfig(Config newConfig) {
	   int id = ConfigurationController.getInstance().createConfig(newConfig);
	  return id;
	}
	
	@Path("/config/{configId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Config getConfig(@PathParam("configId") int configId) {
		ConfigurationController configController = ConfigurationController.getInstance();
		Config config = configController.getConfig(configId);
		return config;
	}
	
	@DELETE
	@Produces( MediaType.TEXT_PLAIN ) // und als Rückmeldung produziert
	public Response deleteConfig(@PathParam("configId") int configId) {
		ConfigurationController config = ConfigurationController.getInstance();
		int control = config.deleteConfig(configId);
		if(control ==-1) {
			 return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
	}
		
}
