package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessGameRegistry;
import models.ChessPlayer;

class Registration {
	ChessGameRegistry chessGameRegistry;

	//chessGameRegistry.playerLogin(Player player)
	//Returns a int which represents the possible outcomes of trying to log in a player
	//int = 0. Player 1 was added to the LoginArray (Attempt to login with valid login ID and password succeeds).
	//int = 1. Attempt to login	with the same valid	ID and login fails. 
	//int = 2. Player 2 was added to the LoginArray (Attempt to login with valid login ID and password succeeds).
	//int = 3. Attempt to login	with invalid login ID and password fails.
	@BeforeEach
	void setUp() throws Exception {
		chessGameRegistry = new ChessGameRegistry();
		chessGameRegistry.addPlayerToRegistration(new ChessPlayer("TestingPlayer", "Hello", "World"));
		chessGameRegistry.addPlayerToRegistration(new ChessPlayer("Danny", "Danny", "Le"));
	}

	@AfterEach
	void tearDownEach() throws Exception {
		//Deletes the two players created after each tests
		final int PLAYERS_CREATED = 2;
		deletePlayers(PLAYERS_CREATED);
	}

	
	@AfterAll
	public static void tearDown() throws Exception {
		//Deletes the four players created after all the tests are run
		final int PLAYERS_CREATED = 4;
		deletePlayers(PLAYERS_CREATED);
	}
	
	private static void deletePlayers(int PLAYERS_CREATED) throws Exception {
		//Deletes any players that the tests may have created as part of the tests
		for(int i = 0; i < PLAYERS_CREATED;i++ ) {
		StringBuilder StringBuilder = new StringBuilder();
		File Data = new File("src/Registrations.txt");
		Scanner scan = null;
		BufferedWriter fWriter = null;
		scan = new Scanner(Data);
		
	    while (scan.hasNextLine()) {
	        String line = scan.nextLine();
	        if (scan.hasNextLine()) {
	            StringBuilder.append(line+ "\n");
	        }
	    }
	    
	    fWriter = new BufferedWriter(new FileWriter("src/Registrations.txt"));
	    fWriter.write(StringBuilder.toString());
	    fWriter.close();
		}
	}

	
	//Login a player inside the registry
	@Test
	void loginOnePlayer() {
		String[] playerDetails = {"Hello" ,"World"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
	}
	
	//Login two players with the same login details
	@Test
	void loginTwoPlayersSameDetails() {
		String[] playerDetails = {"Hello" ,"World"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),1);
	}
	
	//Login a player inside the registry
	//Login a player that doesn't exist inside the registry	
	@Test
	void loginTwoPlayersOneFakePlayer() {
		String[] playerDetails = {"Hello" ,"World"};
		String[] playerDetails2 = {"FAKE" ,"PLAYER"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		ChessPlayer newPlayer2 = chessGameRegistry.getPlayer(playerDetails2);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer2),3);
	}
	
	//Login two different players inside the registry
	@Test
	void loginTwoDifferentPlayers() {
		String[] playerDetails = {"Hello" ,"World"};
		String[] playerDetails2 = {"Danny" ,"Le"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		ChessPlayer newPlayer2 = chessGameRegistry.getPlayer(playerDetails2);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer2),2);
	}
	
	//Checks if a player of the same username is already inside the registry
	@Test
	void registerOnePlayerTwice() {
		ChessPlayer newPlayer = new ChessPlayer("newPlayer", "New", "Player");
		
		//Checks if the player already exists in the registry and adds that player
		assertEquals(chessGameRegistry.userNameCheckAndAdd(newPlayer),false);	
		
		//Checks if the player already exists in the registry and Player does not get added a second time
		assertEquals(chessGameRegistry.userNameCheckAndAdd(newPlayer),true);			
	}
	
	//Login a player that does not exist in the registry
	//adds the player into the registry
	//Attempts to login the same player
	@Test
	void loginThenRegisterPlayer() {
		ChessPlayer newPlayer = new ChessPlayer("newPlayer2", "New2", "Player2");
		assertEquals(chessGameRegistry.userNameCheckAndAdd(newPlayer),false);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
	}
	
	//Login a player that does  not exist in the registry
	//Adds the player into the registry
	//Attempts to login the same player
    //Attempts to login the same player again
    //Login a second player that does  not exist in the registry
    //Adds the second player into the registry
    //Attempts to login the second player
	@Test
	void AllCases() {
		ChessPlayer newPlayer = new ChessPlayer("AllCases", "Player_1", "Player_1");
		ChessPlayer newPlayer2 = new ChessPlayer("AllCases", "Player_2", "Player_2");
		String[] playerDetails = {"Player_1" ,"Player_1"};
		String[] playerDetails2 = {"Player_2" ,"Player_2"};
		assertEquals(chessGameRegistry.playerLogin(chessGameRegistry.getPlayer(playerDetails)),3);
		assertEquals(chessGameRegistry.userNameCheckAndAdd(newPlayer),false);
		
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),1);
		
		assertEquals(chessGameRegistry.playerLogin(chessGameRegistry.getPlayer(playerDetails2)),3);
		assertEquals(chessGameRegistry.userNameCheckAndAdd(newPlayer2),false);
		
		assertEquals(chessGameRegistry.playerLogin(newPlayer2),2);
	}

}
