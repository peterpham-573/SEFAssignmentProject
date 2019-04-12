package models;

import models.interfaces.Player;

public class ChessPlayer implements Player
{
	private String playerName;
	private String playerUserName;
	private String password;
	private int points;
	private int noOfTurns;
	
	public ChessPlayer(String playerName, String pUserName, String pw) {
		this.playerName = playerName;
		this.playerUserName = pUserName;
		this.password = pw;
		this.points = 0;
	}
	
	@Override
	public String toString() {
		return String.format(playerName + " " + playerUserName + " "  + password);
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
	
	@Override
	public void setNoOfTurns(int noOfTurns) {
		this.noOfTurns = noOfTurns;
	}
	
	@Override
	public int getNoOfTurns() {
		return noOfTurns;
	}
}
