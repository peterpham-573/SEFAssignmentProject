package models.interfaces;

import models.ChessPlayer;

public interface GameRegistry {
	
	//Checks if a Username is already in the system as Usernames are a unique Login ID
	public boolean userNameCheckAndAdd(ChessPlayer player);
	
	//Adds a player into the registrationArray  from a file
	public void addPlayerToRegistration(ChessPlayer player);

	//Returns a int which represents the possible outcomes of trying to log in a player
	//int = 0. Player 1 was added to the LoginArray (Attempt to login with valid login ID and password succeeds).
	//int = 1. Attempt to login	with the same valid	ID and login fails. 
	//int = 2. Player 2 was added to the LoginArray (Attempt to login with valid login ID and password succeeds).
	//int = 3. Attempt to login	with invalid login ID and password fails.
	public int playerLogin(ChessPlayer newPlayer);		
	
	//Returns a player based on login details. Returns null if the play is not found
	public ChessPlayer getPlayer(String[] playerDetails);
	
	public boolean equalsUsername(ChessPlayer player1, ChessPlayer player2);

	public ChessPlayer[] getplayers();

}