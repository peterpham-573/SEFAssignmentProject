package models.interfaces;


import models.ChessBoard;
import models.ChessPlayer;
import models.PiecePosition;
import models.pieces.Piece;

public interface ChessGameEngine {
	
	public boolean movePiece(PiecePosition start, PiecePosition end);
	
	public void capture(Piece piece, Piece piece2);
	
	public void merge(Piece piece, Piece piece2, PiecePosition start, PiecePosition end);
	
	public boolean splitPieces(Piece piece, PiecePosition start, PiecePosition end);
	
	public void addPlayer(ChessPlayer player);
	
	public ChessPlayer getPlayer(String user);
	
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

	public void calculateMaxTurns();

	public boolean checkGameEnd();

	public int remainingTurns();
	
	public String getWinningMessage();
	
	public String getCurrentPlayerTurn();
	
	public boolean isWhitePlayerTurn();
	//change player turn
	public void changePlayerTurn();
	
	public void setSplitCheck(boolean c);
	
	public boolean getSplitCheck();
}
