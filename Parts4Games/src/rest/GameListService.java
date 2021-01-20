package rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import business.GameListBusinessController;

@Path("/gameList/{gameName}")
public class GameListService {
	
	private GameListBusinessController gameListBusinessController = new GameListBusinessController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGameList(@PathParam("gameName") String gameName) {
		try {
			CacheControl cc = new CacheControl();
		    cc.setMaxAge(86400000);

		    ResponseBuilder builder = Response.ok(gameListBusinessController.getGameList(gameName));
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