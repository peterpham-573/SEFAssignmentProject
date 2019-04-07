package models;

import models.pieces.Bishop2;
import models.pieces.Knight2;
import models.pieces.Piece2;
import models.pieces.Rook2;

public class ChessBoard {

	Piece2 [][] chessBoardArr;
	
	public ChessBoard() {
		chessBoardArr = new Piece2[6][6];
		fillBoardWithBlank();
		setGameBoard();
	}
	
	void fillBoardWithBlank() {
		for(int i = 0; i < chessBoardArr.length; i++) {
			for(int j = 0; j < chessBoardArr[i].length; j++) {
				chessBoardArr[i][j] = new Piece2();
			}
		}
	}
	
	public Piece2[][] getChessBoardArr() {
		return chessBoardArr;
	}
	
	// These values are just place holders for now
	void setGameBoard() {
		// Setting the Black Pieces
		chessBoardArr[0][0] = new Rook2(false, new PiecePosition(0, 0));
		chessBoardArr[0][1] = new Bishop2(false, new PiecePosition(0, 1));
		chessBoardArr[0][2] = new Knight2(false, new PiecePosition(0, 2));
		chessBoardArr[0][3] = new Knight2(false, new PiecePosition(0, 3));;
		chessBoardArr[0][4] = new Bishop2(false, new PiecePosition(0, 4));
		chessBoardArr[0][5] = new Rook2(false, new PiecePosition(0, 5));;
		
		// Setting the White Pieces
		chessBoardArr[5][0] = new Rook2(true, new PiecePosition(5, 0));
		chessBoardArr[5][1] = new Bishop2(true, new PiecePosition(5, 1));
		chessBoardArr[5][2] = new Knight2(true, new PiecePosition(5, 2));
		chessBoardArr[5][3] = new Knight2(true, new PiecePosition(5, 3));;
		chessBoardArr[5][4] = new Bishop2(true, new PiecePosition(5, 4));
		chessBoardArr[5][5] = new Rook2(true, new PiecePosition(5, 5));;
	}
	
	/*This Should be moved to the View Controller of the Game, and once moved to have the argument
	 * Piece2[][] board, Passed in
	 *  printBoard - takes in the chessBoard 2D array and prints out its current state
	 *  	It also prints the position identifiers for the rows and columns of the board
	 *  
	 *  i is row, j is column
	 *  
	 */
	public void printBoard() {
		System.out.print("  A B C D E F");
		for(int i = 0; i < chessBoardArr.length; i++) {
			System.out.println();
			System.out.print(i);
			for(int j = 0; j < chessBoardArr[i].length; j++) {
				System.out.print(" " + chessBoardArr[i][j].getIcon());
			}
		}
	}
	
}
