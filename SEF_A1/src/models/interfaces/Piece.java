package models.interfaces;

public interface Piece {

	/*
	 * Boolean for if the piece will be white or not, will help in pieces checking if other
	 * pieces are its friend or foe
	 */
	public abstract boolean IsWhite();
	
	public abstract boolean isValidMove(int initialx, int initialy, int possiblex, int possibley);
	
	public abstract int getXPos();
	
	public abstract void setXPos(int xPos);
	
	public abstract int getYPos();
	
	public abstract void setYPos(int yPos);
	
}
