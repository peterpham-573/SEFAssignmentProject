package models;
/*
 *  This class is for creating Position objects for each Piece of the Chess Game
 */


public class PiecePosition {
	
	int row;
	int col;
	
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

	/*
	 * This is for converting the Character/String input of the naming convention
	 * to the equivalent integer value for Col position in the game board
	 */
	int colNameLetterToNumber(String A_F) {
		String string = A_F.toUpperCase();
		switch (string) {
		case "A":
			return 0;
		case "B":
			return 1;
		case "C":
			return 2;
		case "D":
			return 3;
		case "E":
			return 4;
		case "F":
			return 5;

		}
		return -1;
	}

}
