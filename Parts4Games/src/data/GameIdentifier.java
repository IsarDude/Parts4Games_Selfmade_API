package data;

public class GameIdentifier {

	private String gameName;
	private int gameId;
	
	public GameIdentifier() {
		
	}
	
	public GameIdentifier(String gameName, int gameId) {
		this. gameName = gameName;
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
