package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.MotherboardListController;;

@Path("/motherboardList")
public class MotherboardListService {
	/*
	@Inject
	private MotherboardListController motherboardListBusinessController;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCPUList(int aSocket, int aFrontSideBus, String aFormfactor, String aCompany, String aModel, String aChipset, String aDdrMemory, float aPrice) {
		try {
			return Response.ok(motherboardListBusinessController.getMotherboardList(aSocket, aFrontSideBus, aFormfactor, aCompany, aModel, aChipset, aDdrMemory, aPrice)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage())
					.build();
		}
	}
	*/
}