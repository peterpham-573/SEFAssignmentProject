package models;

import models.interfaces.Player;

public class ChessPlayer implements Player
{
	private String playerId;
	private String playerName;
	private String playerUserName;
	private String password;
	private int points;
	
	public ChessPlayer(String playerId, String playerName, String pUserName, String pw, int points) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerUserName = pUserName;
		this.password = pw;
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}
	@Override
	public String getPlayerName() {
		return playerName;
	}
	
	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	@Override
	public String getPlayerUserName() {
		return playerUserName;
	}

	@Override
	public void setPlayerUserName(String userName) {
		this.playerUserName = userName;
		
	}

	@Override
	public String getPlayerPw() {
		return password;
	}

	@Override
	public void setPlayerPw(String pw) {
		this.password = pw;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}
}
