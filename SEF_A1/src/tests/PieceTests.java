package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.PiecePosition;
import models.pieces.Bishop;
import models.pieces.Knight;
import models.pieces.Rook;
import models.pieces.Rook;

class PieceTests {
	
	ChessBoard chessBoard;
	Rook rook2;
	Knight knight2;
	Bishop bishop2;
	LinkedList<PiecePosition> piecePositions;
	
	@BeforeEach
	void setUp() throws Exception {
		chessBoard = new ChessBoard();
		rook2 = new Rook(false, new PiecePosition(0, 0));
		knight2 = new Knight(false, new PiecePosition(0, 0));
		bishop2 = new Bishop(false, new PiecePosition(0, 0));
	}

	@Test
	void rookMovementTestBlackStart1() {
		Rook rook = new Rook(false, new PiecePosition(0, 0));
		piecePositions = rook.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestBlackStart2() {
		Rook rook = new Rook(false, new PiecePosition(0, 5));
		piecePositions = rook.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestWhiteStart1() {
		Rook rook = new Rook(false, new PiecePosition(5, 0));
		piecePositions = rook.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestWhiteStart2() {
		Rook rook = new Rook(false, new PiecePosition(5, 5));
		piecePositions = rook.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestMiddle() {
		Rook rook = new Rook(false, new PiecePosition(2, 2));
		piecePositions = rook.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}

	@Test
	void knightMovementTestBlackStart1() {
		Knight knight = new Knight(false, new PiecePosition(0, 2));
		piecePositions = knight.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestBlackStart2() {
		Knight knight = new Knight(false, new PiecePosition(0, 3));
		piecePositions = knight.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestWhiiteStart1() {
		Knight knight = new Knight(false, new PiecePosition(5, 2));
		piecePositions = knight.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestWhiteStart2() {
		Knight knight = new Knight(false, new PiecePosition(5, 3));
		piecePositions = knight.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestMiddle() {
		Knight knight = new Knight(false, new PiecePosition(2, 2));
		piecePositions = knight.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackStart1() {
		Bishop bishop = new Bishop(false, new PiecePosition(0, 1));
		piecePositions = bishop.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackStart2() {
		Bishop bishop = new Bishop(false, new PiecePosition(0, 4));
		piecePositions = bishop.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestWhiteStart1() {
		Bishop bishop = new Bishop(false, new PiecePosition(5, 1));
		piecePositions = bishop.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestWhiteStart2() {
		Bishop bishop = new Bishop(false, new PiecePosition(5, 4));
		piecePositions = bishop.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestMiddle() {
		Bishop bishop = new Bishop(false, new PiecePosition(2, 2));
		piecePositions = bishop.validMovementsList();
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}
	
	@Test
	void ColLetterToNumber() {
		PiecePosition piecePosition = new PiecePosition(0, 0);
		assertEquals(0, piecePosition.colNameLetterToNumber("A"));
		assertEquals(1, piecePosition.colNameLetterToNumber("B"));
		assertEquals(2, piecePosition.colNameLetterToNumber("C"));
		assertEquals(3, piecePosition.colNameLetterToNumber("D"));
		assertEquals(4, piecePosition.colNameLetterToNumber("E"));
		assertEquals(5, piecePosition.colNameLetterToNumber("F"));
		
		assertEquals(0, piecePosition.colNameLetterToNumber("a"));
		assertEquals(1, piecePosition.colNameLetterToNumber("b"));
		assertEquals(2, piecePosition.colNameLetterToNumber("c"));
		assertEquals(3, piecePosition.colNameLetterToNumber("d"));
		assertEquals(4, piecePosition.colNameLetterToNumber("e"));
		assertEquals(5, piecePosition.colNameLetterToNumber("f"));
		
		assertEquals(-1, piecePosition.colNameLetterToNumber("G"));
	}
	
	
	
	
	
	
	
	
	
}
