package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.GameInfoBusinessController;
import data.GameInfo;

@Path("/gameInfo/{gameId}")
public class GameInfoService {

	private GameInfoBusinessController gameInfoBusinessController = new GameInfoBusinessController();
	
	@GET
	@Path("/rec")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGameListReq(@PathParam("gameId") int gameId) {
		try {
			GameInfo gameInfo = gameInfoBusinessController.getGameInfoRec(gameId);
			if(gameInfo.getHardwareRequirements() == null) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No Game Info Found for ID: " + gameId + "\"}").build();
			}
			return Response.ok(gameInfo).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
	
	@GET
	@Path("/min")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGameListMin(@PathParam("gameId") int gameId) {
		try {
			GameInfo gameInfo = gameInfoBusinessController.getGameInfoMin(gameId);
			if(gameInfo.getHardwareRequirements() == null) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No Game Info Found for ID: " + gameId + "\"}").build();
			}
			return Response.ok(gameInfo).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
