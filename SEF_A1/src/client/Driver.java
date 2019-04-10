package client;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import models.ChessBoard;
import view.Window;

public class Driver {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) 
	{
//		SwingUtilities.invokeLater(new Runnable()
//		{
//			public void run()
//			{
//				new Window();
//			}
//		}
//		);
		
		System.out.println("Player One Login");
		// login code call 
		System.out.println("Player Two Login");
		// Login code call 
		//PLayer one starts as White
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.printBoard();
		// Do a while loop that loops while game is not ended, Have a method call that checks on the 
		// game Termination criteria (n moves, Pieces Captured/remaining)
		while(terminate()) {
			System.out.println("Select Piece at Location: ");
			String startPosPiece = scanner.nextLine();
			System.out.println("Location to Move Piece To: ");
			String endPosPiece = scanner.nextLine();
			chessBoard.movePiece(startPosPiece, endPosPiece);
			chessBoard.printBoard();
		}
		// Selecting a Piece
		// Must be white or black Piece depending on player, and icon != _
		
		
	}
	
	static boolean terminate() {
		return true;
	}
}
