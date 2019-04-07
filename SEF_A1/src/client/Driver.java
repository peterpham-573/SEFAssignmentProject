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
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.printBoard();
	}
}
