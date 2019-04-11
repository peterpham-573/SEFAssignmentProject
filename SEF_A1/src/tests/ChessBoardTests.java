package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;

class ChessBoardTests {
	ChessBoard chessBoard;

	@BeforeEach
	void setUp() throws Exception {
		chessBoard = new ChessBoard();
	}

	@Test
	void movePieceValidMove() {
		// Rook
		assertTrue(chessBoard.movePiece("A0", "A1"));
		assertTrue(chessBoard.movePiece("a5", "a3"));
		
		// Bishop
		assertTrue(chessBoard.movePiece("B0", "d2"));
		assertTrue(chessBoard.movePiece("E5", "D4"));
		
		// Knight
		assertTrue(chessBoard.movePiece("d0", "b1"));
		assertTrue(chessBoard.movePiece("d5", "f4"));
	}
	
	@Test
	void movePieceInvalidMove() {
		// Rook
		assertFalse(chessBoard.movePiece("A0", "A4"));
		assertFalse(chessBoard.movePiece("a5", "b4"));
		
		// Bishop
		assertFalse(chessBoard.movePiece("B0", "b1"));
		assertFalse(chessBoard.movePiece("E5", "B2"));
		
		// Knight
		assertFalse(chessBoard.movePiece("d0", "d1"));
		assertFalse(chessBoard.movePiece("d5", "f3"));
	}
	
	@Test
	void movePieceInvalidInput() {
		assertFalse(chessBoard.movePiece("a7", "a3"));
		assertFalse(chessBoard.movePiece("a0", "a9"));
		
		assertFalse(chessBoard.movePiece("H0", "a3"));
		assertFalse(chessBoard.movePiece("B6", "a3"));
		
		assertFalse(chessBoard.movePiece("g7", "h2"));
		assertFalse(chessBoard.movePiece("G7", "H2"));
	}

}
