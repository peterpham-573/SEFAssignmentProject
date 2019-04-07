package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

/*
 * All white Pieces are LowerCase and Black are UpperCase
 */

public class Piece2 {
	boolean isWhite; // true if Piece is white false if black
	PiecePosition piecePosition;
	String icon = "_"; // Blank space
	
	public Piece2(boolean isWhite, PiecePosition piecePosition, String icon) {
		this.isWhite = isWhite;
		this.piecePosition = piecePosition;
		// all white pieces are LowerCase
		if (isWhite) {
			this.icon = icon.toLowerCase();
		} else
			this.icon = icon.toUpperCase();
	}
	
	public Piece2() {
	}
	
	/*
	 * This method should be overridden in the more specific Piece classes of 
	 * Rook, Knight, and Bishop
	 * 
	 * Should return a list of all valid movements/ new positions based on the 
	 * movement Pattern
	 * 
	 * Furthermore, the movement should then return a list of all the possible movements of the piece
	 * Step 1: Select a Piece
	 * Step 2: Get every new position that the Piece can move to
	 * Step 3: Filter out all of the invalid moves, leaving us with just the valid movement options
	 * Step 4: Have user specify new position and match it with the valid movement options
	 */
	LinkedList<PiecePosition> movement() {
		// TODO Auto-generated method stub
		// Default movement pattern
		return null;
	}
	
	// If any of the potential Positions of the Piece are out of the bounds
	// of the 2D array then remove it from the list
	LinkedList<PiecePosition> removeInvalidPositions(LinkedList<PiecePosition> pos) {
		for (PiecePosition piecePosition : pos) {
			 if ((piecePosition.getRow() > 5) ||
					 (piecePosition.getRow() < 0) ||
					 (piecePosition.getCol() > 5) ||
					 (piecePosition.getCol() < 0)) {
				 pos.remove(piecePosition);
			 }
		}
		
		return pos;
	}
	
	public String getIcon() {
		return icon;
	}

}
