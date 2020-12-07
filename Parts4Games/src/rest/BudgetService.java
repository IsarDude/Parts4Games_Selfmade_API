package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.ConfigurationController;


@Path("/config/{configId}/budget")
public class BudgetService {

	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Response createBudget(@PathParam("configId") int configId,float budget) {
		int control = ConfigurationController.getInstance().createBudget(configId, budget);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"created\"}").type("application/json").build();
			
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces( MediaType.TEXT_PLAIN )
	public Response changeBudget(@PathParam("configId") int configId,float budget) {
		int control = ConfigurationController.getInstance().changeBudget(configId, budget);
		if(control != -1) {
			return Response.status(200).entity("{\"state\":\"changed\"}").type("application/json").build();
			
		}
		return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
	}
}
