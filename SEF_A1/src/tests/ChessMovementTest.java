package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.ChessGameEngineImpl;
import models.PiecePosition;
import models.interfaces.ChessGameEngine;
import models.pieces.Knight;
import models.pieces.Piece;
import models.pieces.Rook;


/* Peter Pham's tests of the chess game */
class ChessMovementTest {
	
	ChessGameEngine ge;
	Piece rook;
	LinkedList<PiecePosition> piecePos;

	@BeforeEach
	void setUp() throws Exception
	{
		//creating pieces and boards
		ge = new ChessGameEngineImpl();
		rook = new Rook(true, new PiecePosition(5, 0));
		ge.getChessBoard().setPiece(rook, 5, 0);
	}
	
	/*Test 1 -- move to invalid spot */
	@Test
	void moveRook() 
	{
		piecePos = rook.validMovementsList();
		assertTrue(ge.getChessBoard().movePiece("A5", "A2"));
	}
	@Test
	void moveRook2() 
	{
		piecePos = rook.validMovementsList();
		assertTrue(ge.getChessBoard().movePiece("A5", "A4"));
	}
	@Test
	void moveRook3() 
	{
		rook = new Rook(true, new PiecePosition(2, 0));
		piecePos = rook.validMovementsList();
		assertTrue(ge.getChessBoard().movePiece("A2", "A0"));
	}
	
	
	

}
