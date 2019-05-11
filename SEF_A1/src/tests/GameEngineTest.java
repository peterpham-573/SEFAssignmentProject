package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ChessGameEngineImpl;
import models.PiecePosition;
import models.interfaces.ChessGameEngine;
import models.pieces.Bishop;
import models.pieces.Knight;
import models.pieces.Piece;
import models.pieces.Rook;

/* Testing of the game engine to ensure that moves are correct. */
class GameEngineTest 
{

	ChessGameEngine ge;
	LinkedList<PiecePosition> piecePos;
	Piece rook, rookEnemy;
	Piece knight;
	Piece bishop;

	@BeforeEach
	void setUpItems() throws Exception
	{
		//creating pieces and boards
		ge = new ChessGameEngineImpl();
		
		rook = new Rook(true, new PiecePosition(5, 0));
		knight = new Knight(true, new PiecePosition(2, 0));
		bishop = new Bishop(true, new PiecePosition(4,0));
		
		ge.getChessBoard().setPiece(rook, 5, 0);
		ge.getChessBoard().setPiece(knight, 2, 0);
		ge.getChessBoard().setPiece(bishop, 4, 0);
		
		rookEnemy = new Rook(false, new PiecePosition(6, 0));
		ge.getChessBoard().setPiece(rook, 5, 1);
	}
	
	@Test
	void moveRookInvalidMove() 
	{
		assertFalse(ge.getChessBoard().movePiece("A5", "A2"));
	}

	@Test
	void moveRookValidMove() 
	{
		assertTrue(ge.getChessBoard().movePiece("A5", "A4"));
	}
	
	@Test
	void moveKnightInvalidMove() 
	{
		assertTrue(ge.getChessBoard().movePiece("A2", "B4"));
	}
	
	@Test
	void moveKnightValidMove()
	{
		assertTrue(ge.getChessBoard().movePiece("A2", "B4"));
	}
	
	@Test
	void moveBishopInvalidMove() 
	{
		assertFalse(ge.getChessBoard().movePiece("A4", "A5"));
	}
	
	@Test
	void moveBishopValidMove()
	{
		assertTrue(ge.getChessBoard().movePiece("A4", "B5"));
	}
	
//	void capture()
//	{
//		piecePos = rookEnemy.validMovementsList();
//		assertTrue(ge.getChessBoard().movePiece("B5", "A5"));
//	}
	
}
