package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;
import models.interfaces.PieceInterface;

// The merge of Bishop and Rook
public class Bishook extends Piece implements PieceInterface
{
	public Bishook(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "T");
	}
	
	
	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr) {
		int currRow = piecePosition.getRow();
		int currCol = piecePosition.getCol();
		LinkedList<PiecePosition> potentialPositions = new LinkedList<>();
		Piece piece;
		
		// Adding Bishop movement patterns -------------------------------------
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
		
		// End Bishop ----------------------------------------------------------
		
		// Adding Rook Movement Patterns -------------------------------------
		
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
		
		// End Rook
			
		return potentialPositions;
	}
}
