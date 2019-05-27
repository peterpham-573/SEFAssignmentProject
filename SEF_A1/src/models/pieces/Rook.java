package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;
import models.interfaces.PieceInterface;

public class Rook extends Piece implements PieceInterface{

	public Rook(boolean isWhite, PiecePosition piecePosition) {
		// TODO Auto-generated constructor stub
		super(isWhite, piecePosition, "r");
	}
	
	// the Rook Movement Pattern
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		Piece piece;
		
		try {
			piece = arr[currRow + 1][currCol];
		} catch (ArrayIndexOutOfBoundsException e) {
			piece = null;
		}
		
		// if there is a piece their and it is the same color then don't add
		if((piece == null)) {
			
		} else {
//			if (!(arr[currRow + 1][currCol] instanceof Bishook    ||
//				  arr[currRow + 1][currCol] instanceof Knightshop ||
//				  arr[currRow + 1][currCol] instanceof Knook	  ) &&
//				  (arr[currRow][currCol].isWhite() != arr[currRow + 1][currCol].isWhite() || arr[currRow + 1][currCol].getIcon().equalsIgnoreCase("_")))
//			{
					potentialPositions.add(new PiecePosition(currRow + 1, currCol));
				
				if (arr[currRow + 1][currCol].getIcon().equalsIgnoreCase("_"))
				{
					
						potentialPositions.add(new PiecePosition(currRow + 2, currCol));
				}
//			}
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
		
		return potentialPositions;

	}
	
}