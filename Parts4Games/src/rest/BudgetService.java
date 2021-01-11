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


@Path("/config/{configId}/budget/{newBudget}")
public class BudgetService {

	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON)
	public float createBudget(@PathParam("configId") int configId,@PathParam("newBudget") float budget) {
		float control;
		try {
			control = ConfigurationController.getInstance().setBudget(configId, budget);
			return control;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // wird JSON erwartet 
	@Produces(MediaType.APPLICATION_JSON)
	public float changeBudget(@PathParam("configId") int configId,@PathParam("newBudget")float budget) {
		float control;
		try {
			control = ConfigurationController.getInstance().changeBudget(configId, budget);
			return control;
		} catch (IOException e) {
			return -1;
		}
		
		
	}
}
