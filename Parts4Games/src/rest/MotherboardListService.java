package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.MotherboardListBusinessController;
import data.Motherboard;

@Path("/motherboardList")
public class MotherboardListService {
	
	private MotherboardListBusinessController motherboardListBusinessController = new MotherboardListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMotherboardList(@QueryParam("formFactor") String formFactor, @QueryParam("socketType") String socketType,
			@QueryParam("memoryType") String memoryType, @QueryParam("numberOfMemorySlots") String numberOfMemorySlots, @QueryParam("brandName") String brandName,
			@QueryParam("budget") String budget) {
	
		try {
			List<Motherboard> motherboardList = motherboardListBusinessController.getMotherboardList(formFactor, socketType, memoryType, numberOfMemorySlots, brandName, budget);
			if(motherboardList.size() == 0) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No Motherboards Found. Check Query Param Values\"}").build();
			}
			return Response.ok(motherboardList).build();	
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}