package service.ressources;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import BussinesController.ConfigurationController;
import model.Config;


@Path("/config")
public class ConfigRessource {
	
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
		Config config = ConfigurationController.getInstance().getConfig(configId);
		return config;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response deleteConfig(@PathParam("configId") int configId) {
		ConfigurationController.getInstance().deleteConfig(configId);
		return return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
	}
}
