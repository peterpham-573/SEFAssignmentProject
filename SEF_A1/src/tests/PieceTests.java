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

class PieceTests {
	
	ChessBoard chessBoard;
	ChessBoard blankBoard;
	Rook rook2;
	Knight knight2;
	Bishop bishop2;
	LinkedList<PiecePosition> piecePositions;
	
	@BeforeEach
	void setUp() throws Exception {
		chessBoard = new ChessBoard();
		blankBoard = new ChessBoard();
		blankBoard.fillBoardWithBlank();
	}
	
	@Test
	void test() {
		assertTrue(chessBoard.movePiece("a0", "A2"));
		assertTrue(chessBoard.movePiece("a2", "b2"));
	}

	@Test
	void rookMovementTestBlackStart1() {
		Rook rook = new Rook(false, new PiecePosition(0, 0));
		piecePositions = rook.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(2, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestBlackStart2() {
		Rook rook = new Rook(false, new PiecePosition(0, 5));
		piecePositions = rook.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(2, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestWhiteStart1() {
		Rook rook = new Rook(true, new PiecePosition(5, 0));
		piecePositions = rook.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(2, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestWhiteStart2() {
		Rook rook = new Rook(true, new PiecePosition(5, 5));
		piecePositions = rook.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(2, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestMiddle() {
		Rook rook = new Rook(false, new PiecePosition(3, 2));
		blankBoard.putPiece(3, 2, rook);
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}
	
	@Test
	void rookMovementTestBlackFriendlyPieceInWay4() {
		Rook rook = new Rook(false, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(false, new PiecePosition(3, 1));
		Bishop bishop2 = new Bishop(false, new PiecePosition(2, 2));
		Bishop bishop3 = new Bishop(false, new PiecePosition(3, 3));
		Bishop bishop4 = new Bishop(false, new PiecePosition(4, 2));
		
		blankBoard.putPiece(3, 2, rook);
		blankBoard.putPiece(3, 1, bishop1);
		blankBoard.putPiece(2, 2, bishop2);
		blankBoard.putPiece(3, 3, bishop3);
		blankBoard.putPiece(4, 2, bishop4);
		
		
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(0, piecePositions.size());
	}
	
	@Test
	void rookMovementTestBlackFriendlyPieceInWay2() {
		Rook rook = new Rook(false, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(false, new PiecePosition(3, 1));
		Bishop bishop2 = new Bishop(false, new PiecePosition(2, 2));
		
		blankBoard.putPiece(3, 2, rook);
		blankBoard.putPiece(3, 1, bishop1);
		blankBoard.putPiece(2, 2, bishop2);
		
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(4, piecePositions.size());
	}
	
	@Test
	void rookMovementTestBlackFriendlyPieceInWay3() {
		Rook rook = new Rook(false, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(false, new PiecePosition(3, 1));
		Bishop bishop2 = new Bishop(false, new PiecePosition(2, 2));
		Bishop bishop3 = new Bishop(false, new PiecePosition(3, 3));
		
		blankBoard.putPiece(3, 2, rook);
		blankBoard.putPiece(3, 1, bishop1);
		blankBoard.putPiece(2, 2, bishop2);
		blankBoard.putPiece(3, 3, bishop3);
		
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(2, piecePositions.size());
	}
	
	@Test
	void rookMovementTestWhiteFriendlyPieceInWay4() {
		Rook rook = new Rook(true, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(true, new PiecePosition(3, 1));
		Bishop bishop2 = new Bishop(true, new PiecePosition(2, 2));
		Bishop bishop3 = new Bishop(true, new PiecePosition(3, 3));
		Bishop bishop4 = new Bishop(true, new PiecePosition(4, 2));
		
		blankBoard.putPiece(3, 2, rook);
		blankBoard.putPiece(3, 1, bishop1);
		blankBoard.putPiece(2, 2, bishop2);
		blankBoard.putPiece(3, 3, bishop3);
		blankBoard.putPiece(4, 2, bishop4);
		
		
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(0, piecePositions.size());
	}
	
	@Test
	void rookMovementTestWhiteFriendlyPieceInWay2() {
		Rook rook = new Rook(true, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(true, new PiecePosition(3, 1));
		Bishop bishop2 = new Bishop(true, new PiecePosition(2, 2));
		
		blankBoard.putPiece(3, 2, rook);
		blankBoard.putPiece(3, 1, bishop1);
		blankBoard.putPiece(2, 2, bishop2);
		
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(4, piecePositions.size());
	}
	
	@Test
	void rookMovementTestWhiteFriendlyPieceInWay3() {
		Rook rook = new Rook(true, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(true, new PiecePosition(3, 1));
		Bishop bishop2 = new Bishop(true, new PiecePosition(2, 2));
		Bishop bishop3 = new Bishop(true, new PiecePosition(3, 3));
		
		blankBoard.putPiece(3, 2, rook);
		blankBoard.putPiece(3, 1, bishop1);
		blankBoard.putPiece(2, 2, bishop2);
		blankBoard.putPiece(3, 3, bishop3);
		
		
		piecePositions = rook.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(2, piecePositions.size());
	}

	@Test
	void knightMovementTestBlackStart1() {
		Knight knight = new Knight(false, new PiecePosition(0, 2));
		piecePositions = knight.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestBlackStart2() {
		Knight knight = new Knight(false, new PiecePosition(0, 3));
		piecePositions = knight.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestWhiiteStart1() {
		Knight knight = new Knight(true, new PiecePosition(5, 2));
		piecePositions = knight.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestWhiteStart2() {
		Knight knight = new Knight(true, new PiecePosition(5, 3));
		piecePositions = knight.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(4, piecePositions.size()); 
	}
	
	@Test
	void knightMovementTestMiddle() {
		Knight knight = new Knight(false, new PiecePosition(3, 2));
		blankBoard.putPiece(3, 2, knight);
		piecePositions = knight.validMovementsList(blankBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackStart1() {
		Bishop bishop = new Bishop(false, new PiecePosition(0, 1));
		piecePositions = bishop.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackStart2() {
		Bishop bishop = new Bishop(false, new PiecePosition(0, 4));
		piecePositions = bishop.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestWhiteStart1() {
		Bishop bishop = new Bishop(true, new PiecePosition(5, 1));
		piecePositions = bishop.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestWhiteStart2() {
		Bishop bishop = new Bishop(true, new PiecePosition(5, 4));
		piecePositions = bishop.validMovementsList(chessBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(3, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestMiddle() {
		Bishop bishop = new Bishop(false, new PiecePosition(3, 2));
		blankBoard.putPiece(3, 2, bishop);
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		// This will have to change after further implementation of Movement
		assertEquals(8, piecePositions.size()); 
	}
	
	@Test
	void bishopMovementTestBlackFriendlyPieceInWay4() {
		Bishop bishop = new Bishop(false, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(false, new PiecePosition(2, 1));
		Bishop bishop2 = new Bishop(false, new PiecePosition(2, 3));
		Bishop bishop3 = new Bishop(false, new PiecePosition(4, 1));
		Bishop bishop4 = new Bishop(false, new PiecePosition(4, 3));
		
		blankBoard.putPiece(3, 2, bishop);
		
		blankBoard.putPiece(2, 1, bishop1);
		blankBoard.putPiece(2, 3, bishop2);
		blankBoard.putPiece(4, 1, bishop3);
		blankBoard.putPiece(4, 3, bishop4);
		
		
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(0, piecePositions.size());
	}
	
	@Test
	void bishopMovementTestBlackFriendlyPieceInWay3() {
		Bishop bishop = new Bishop(false, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(false, new PiecePosition(2, 1));
		Bishop bishop2 = new Bishop(false, new PiecePosition(2, 3));
		Bishop bishop3 = new Bishop(false, new PiecePosition(4, 1));
		
		blankBoard.putPiece(3, 2, bishop);
		
		blankBoard.putPiece(2, 1, bishop1);
		blankBoard.putPiece(2, 3, bishop2);
		blankBoard.putPiece(4, 1, bishop3);
		
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(2, piecePositions.size());
	}
	
	@Test
	void bishopMovementTestBlackFriendlyPieceInWay2() {
		Bishop bishop = new Bishop(false, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(false, new PiecePosition(2, 1));
		Bishop bishop2 = new Bishop(false, new PiecePosition(2, 3));
		
		blankBoard.putPiece(3, 2, bishop);
		
		blankBoard.putPiece(2, 1, bishop1);
		blankBoard.putPiece(2, 3, bishop2);
		
		
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(4, piecePositions.size());
	}
	
	@Test
	void bishopMovementTestWhiteFriendlyPieceInWay4() {
		Bishop bishop = new Bishop(true, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(true, new PiecePosition(2, 1));
		Bishop bishop2 = new Bishop(true, new PiecePosition(2, 3));
		Bishop bishop3 = new Bishop(true, new PiecePosition(4, 1));
		Bishop bishop4 = new Bishop(true, new PiecePosition(4, 3));
		
		blankBoard.putPiece(3, 2, bishop);
		blankBoard.putPiece(2, 1, bishop1);
		blankBoard.putPiece(2, 3, bishop2);
		blankBoard.putPiece(4, 1, bishop3);
		blankBoard.putPiece(4, 3, bishop4);
		
		
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(0, piecePositions.size());
	}
	
	@Test
	void bishopMovementTestWhiteFriendlyPieceInWay3() {
		Bishop bishop = new Bishop(true, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(true, new PiecePosition(2, 1));
		Bishop bishop2 = new Bishop(true, new PiecePosition(2, 3));
		Bishop bishop3 = new Bishop(true, new PiecePosition(4, 1));
		
		blankBoard.putPiece(3, 2, bishop);
		
		blankBoard.putPiece(2, 1, bishop1);
		blankBoard.putPiece(2, 3, bishop2);
		blankBoard.putPiece(4, 1, bishop3);
		
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(2, piecePositions.size());
	}
	
	@Test
	void bishopMovementTestWhiteFriendlyPieceInWay2() {
		Bishop bishop = new Bishop(true, new PiecePosition(3, 2));
		Bishop bishop1 = new Bishop(true, new PiecePosition(2, 1));
		Bishop bishop2 = new Bishop(true, new PiecePosition(2, 3));

		blankBoard.putPiece(3, 2, bishop);
		
		blankBoard.putPiece(2, 1, bishop1);
		blankBoard.putPiece(2, 3, bishop2);		
		
		piecePositions = bishop.validMovementsList(blankBoard.getChessBoardArr());
		assertEquals(4, piecePositions.size());
	}
	
	@Test
	void ColLetterToNumberValid() throws models.PiecePosition.ColumnExeption {
		
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
	}
	
	@Test
	void ColLetterToNumber() throws models.PiecePosition.ColumnExeption {
		PiecePosition piecePosition = new PiecePosition(0, 0);
		assertThrows(models.PiecePosition.ColumnExeption.class, 
				() -> piecePosition.colNameLetterToNumber("G"));
	}
}
