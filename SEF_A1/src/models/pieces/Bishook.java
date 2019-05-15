package models.pieces;

import models.PiecePosition;

// The merge of Bishop and Rook
public class Bishook extends Piece
{
	public Bishook(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "T");
	}
}
