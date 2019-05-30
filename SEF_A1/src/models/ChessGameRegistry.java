package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import models.ChessPlayer;
import models.interfaces.GameRegistry;

public class ChessGameRegistry implements GameRegistry {

	private ChessPlayer[] loginArray = new ChessPlayer[2];
	private ArrayList<ChessPlayer> playerArray = new ArrayList<ChessPlayer>();

	// Reads the registration file and adds each player into the playerArray
	public ChessGameRegistry() {
		File Data = new File("src/Registrations.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(Data);
			while (scan.hasNext()) {
				String dataLine = scan.nextLine();
				String[] splitData = dataLine.split(" ");
				ChessPlayer newPlayer = new ChessPlayer(splitData[0], splitData[1], splitData[2]);
				playerArray.add(newPlayer);
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	// Checks if a Username is already in the system as Usernames are a unique Login 
	// If the user enters a unique Username then add the player into the registry
	public boolean userNameCheckAndAdd(ChessPlayer player) {
		boolean userNameExists = false;
		for (int i = 0; i < playerArray.size(); i++) {
			if (equalsUsername(player, playerArray.get(i))) {
				userNameExists = true;
			}
		}
		if(!userNameExists) {
			addPlayerToRegistration(player);
		}
		return userNameExists;
	}

	// Adds a player into the registrationArray from a file
	public void addPlayerToRegistration(ChessPlayer player) {
		PrintWriter writer = null;
		File Data = new File("src/Registrations.txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(Data, true);
			writer = new PrintWriter(new BufferedWriter(fr));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		writer.println(player.toString());
		writer.close();
		playerArray.add(player);

	}

	public int playerLogin(ChessPlayer newPlayer) {
		// Returns a int which represents the possible outcomes of trying to log in a
		// player
		// int = 0. Player 1 was added to the LoginArray (Attempt to login with valid
		// login ID and password succeeds).
		// int = 1. Attempt to login with the same valid ID and login fails.
		// int = 2. Player 2 was added to the LoginArray (Attempt to login with valid
		// login ID and password succeeds).
		// int = 3. Attempt to login with invalid login ID and password fails.

		boolean foundId = false;

		if (newPlayer != null) {
			foundId = true;
		}

		if (foundId) {
			if (loginArray[0] == null) {
				loginArray[0] = newPlayer;
				return 0;
			} else if (equalsUsername(newPlayer, loginArray[0])) {
				return 1;
			} else {
				loginArray[1] = newPlayer;
				return 2;
			}
		}
		return 3;

	}

	// Returns a player based on login details. Returns null if the play is not found
	public ChessPlayer getPlayer(String[] playerDetails) {
		for (ChessPlayer player : playerArray) {
			if (playerDetails[0].equals(player.getPlayerUserName()) && playerDetails[1].equals(player.getPlayerPw())) {
				return player;
			}
		}
		return null;
	}

	// Checks if the usernames of two players are different
	public boolean equalsUsername(ChessPlayer player1, ChessPlayer player2) {
		if (player1.getPlayerUserName().equals(player2.getPlayerUserName())) {
			return true;
		} else {
			return false;
		}
	}

	//Returns the players store in the login array
	public ChessPlayer[] getplayers() {
		return loginArray;
	}

}
