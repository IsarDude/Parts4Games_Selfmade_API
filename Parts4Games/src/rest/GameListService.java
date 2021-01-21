package rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import business.GameListBusinessController;
import data.GameIdentifier;

@Path("/gameList/{gameName}")
public class GameListService {
	
	private GameListBusinessController gameListBusinessController = new GameListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGameList(@PathParam("gameName") String gameName) {
		try {
			List<GameIdentifier> gameIdentifierList = gameListBusinessController.getGameList(gameName);
			if(gameIdentifierList.size() == 0) {
				return Response.status(404).type(MediaType.APPLICATION_JSON).entity("{\"state\":\"404 No Game Found With Name: " + gameName + "\"}").build();
			}
			CacheControl cc = new CacheControl();
		    cc.setMaxAge(86400000);

		    ResponseBuilder builder = Response.ok(gameIdentifierList);
		    builder.cacheControl(cc);
		    return builder.expires(new Date(System.currentTimeMillis() + 86400000)).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(503)
					.type(MediaType.APPLICATION_JSON)
					.entity(e.getMessage())
					.build();
		}
	}
}