package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import models.ChessGameRegistry;
import view.RegistrationApp;
import view.Window;

public class NewGameButtonListener implements ActionListener{

	
	private Window window;
	
	public NewGameButtonListener(Window window)
	{
		this.window = window;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		//MAKES NEW GAME
		window.dispose();
		
		final ChessGameRegistry chessGameRegistry = new ChessGameRegistry();
		SwingUtilities.invokeLater(() -> new RegistrationApp(chessGameRegistry));
		
	}

}
