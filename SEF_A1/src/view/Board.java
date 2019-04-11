package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.pieces.Piece2;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
		
		g.fillRect(100, 100, 600, 600);
		
		for(int i = 200; i <= 600; i += 200)
		{
			for(int j = 100; j <= 650; j += 200)
			{
				g.clearRect(i, j, 100, 100);
			}
		}
		for(int i = 100; i <= 650; i += 200)
		{
			for(int j = 200; j <= 600; j += 200)
			{
				g.clearRect(i, j, 100, 100);
			}
		}
	}
	
	/* This is for showing the players the passed in board state
	 *  printBoard - takes in the chessBoard 2D array and prints out its current state
	 *  	It also prints the position identifiers for the rows and columns of the board
	 *  
	 *  i is row, j is column
	 *  
	 */
	public void printBoard(Piece2[][] chessBoardArr) {
		
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
