package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

public class Rook2 extends Piece2{

	public Rook2(boolean isWhite, PiecePosition piecePosition) {
		// TODO Auto-generated constructor stub
		super(isWhite, piecePosition, "r");
	}
	
	// the Rook Movement Pattern
	public LinkedList<PiecePosition> validMovementsList() {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		
		potentialPositions.add(new PiecePosition(currRow + 1, currCol));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol));
		
		potentialPositions.add(new PiecePosition(currRow, currCol + 1));
		potentialPositions.add(new PiecePosition(currRow, currCol + 2));
		
		potentialPositions.add(new PiecePosition(currRow, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow, currCol - 2));
		
		potentialPositions = removeInvalidPositions(potentialPositions);
		
		return potentialPositions;

	}
	
}