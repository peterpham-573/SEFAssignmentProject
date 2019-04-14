package models.interfaces;

import models.ChessBoard;
import models.ChessPlayer;
import models.pieces.Piece;

public interface ChessGameEngine {
	
	public abstract void movePiece(Piece piece);
	
	public abstract void capture(Piece piece);
	
	public abstract void addPlayer(ChessPlayer player);
	
	public abstract void getPlayer(String id);
	
	public abstract void removePlayer(ChessPlayer player);
	
	public abstract void addChessboard(ChessBoard cb);
	
	public abstract void removeChessboard(ChessBoard cb);

}
