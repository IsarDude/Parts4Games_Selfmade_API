package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.GameInfoBusinessController;

@Path("/gameInfo/{gameId}")
public class GameInfoService {
	@Inject
	private GameInfoBusinessController gameInfoBusinessController;
	
	@GET
	@Path("/rec")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGameListReq(@PathParam("gameId") int gameId) {
		try {
			return Response.ok(gameInfoBusinessController.getGameInfoRec(gameId)).build();
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
			return Response.ok(gameInfoBusinessController.getGameInfoMin(gameId)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
