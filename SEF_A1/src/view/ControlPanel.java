package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel turn;
	private JButton startGame;
	
	public ControlPanel() {
		
		setLayout(new GridLayout(1,6));
		
		create();
	}
	
	public void create(){
		
		Font myFont = new Font("Arial", Font.PLAIN , 15);
		
		turn = new JLabel("Current Player's Turn:", JLabel.LEFT);
		turn.setFont(myFont);

		
		startGame = new JButton("Start Game");
		startGame.setFont(myFont);
		startGame.setBackground(Color.WHITE);

		add(new JPanel());
		add(startGame);	
		add(new JPanel());
		
		
	}
	
}
