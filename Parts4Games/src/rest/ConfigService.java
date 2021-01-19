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
			return Response.status(500)
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
		Config config = conf.getConfig(configId);
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			if(config == null) {
		        return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 Config Not Found for ID: " + configId + "\"}").build();
		    }
			return Response.ok(config).build();
		} catch (Exception e) {
			return Response.status(500)
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
		try {
		if(configId <= 0) {
		    return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		}
		boolean isDeleted = conf.deleteConfig(configId);
		if(isDeleted) {
			return Response.status(200).entity("{\"state\":\" 200 Deleted\"}").type(MediaType.APPLICATION_JSON).build();	
		}
		return Response.status(404).entity("{\"state\":\"404 Config Not Found for ID: " + configId + "\"}").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}	
}
