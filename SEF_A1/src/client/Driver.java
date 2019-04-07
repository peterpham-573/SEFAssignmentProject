package client;

import javax.swing.SwingUtilities;

import models.ChessBoard;
import view.Window;

public class Driver {

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new Window();
			}
		}
		);
		
		System.out.println("Player One Login");
		// login code call 
		System.out.println("Player Two Login");
		// Login code call 
		//PLayer one starts as White
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.printBoard();
		// Do a while loop that loops while game is not ended, Have a method call that checks on the 
		// game Termination criteria (n moves, Pieces Captured/remaining)
		
		// Selecting a Piece
		// Must be white or black Piece depending on player, and icon != _
		
	}
}
