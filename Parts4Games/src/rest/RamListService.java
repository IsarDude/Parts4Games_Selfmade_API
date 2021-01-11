package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.RamListBusinessController;

@Path("/ramList")
public class RamListService {
/*
	@Inject
	private RamListBusinessController ramListBusinessController;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRamList(String brand, String model, int totalcapacity, String type, String busSpeed, float price) {
		try {
			return Response.ok(ramListBusinessController.getRamList(company, model, capacity, type, frequency)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	*/
}
	

