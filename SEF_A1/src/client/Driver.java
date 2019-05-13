package client;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import models.ChessGameEngineImpl;
import models.interfaces.ChessGameEngine;
import view.Board;
import view.Window;

/*
 * This is the controller class
 */

public class Driver {
	static Scanner scanner = new Scanner(System.in);
	static Board boardView = new Board();
	

	public static void main(String[] args) 
	{
		
		//Danny's code to implement for logging in 
		
		//if both players log in 
		ChessGameEngine ge = new ChessGameEngineImpl();
	
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new Window(ge);
			}
		}
		);
		
		
		System.out.println("Player One Login");
		// login code call 
		System.out.println("Player Two Login");
		// Login code call 
		
		//Player one starts as White
		
		
		boardView.printBoard(ge.getChessBoard().getChessBoardArr());
		// Do a while loop that loops while game is not ended, Have a method call that checks on the 
		// game Termination criteria (n moves, Pieces Captured/remaining)
		while(terminate()) 
		{
			System.out.println("Select Piece at Location: ");
			String startPosPiece = scanner.nextLine();
			System.out.println("Location to Move Piece To: ");
			String endPosPiece = scanner.nextLine();
//			ge.movePiece(startPosPiece, endPosPiece);
			boardView.printBoard(ge.getChessBoard().getChessBoardArr());
			startPosPiece = null;
			endPosPiece = null;
		}
		// Selecting a Piece
		// Must be white or black Piece depending on player, and icon != _
		
		
	}
	
	static boolean terminate() {
		return true;
	}
	
	
	
}
