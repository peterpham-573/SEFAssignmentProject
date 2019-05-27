package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;
import models.interfaces.PieceInterface;

public class Bishop extends Piece implements PieceInterface{

	public Bishop(boolean isWhite, PiecePosition piecePosition) {
		super(isWhite, piecePosition, "b");
	}
	
	// The Bishop Movement Pattern
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		Piece piece;
		
		try {
			piece = arr[currRow + 1][currCol + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		// if there is a piece their and it is the same color then don't add
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow + 1, currCol + 1));
			if (arr[currRow + 1][currCol + 1].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow + 2, currCol + 2));
			}
		}
		
		
		try {
			piece = arr[currRow - 1][currCol + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow - 1, currCol + 1));
			if (arr[currRow - 1][currCol + 1].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow - 2, currCol + 2));
			}
		}
		
		try {
			piece = arr[currRow + 1][currCol - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow + 1, currCol - 1));
			if (arr[currRow + 1][currCol - 1].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow + 2, currCol - 2));
			}
		}
		
		
		try {
			piece = arr[currRow - 1][currCol - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		if((piece == null)) {
			
		} else {
			potentialPositions.add(new PiecePosition(currRow - 1, currCol - 1));
			if (arr[currRow - 1][currCol - 1].getIcon().equalsIgnoreCase("_"))
			{
				potentialPositions.add(new PiecePosition(currRow - 2, currCol - 2));
			}
		}
		
		return potentialPositions;
	}

}
