package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		new Window();
		window.repaint();
		
	}

}
