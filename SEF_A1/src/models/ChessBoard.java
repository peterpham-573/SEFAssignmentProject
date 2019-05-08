package models;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.Current;

import models.pieces.Bishop;
import models.pieces.Knight;
import models.pieces.Piece;
import models.pieces.Rook;

public class ChessBoard {

	Piece [][] chessBoardArr;
	private Piece blackRook1, blackRook2, blackKnight1, blackKnight2, blackBishop1, blackBishop2;
	private Piece whiteRook1, whiteRook2, whiteKnight1, whiteKnight2, whiteBishop1, whiteBishop2;
	
	public ChessBoard() {
		chessBoardArr = new Piece[6][6];
		fillBoardWithBlank();
		setGameBoard();
	}
	
	public void fillBoardWithBlank() {
		for(int i = 0; i < chessBoardArr.length; i++) {
			for(int j = 0; j < chessBoardArr[i].length; j++) {
				chessBoardArr[i][j] = new Piece();
			}
		}
	}
	
	public Piece[][] getChessBoardArr() {
		return chessBoardArr;
	}
	
	public void putPiece(int row, int col, Piece p) {
		chessBoardArr[row][col] = p;
	}
	
	// Checks if the string input is of the correct form
	PiecePosition toPos(String s) {
		// Should change this to a Regex
		String regex = "[A-Fa-f][0-5]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		if (!matcher.matches()) {
			return null;
		} else {
			PiecePosition pos = new PiecePosition(Integer.parseInt(s.substring(1)), s.substring(0, 1));
			return pos;
		}
	}
	
	
	// Moves the selected Piece at start to the position at end
	// add another argument of player to help determine if they should be moving a black or white piece
	public boolean movePiece(String start, String end) {
		PiecePosition startPos = toPos(start);
		PiecePosition endPos = toPos(end);
		if (startPos == null || endPos == null) {
			System.out.println("Invalid Input");
			return false;
		}
		// Check player has selected the right colored piece
		// check if the endPos exists in the list

		/*
		 *  if currentPlayer == Player1 (isWhite) and
		 *  	chessBoardArr[startPos.getRow()][startPos.getCol()].isWhite then
		 *   		x - get movement list and check if for any of the PiecePositions in the list
		 *   		x - are equal to endPos (use isEqual Method)
		 *   			x - if we get a true then move the Piece else invalid move
		 *   
		 *   x means it has been implemented
		 */
		LinkedList<PiecePosition> validMovementsList = 
				chessBoardArr[startPos.getRow()][startPos.getCol()].validMovementsList(chessBoardArr);
		
		for (PiecePosition validPiecePosition : validMovementsList) {
			if (validPiecePosition.isEqual(endPos)) {
				// move is good
				chessBoardArr[endPos.getRow()][endPos.getCol()] = 
						chessBoardArr[startPos.getRow()][startPos.getCol()];
				chessBoardArr[startPos.getRow()][startPos.getCol()] = new Piece();
				return true;
			}
		}
		// endPos is not a valid input for the selected piece at startPos
		return false;
	}
	
	// These values are just place holders for now
	void setGameBoard() {
		
		// Creating the black pieces
		blackRook1 = new Rook(false, new PiecePosition(0, 0));
		blackRook2 = new Rook(false, new PiecePosition(0, 5));
		blackKnight1 = new Knight(false, new PiecePosition(0, 2));
		blackKnight2 = new Knight(false, new PiecePosition(0, 3));
		blackBishop1 = new Bishop(false, new PiecePosition(0, 1));
		blackBishop2 = new Bishop(false, new PiecePosition(0, 4));
		
		// Setting the Black Pieces
		chessBoardArr[0][0] = blackRook1;
		chessBoardArr[0][1] = blackBishop1;
		chessBoardArr[0][2] = blackKnight1;
		chessBoardArr[0][3] = blackKnight2;
		chessBoardArr[0][4] = blackBishop2;
		chessBoardArr[0][5] = blackRook2;
		
		// Setting the White Pieces
		whiteRook1 = new Rook(true, new PiecePosition(5, 0));
		whiteBishop1 = new Bishop(true, new PiecePosition(5, 1));
		whiteKnight1 = new Knight(true, new PiecePosition(5, 2));
		whiteKnight2 = new Knight(true, new PiecePosition(5, 3));;
		whiteBishop2 = new Bishop(true, new PiecePosition(5, 4));
		whiteRook2 = new Rook(true, new PiecePosition(5, 5));;
		
		// Setting the White Pieces
		chessBoardArr[5][0] = whiteRook1;
		chessBoardArr[5][1] = whiteBishop1;
		chessBoardArr[5][2] = whiteKnight1;
		chessBoardArr[5][3] = whiteKnight2;
		chessBoardArr[5][4] = whiteBishop2;
		chessBoardArr[5][5] = whiteRook2;
	}
	
	
	/*
	 * CUSTOM METHODS
	 */
	
	public Piece getPieceOnBoard(int x, int y)
	{
		if(chessBoardArr[x][y]!=null)
		return chessBoardArr[x][y];
		
		return null;
	}
	
	public void removePiece(Piece piece, Piece piece2)
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				if(chessBoardArr[i][j] == piece2)
				{
					chessBoardArr[i][j] = null;
					setPiece(piece, i, j);
				}
			}
		}
	}
	
	public void setPiece(Piece piece, int x, int y)
	{		
		chessBoardArr[x][y] = piece;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
