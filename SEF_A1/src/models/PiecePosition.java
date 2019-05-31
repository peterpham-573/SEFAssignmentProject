package models;
/*
 *  This class is for creating Position objects for each Piece of the Chess Game
 */


public class PiecePosition {


	private int row;
	private int col;
	
	public PiecePosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public boolean isEqual(PiecePosition pos) {
		return ((col == pos.getCol()) && (row == pos.getRow()));
	}
}

