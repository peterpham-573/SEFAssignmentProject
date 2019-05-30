package view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ExitButtonListener;
import controller.NewGameButtonListener;

public class TopMenuBar extends JMenuBar
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu file;
	private JMenuItem newGame, exit;

	public TopMenuBar(Window window) 
	{	
		setJMenuBarComponents(window);
	}
	

	//Creating the menu components for the GUI
public void setJMenuBarComponents(Window window)
{
	file = new JMenu("File");
	file.setMnemonic(KeyEvent.VK_F);
	add(file);
	
	newGame = new JMenuItem("New Game");
	newGame.setMnemonic(KeyEvent.VK_N);
	newGame.addActionListener(new NewGameButtonListener(window));
	file.add(newGame);
			
	exit = new JMenuItem("Exit");
	exit.setMnemonic(KeyEvent.VK_X);
	exit.addActionListener(new ExitButtonListener());
	file.add(exit);
	
	setVisible(true);
}
	
	
	
}
