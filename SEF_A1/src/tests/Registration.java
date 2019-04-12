package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessGameRegistry;
import models.ChessPlayer;

class Registration {
	ChessGameRegistry chessGameRegistry;
	@BeforeEach
	void setUp() throws Exception {
		chessGameRegistry = new ChessGameRegistry();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	//Login a player inside the registry
	void registerPlayer() {
		String[] playerDetails = {"Hello" ,"World"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
	}
	
	@Test
	//Login two players with the same login details
	void registerPlayer2() {
		String[] playerDetails = {"Hello" ,"World"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),1);
	}
	
	@Test
	void registerPlayer3() {
	//Login a player inside the registry
	//Login a player that doesn't exist inside the registry	
		String[] playerDetails = {"Hello" ,"World"};
		String[] playerDetails2 = {"FAKE" ,"PLAYER"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		ChessPlayer newPlayer2 = chessGameRegistry.getPlayer(playerDetails2);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer2),3);
	}
	
	@Test
	void registerPlayer4() {
	//Login two different players inside the registry
		String[] playerDetails = {"Hello" ,"World"};
		String[] playerDetails2 = {"Danny" ,"Le"};
		ChessPlayer newPlayer = chessGameRegistry.getPlayer(playerDetails);
		ChessPlayer newPlayer2 = chessGameRegistry.getPlayer(playerDetails2);
		assertEquals(chessGameRegistry.playerLogin(newPlayer),0);
		assertEquals(chessGameRegistry.playerLogin(newPlayer2),2);
	}
	

}
