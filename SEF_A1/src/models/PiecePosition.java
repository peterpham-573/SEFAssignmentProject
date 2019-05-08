package models;
/*
 *  This class is for creating Position objects for each Piece of the Chess Game
 */


public class PiecePosition {
	
	public class ColumnExeption extends Exception {
		private static final long serialVersionUID = 1L;
		String letter;
		
		public ColumnExeption(String s) {
			letter = s;
		}
		
		public String toString() {
			return "Column Letter identifier " + letter + " is invlaid";
		}

		public ColumnExeption() {
			// TODO Auto-generated constructor stub
		}

	}


	private int row;
	private int col;
	
	public PiecePosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public PiecePosition(int row, String col) {
		this.row = row;
		try {
			this.col = colNameLetterToNumber(col);
		} catch (ColumnExeption e) {
			System.out.println(e.toString());
		}
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public boolean isEqual(PiecePosition y) {
		return ((col == y.col) && (row == y.row));
	}

	/*
	 * This is for converting the Character/String input of the naming convention
	 * to the equivalent integer value for Col position in the game board
	 * 
	 * Should create an exception class to be thrown here for wrong input of col
	 */
	public int colNameLetterToNumber(String A_F) throws ColumnExeption {
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
		throw new ColumnExeption(A_F);
	}

}

