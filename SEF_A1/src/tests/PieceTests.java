package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.PiecePosition;
import models.pieces.Rook2;

class PieceTests {

	@BeforeEach
	void setUp() throws Exception {
		ChessBoard chessBoard = new ChessBoard();
		Rook2 rook2 = new Rook2(false, new PiecePosition(0, 0));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
