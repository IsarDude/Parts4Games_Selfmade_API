package rest;

import java.util.Date;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

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
	public Response getConfig(@PathParam("configId") int configId, @Context Request request) {
		ConfigurationController conf = ConfigurationController.getInstance();
		Config config = conf.getConfig(configId);
		
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			if(config == null) {
		        return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 Config Not Found for ID: " + configId + "\"}").build();
		    }
			CacheControl cc = new CacheControl();
		    cc.setMaxAge(1296000000); //2 Weeks

		    EntityTag etag = new EntityTag(Integer.toString(config.hashCode()));
		    ResponseBuilder builder = request.evaluatePreconditions(etag);

		    // cached resource did change -> serve updated content
		    if(builder == null){ // Code 412
		        builder = Response.ok(config);
		        builder.tag(etag);
		        builder.cacheControl(cc);
		        builder.expires(new Date(System.currentTimeMillis() + 1296000000));
		        return builder.build();
		    } else { // Code 304
		    	builder.cacheControl(cc);
			    builder.expires(new Date(System.currentTimeMillis() + 1296000000));
			    return builder.build();
		    }
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
