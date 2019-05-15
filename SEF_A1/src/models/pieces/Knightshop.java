package models.pieces;

import models.PiecePosition;

// The merge of Knight and Bishop
public class Knightshop extends Piece
{
	public Knightshop(boolean isWhite, PiecePosition piecePosition)
	{
		super(isWhite, piecePosition, "B");
	}
}
