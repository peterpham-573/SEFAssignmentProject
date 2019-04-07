package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.PiecePosition;
import models.pieces.Bishop2;
import models.pieces.Knight2;
import models.pieces.Rook2;

class PieceTests {
	
	ChessBoard chessBoard;
	Rook2 rook2;
	Knight2 knight2;
	Bishop2 bishop2;
	
	@BeforeEach
	void setUp() throws Exception {
		chessBoard = new ChessBoard();
		rook2 = new Rook2(false, new PiecePosition(0, 0));
		knight2 = new Knight2(false, new PiecePosition(0, 0));
		bishop2 = new Bishop2(false, new PiecePosition(0, 0));
	}

	@Test
	void rookMovementTest() {
		LinkedList<PiecePosition> piecePositions;
		piecePositions = rook2.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}

	@Test
	void knightMovementTest() {
		LinkedList<PiecePosition> piecePositions;
		piecePositions = knight2.movement();
		// This will have to change after further implementation of Movement
		assertEquals(2, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTest() {
		LinkedList<PiecePosition> piecePositions;
		piecePositions = bishop2.movement();
		// This will have to change after further implementation of Movement
		assertEquals(2, piecePositions.size()); 
	}
}
