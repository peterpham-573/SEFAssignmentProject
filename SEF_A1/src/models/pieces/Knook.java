package models.pieces;

import java.util.LinkedList;

import models.PiecePosition;

// The merge of Knight and Rook
public class Knook extends Piece
{
	
	public Knook(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "Q");
	}

}
