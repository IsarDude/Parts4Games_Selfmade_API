package rest;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;

@Path("/config/{configId}/budget/{newBudget}")
public class BudgetService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBudget(@PathParam("configId") int configId, @PathParam("newBudget") float newBudget) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			return Response.ok(conf.setBudget(configId, newBudget)).build();
		} catch (IOException e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}	
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response changeBudget(@PathParam("configId") int configId, @PathParam("newBudget")float newBudget) {
		ConfigurationController conf = ConfigurationController.getInstance();
		try {
			if(configId <= 0) {
		        return Response.status(400).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"400 Config starts at index 1\"}").build();
		    }
			return Response.ok(conf.changeBudget(configId, newBudget)).build();
		} catch (IOException e) {
			return Response.status(500)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}	
	}
}
