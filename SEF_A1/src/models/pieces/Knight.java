package models.pieces;

import models.interfaces.Piece;

public class Knight implements Piece {
	
	private boolean isWhite;
	private int xPosition;
	private int yPosition;
	
	public Knight(boolean isWhite, int xPos, int yPos) {
		this.isWhite = isWhite;
		this.xPosition = xPos;
		this.yPosition = yPos;
	}

	@Override
	public boolean IsWhite() {
		return isWhite;
	}

	@Override
	public boolean isValidMove(int initialx, int initialy, int possiblex, int possibley) {
		return false;
	}

	@Override
	public int getXPos() {
		return xPosition;
	}

	@Override
	public void setXPos(int xPos) {
		this.xPosition = xPos;
	}

	@Override
	public int getYPos() {
		return yPosition;
	}

	@Override
	public void setYPos(int yPos) {
		this.yPosition = yPos;
	}

}
