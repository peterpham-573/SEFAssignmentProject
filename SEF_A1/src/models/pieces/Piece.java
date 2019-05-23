package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

/*
 * All white Pieces are LowerCase and Black are UpperCase
 */

public class Piece {
	boolean isWhite; // true if Piece is white false if black
	PiecePosition piecePosition;
	String icon = "_"; // Blank space
	
	public Piece(boolean isWhite, PiecePosition piecePosition, String icon) {
		this.isWhite = isWhite;
		this.piecePosition = piecePosition;
		// all white pieces are LowerCase
		if (isWhite) {
			this.icon = icon.toLowerCase();
		} else
			this.icon = icon.toUpperCase();
	}
	
	public boolean isEnemyOf(Piece enemy) {
		if (isWhite != enemy.isWhite && !enemy.getIcon().equals("_")) {
			// then it is an enemy Piece
			return true;
		}
		return false;
	}
	
	public boolean isMergable(Piece mergePiece) {
		// if pieces are of same color, not a blank spot, and not the same Piece
		if (isWhite == mergePiece.isWhite && 
				!mergePiece.getIcon().equals("_") &&
				!icon.equals(mergePiece.getIcon())) {
			return true;
		}
		return false;
	}
	
	public Piece() {
	}
	
	/*
	 * This method should be overridden in the more specific Piece classes of 
	 * Rook, Knight, and Bishop
	 * 
	 * Should return a list of all valid movements/ new positions based on the 
	 * movement Pattern
	 * 
	 * Furthermore, the movement should then return a list of all the possible movements of the piece
	 * x Step 1: Select a Piece
	 * x Step 2: Get every new position that the Piece can move to
	 * x Step 3: Filter out all of the invalid moves, leaving us with just the valid movement options
	 * Step 4: Have user specify new position and match it with the valid movement options
	 */
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		return null;
	}
	
	// If any of the potential Positions of the Piece are out of the bounds
	// of the 2D array then remove it from the list
	//unused method
	LinkedList<PiecePosition> removeInvalidPositions(LinkedList<PiecePosition> pos, Piece[][] arr) {
		LinkedList<PiecePosition> goodPos = new LinkedList<>();
		LinkedList<PiecePosition> goodMoves = new LinkedList<>();
		
		// May not need this for each loop
		for (PiecePosition piecePosition : pos) {
			// Filtering out all of the bad positions that are not in the bounds of 
			// the game board
			if ((piecePosition.getRow() > 5) ||
					 (piecePosition.getRow() < 0) ||
					 (piecePosition.getCol() > 5) ||
					 (piecePosition.getCol() < 0)) {
			 } else
				 // Adding all of the good positions of the Piece to this List
				 goodPos.add(piecePosition);
		}
		
		// filter out if Pieces are in the way
		for (PiecePosition piecePosition : goodPos) {
			Piece piece = arr[piecePosition.getRow()][piecePosition.getCol()];
			// If the space is blank then it is good
			// Need to change to OR if it has a piece of the opposite color in it
			if (piece.getIcon().equals("_") || (piece.isWhite != isWhite)) {
				goodMoves.add(piecePosition);
			}
		}
		return goodMoves;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public boolean isWhite() {
		return isWhite;
	}
	
	public void setPiecePositon(PiecePosition piecePosition) {
		this.piecePosition = piecePosition;
	}

}
