package view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AddPlayerButtonActionListener;
import controller.ExitButtonListener;
import controller.NewGameButtonListener;

public class TopMenuBar extends JMenuBar
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu file, player;
	private JMenuItem newGame, exit, login, signup;

	public TopMenuBar(Window window) {
		
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
		
		player = new JMenu("Player");
		player.setMnemonic(KeyEvent.VK_P);
		add(player);
		
		signup = new JMenuItem("Sign Up");
		signup.setMnemonic(KeyEvent.VK_U);
		//add listener for signing up
		player.add(signup);
		
		login = new JMenuItem("Login");
		login.setMnemonic(KeyEvent.VK_L);
		//add listener for signing up
		player.add(login);
		
		
		
		setVisible(true);
	}
	

	
	
}
