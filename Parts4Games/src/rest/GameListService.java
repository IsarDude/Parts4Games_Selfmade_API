package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.GameListBusinessController;

@Path("/gameList/{gameName}")
public class GameListService {
	
	private GameListBusinessController gameListBusinessController = new GameListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGameList(@PathParam("gameName") String gameName) {
		try {
			return Response.ok(gameListBusinessController.getGameList(gameName)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}
