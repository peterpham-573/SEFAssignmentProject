package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.PiecePosition;
import models.pieces.Rook2;

class PieceTests {
	
	ChessBoard chessBoard;
	Rook2 rook2;
	
	@BeforeEach
	void setUp() throws Exception {
		chessBoard = new ChessBoard();
		rook2 = new Rook2(false, new PiecePosition(0, 0));
	}

	@Test
	void rookMovementTest() {
		LinkedList<PiecePosition> piecePositions;
		piecePositions = rook2.movement();
//		for (PiecePosition piecePosition : piecePositions) {
//			System.out.println(piecePosition.getCol() + piecePosition.getRow());
//		}
		assertEquals(4, piecePositions.size()); // This will have to change after further implementation of Movement
		
		
	}

}
