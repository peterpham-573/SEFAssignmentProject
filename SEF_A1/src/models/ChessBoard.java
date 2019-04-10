package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.Current;

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
	
	// Checks if the string input is of the correct form
	PiecePosition toPos(String s) {
		// Should change this to a Regex
		String regex = "[A-Fa-f][0-5]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (!matcher.matches()) {
			System.out.println("Invalid Input");
			return null;
		} else {
			PiecePosition pos = new PiecePosition(Integer.parseInt(s.substring(1)), s.substring(0, 1));
			return pos;
		}
	}
	
	// Moves the selected Piece at start to the position at end
	public boolean movePiece(String start, String end) {
		PiecePosition startPos = toPos(start);
		PiecePosition endPos = toPos(end);
		if (startPos == null || endPos == null) {
			return false;
		}
		// Check player has selected the right colored piece
		// check if the endPos exists in the list

		/*
		 *  if currentPlayer == Player1 (isWhite) and
		 *  	chessBoardArr[startPos.getRow()][startPos.getCol()].isWhite then
		 *   		get movement list and check if for any of the PiecePositions in the list
		 *   		are equal to endPos (use isEqual Method)
		 *   			if we get a true then move the Piece else invalid move
		 */
		chessBoardArr[endPos.getRow()][endPos.getCol()] = 
				chessBoardArr[startPos.getRow()][startPos.getCol()];
		chessBoardArr[startPos.getRow()][startPos.getCol()] = new Piece2();
		return true;
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
		
		System.out.print("\n  A B C D E F");
		for(int i = 0; i < chessBoardArr.length; i++) {
			System.out.println();
			System.out.print(i);
			for(int j = 0; j < chessBoardArr[i].length; j++) {
				System.out.print(" " + chessBoardArr[i][j].getIcon());
			}
		}
		System.out.println("");
	}
	
}
