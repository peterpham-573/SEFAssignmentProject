package models.interfaces;

import java.util.LinkedList;

import models.PiecePosition;
import models.pieces.Piece;

public interface PieceInterface {

	public LinkedList<PiecePosition> validMovementsList(Piece[][] arr);
	
}
