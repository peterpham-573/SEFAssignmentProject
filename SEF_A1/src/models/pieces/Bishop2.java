package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

public class Bishop2 extends Piece2 {

	public Bishop2(boolean isWhite, PiecePosition piecePosition) {
		super(isWhite, piecePosition, "b");
	}
	
	// The Bishop Movement Pattern
	LinkedList<PiecePosition> movement() {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		
		potentialPositions.add(new PiecePosition(currRow + 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol + 2));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol + 1));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol + 2));
		
		potentialPositions.add(new PiecePosition(currRow + 1, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol - 2));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol - 2));
		
		potentialPositions = removeInvalidPositions(potentialPositions);
		
		return potentialPositions;
	}

}
