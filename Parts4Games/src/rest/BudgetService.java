package rest;

import java.io.IOException;

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
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBudget(@PathParam("configId") int configId,float budget) {
		float control;
		try {
			control = ConfigurationController.getInstance().setBudget(configId, budget);
			return Response.status(201).entity("{\"state\":\"created\"}").type("application/json").build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
	
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	public Response changeBudget(@PathParam("configId") int configId,float budget) {
		float control;
		try {
			control = ConfigurationController.getInstance().changeBudget(configId, budget);
			return Response.ok().type("application.json").build();
		} catch (IOException e) {
			return Response.status(404).entity("{\"state\":\"Config Not Found\"}").type("application/json").build();
		}
		
		
	}
}
