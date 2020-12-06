package rest;
import java.io.StringReader;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import business.ConfigurationController;
import model.Config;
import model.GPU;

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
		ConfigurationController configController = ConfigurationController.getInstance();
		Config config = configController.getConfig(configId);
		return config;
		
	
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response deleteConfig(@PathParam("configId") int configId) {
		ConfigurationController config = ConfigurationController.getInstance();
		int control = config.deleteConfig(configId);
		if(control ==-1) {
			 return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		
	}
	
	@Path("/config/{configId}/gpu")
	@POST
	public GPU createGPU(@PathParam("configId") int configId, GPU aGPU) {
		Client client = Client.create();
		String keywords = aGPU.getKeywordString();
		WebResource web = client.resource("https://open.api.ebay.com/shopping");
		
		ClientResponse response = web
				.queryParam("version","515")
				.queryParam("appid", "MyAppID")
				.queryParam("callname","FindProducts")
				.queryParam("responseencoding", "JSON")
				.queryParam("QueryKeywords",keywords )
				
				.accept("application/json").get(ClientResponse.class);
		JsonReader reader = Json.createReader(new StringReader(response.toString()));
		JsonObject json = reader.readObject();
		return aGPU;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	public Response changeGPU(int configId, GPU aGPU) {
		Config conf = ConfigurationController.getInstance().getConfig(configId);
		conf.setSelectedGpu(aGPU);
		return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) // und als Rückmeldung produziert
	public Response deleteGPU(@PathParam("configId") int configId) {
		Config conf = ConfigurationController.getInstance().getConfig(configId);
		if(conf != null) {
			
		conf.setSelectedGpu(null);
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
		
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		
	}
	
	@Path("/config/{configId}/budget")
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON)
	public float createBudget(@PathParam("configId") int configId,float budget) {
		Config conf = ConfigurationController.getInstance().getConfig(configId);
		if(conf != null) {
			conf.setBudget(budget);
			
		}
		return conf.getBudget();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	public Response changeBudget(@PathParam("configId") int configId,float budget) {
		Config conf = ConfigurationController.getInstance().getConfig(configId);
		if(conf != null) {
			conf.setBudget(budget);
			
		}
		return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
	}
	
	@DELETE
	public Response deleteBudget(@PathParam("configId") int configId) {
		Config conf = ConfigurationController.getInstance().getConfig(configId);
		if(conf != null) {
			conf.setBudget(0);
			
		}
		return Response.status(200).entity("{\"state\":\"deleted\"}").type("application/json").build();
	}
}
