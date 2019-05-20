package view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel turn, turnsRemaining;
	
	
	public StatusPanel(){
		
		setLayout(new GridLayout(1,2));
		create();
		
	}

	private void create() {

		
		Font myFont = new Font("Arial", Font.PLAIN, 20);

		turn = new JLabel("Current player's turn: ", JLabel.CENTER);
		turn.setFont(myFont);
		
		turnsRemaining = new JLabel("Turns remaining: ", JLabel.CENTER);
		turnsRemaining.setFont(myFont);
		
		add(turn);
		add(turnsRemaining);
	}

	
	public void updateTurnsRemaining(String a)
	{
		turnsRemaining.setText("Turns remaining: " + a);
	}
	
	public void updateCurrentPlayer(String a)
	{
		turn.setText("Current player's turn: " + a);
	}
	
	
}
