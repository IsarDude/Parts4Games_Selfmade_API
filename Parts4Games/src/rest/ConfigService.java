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


import org.glassfish.jersey.linking.ProvideLink;
import org.glassfish.jersey.linking.Binding;

@Path("/config")
public class ConfigService {
	
	
	@ProvideLink(value = Config.class, rel ="self",
			 bindings = @Binding(name="configId", value="${instance.configId}"))
	@ProvideLink(value = Config.class, rel="delete",
			 bindings = @Binding(name="configId", value="${instance.configId}"))
	@POST // Bei POST auf die URL der Klasse
// wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public int createConfig() {
		return ConfigurationController.getInstance().createConfig();
	  // int id = ConfigurationController.getInstance().createConfig();
	  //return id;
	}
	
	@ProvideLink(value = Config.class, rel ="self",
			 bindings = @Binding(name="configId", value="$configId"))
	@ProvideLink(value = Config.class, rel="delete",
			 bindings = @Binding(name="configId", value="$configId"))
	@Path("/{configId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Config getConfig(@PathParam("configId") int configId) {
		ConfigurationController configController = ConfigurationController.getInstance();
		Config config = configController.getConfig(configId);
		return config;
	}
	
	@Path("/{configId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)  // und als Rückmeldung produziert
	public Response deleteConfig(@PathParam("configId") int configId) {
		ConfigurationController config = ConfigurationController.getInstance();
		boolean isDeleted = config.deleteConfig(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
		
}
