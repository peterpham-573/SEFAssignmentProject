package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

public class Knight extends Piece{
	
	public Knight(boolean isWhite, PiecePosition piecePosition) {
		super(isWhite, piecePosition, "k");
	}
	
	// the Knight Movement Pattern
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		
		potentialPositions.add(new PiecePosition(currRow + 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow + 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow + 1, currCol - 2));
		
		potentialPositions.add(new PiecePosition(currRow - 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow - 1, currCol - 2));
		
		return potentialPositions;
	}
}
