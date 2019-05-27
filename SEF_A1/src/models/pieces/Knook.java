package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;
import models.interfaces.PieceInterface;

// The merge of Knight and Rook
public class Knook extends Piece implements PieceInterface
{
	
	public Knook(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "Q");
	}

	
	
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		Piece piece;
		
		// Adding Knight Movement pattern --------------------------------------
		
		potentialPositions.add(new PiecePosition(currRow + 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow + 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow - 1, currCol + 2));
		potentialPositions.add(new PiecePosition(currRow - 2, currCol + 1));
		
		potentialPositions.add(new PiecePosition(currRow + 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow + 1, currCol - 2));
		
		potentialPositions.add(new PiecePosition(currRow - 2, currCol - 1));
		potentialPositions.add(new PiecePosition(currRow - 1, currCol - 2));
		
		// end Knight ----------------------------------------------------------
		
		
		// Adding Rook Movement Pattern ----------------------------------------
		try {
			piece = arr[currRow + 1][currCol];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		// if there is a piece their and it is the same color then don't add
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow + 1, currCol));
			if (arr[currRow + 1][currCol].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow + 2, currCol));
			}
		}
		
		
		try {
			piece = arr[currRow-1][currCol];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow - 1, currCol));
			if (arr[currRow - 1][currCol].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow - 2, currCol));
			}
		}
		
		try {
			piece = arr[currRow][currCol + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow, currCol + 1));
			if (arr[currRow][currCol + 1].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow, currCol + 2));
			}
		}
		
		
		try {
			piece = arr[currRow][currCol - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow, currCol - 1));
			if (arr[currRow][currCol - 1].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow, currCol - 2));
			}
		}
		// End Rook ------------------------------------------------------------
		
		return potentialPositions;

	}
}
