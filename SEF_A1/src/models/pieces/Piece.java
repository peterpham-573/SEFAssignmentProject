package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;
import models.interfaces.PieceInterface;

/*
 * All white Pieces are LowerCase and Black are UpperCase
 */

public class Piece implements PieceInterface{
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
	
	public boolean isMergedPiece() { 
		if (this instanceof Knook || 
				this instanceof Bishook || 
				this instanceof Knightshop) {
//			System.out.println("Selected a merged piece");
			return true;
		}
//		System.out.println("Not a Merged piece");
		return false;
	}
	
	public boolean isEnemyOrEmpty(Piece enemy) {
		if ((isWhite != enemy.isWhite && !enemy.getIcon().equals("_") )
				|| enemy.getIcon().equals("_")) {
//			System.out.println("Is enemy");
			return true;
		}
			
//		System.out.println("Not enemy");
		return false;
	}
	
	// If any of the potential Positions of the Piece are out of the bounds
	// of the 2D array then remove it from the list
	//unused method
	
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
