package models.interfaces;

public interface ChessGameEngine {
	
	public abstract void movePiece(Piece piece);
	
	public abstract void addPlayer(Player player);
	
	public abstract void getPlayer(String id);
	
	public abstract void removePlayer(Player player);
	
	public abstract void addChessboard(Chessboard cb);
	
	public abstract void removeChessboard(Chessboard cb);

}
