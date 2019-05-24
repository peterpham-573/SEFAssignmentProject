package models.interfaces;

import models.PiecePosition;
import models.pieces.Piece;

public interface Board {

	public void fillBoardWithBlank();
	
	public Piece[][] getChessBoardArr();
	
	// Checks if the string input is of the correct form
	PiecePosition toPos(String s);
	
	// Moves the selected Piece at start to the position at end
	// add another argument of player to help determine if they should be moving a black or white piece
	public boolean movePiece(String start, String end);
	
	public boolean movePiece(PiecePosition startPos, PiecePosition endPos);
	
	// These values are just place holders for now
	void setGameBoard();
	
}