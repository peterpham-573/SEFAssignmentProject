package models.interfaces;


import models.ChessBoard;
import models.ChessPlayer;
import models.pieces.Piece;

public interface ChessGameEngine {
	
	public abstract void movePiece(String start, String end);
	
	public abstract void capture(Piece piece, Piece piece2);
	
	public abstract void addPlayer(ChessPlayer player);
	
	public abstract ChessPlayer getPlayer(String user);
	
	public abstract void removePlayer(ChessPlayer player);
	
	public ChessBoard getChessBoard();
	
	public abstract ChessPlayer getPlayerOne();

	public abstract ChessPlayer getPlayerTwo();

	public abstract void setPlayerOne(ChessPlayer player);

	public abstract void setPlayerTwo(ChessPlayer player);
}
