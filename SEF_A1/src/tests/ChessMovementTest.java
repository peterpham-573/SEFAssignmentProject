package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.PiecePosition;
import models.pieces.Knight;
import models.pieces.Piece;
import models.pieces.Rook;


/* Peter Pham's tests of the chess game */
class ChessMovementTest {
	
	ChessBoard cb;
	Piece rook;
	Piece knight;
	Piece bishop;

	@BeforeEach
	void setUp() throws Exception
	{
		//creating pieces and boards
		cb = new ChessBoard();
		rook = new Rook(true, new PiecePosition(5, 0));
		knight = new Knight(true, new PiecePosition(5, 1));
		bishop = new Knight(true, new PiecePosition(5, 2));
	}
	
	/*Test 1 -- move to invalid spot */
	@Test
	void test() 
	{
		fail("Not yet implemented");
	}

}
