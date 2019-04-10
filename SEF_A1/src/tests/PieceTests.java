package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessBoard;
import models.PiecePosition;
import models.pieces.Bishop2;
import models.pieces.Knight2;
import models.pieces.Rook;
import models.pieces.Rook2;

class PieceTests {
	
	ChessBoard chessBoard;
	Rook2 rook2;
	Knight2 knight2;
	Bishop2 bishop2;
	LinkedList<PiecePosition> piecePositions;
	
	@BeforeEach
	void setUp() throws Exception {
		chessBoard = new ChessBoard();
		rook2 = new Rook2(false, new PiecePosition(0, 0));
		knight2 = new Knight2(false, new PiecePosition(0, 0));
		bishop2 = new Bishop2(false, new PiecePosition(0, 0));
	}

	@Test
	void rookMovementTestBlackStart1() {
		Rook2 rook = new Rook2(false, new PiecePosition(0, 0));
		piecePositions = rook.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestBlackStart2() {
		Rook2 rook = new Rook2(false, new PiecePosition(0, 5));
		piecePositions = rook.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestWhiteStart1() {
		Rook2 rook = new Rook2(false, new PiecePosition(5, 0));
		piecePositions = rook.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestWhiteStart2() {
		Rook2 rook = new Rook2(false, new PiecePosition(5, 5));
		piecePositions = rook.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestMiddle() {
		Rook2 rook = new Rook2(false, new PiecePosition(2, 2));
		piecePositions = rook.movement();
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}

	@Test
	void knightMovementTestBlackStart1() {
		Knight2 knight = new Knight2(false, new PiecePosition(0, 2));
		piecePositions = knight.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestBlackStart2() {
		Knight2 knight = new Knight2(false, new PiecePosition(0, 3));
		piecePositions = knight.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestWhiiteStart1() {
		Knight2 knight = new Knight2(false, new PiecePosition(5, 2));
		piecePositions = knight.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestWhiteStart2() {
		Knight2 knight = new Knight2(false, new PiecePosition(5, 3));
		piecePositions = knight.movement();
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestMiddle() {
		Knight2 knight = new Knight2(false, new PiecePosition(2, 2));
		piecePositions = knight.movement();
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackStart1() {
		Bishop2 bishop = new Bishop2(false, new PiecePosition(0, 1));
		piecePositions = bishop.movement();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackStart2() {
		Bishop2 bishop = new Bishop2(false, new PiecePosition(0, 4));
		piecePositions = bishop.movement();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestWhiteStart1() {
		Bishop2 bishop = new Bishop2(false, new PiecePosition(5, 1));
		piecePositions = bishop.movement();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestWhiteStart2() {
		Bishop2 bishop = new Bishop2(false, new PiecePosition(5, 4));
		piecePositions = bishop.movement();
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestMiddle() {
		Bishop2 bishop = new Bishop2(false, new PiecePosition(2, 2));
		piecePositions = bishop.movement();
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
