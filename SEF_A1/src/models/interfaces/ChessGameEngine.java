package models.interfaces;


import models.ChessBoard;
import models.ChessPlayer;
import models.PiecePosition;
import models.pieces.Piece;

public interface ChessGameEngine {
	
	public boolean movePiece(PiecePosition start, PiecePosition end);
	
	public void capture(Piece piece, Piece piece2);
	
	public void merge(Piece piece, Piece piece2, PiecePosition start, PiecePosition end);
	
	public void split(PiecePosition place);
	
	public void addPlayer(ChessPlayer player);
	
	public ChessPlayer getPlayer(String user);
	
	public void removePlayer(ChessPlayer player);
	
	public ChessBoard getChessBoard();
	
	public ChessPlayer getPlayerOne();

	public ChessPlayer getPlayerTwo();

	public void setPlayerOne(ChessPlayer player);

	public void setPlayerTwo(ChessPlayer player);
	
	public PiecePosition getStart();
	
	public PiecePosition getEnd();
	
	public void setStart(int i, int j);
	
	public void setEnd(int i, int j);
	
	public boolean checkStart();
	
	public boolean checkEnd();
	
	public void resetChecks();
	
	public boolean getValidCheck();
	
//	public void checkMovePiece();
}
