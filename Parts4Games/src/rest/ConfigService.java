package rest;

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
	
	@POST 
	@Produces(MediaType.APPLICATION_JSON) 
	public Response createConfig() {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.createConfig()).build();
		} catch (Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@Path("/{configId}")
	@ProvideLink(value = Config.class, rel ="self",
	 bindings = @Binding(name="configId", value="${instance.configID}"))
	@ProvideLink(value = Config.class, rel="delete",
	 bindings = @Binding(name="configId", value="${instance.configID}"))
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConfig(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			return Response.ok(conf.getConfig(configId)).build();
		} catch (Exception e) {
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@Path("/{configId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteConfig(@PathParam("configId") int configId) {
		ConfigurationController conf = ConfigurationController.getInstance();
		boolean isDeleted = conf.deleteConfig(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();	
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}	
}
