package view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.interfaces.ChessGameEngine;

public class StatusPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel turn, turnsRemaining;
	private ChessGameEngine ge;
	
	
	public StatusPanel(ChessGameEngine ge){
		
		this.ge = ge;
		
		setLayout(new GridLayout(1,2));
		create();
		
		updateTurnsRemaining(ge);
		updateCurrentPlayer(ge);
		
	}

	private void create() {

		
		Font myFont = new Font("Arial", Font.PLAIN, 20);

		createCurrentPlayerTurnPanel(myFont);
		createTurnsRemainingPanel(myFont);
		
		
		
	}

	private void createCurrentPlayerTurnPanel(Font myFont)
	{
		turn = new JLabel("Current player's turn: ", JLabel.CENTER);
		turn.setFont(myFont);
		add(turn);
	}
	
	private void createTurnsRemainingPanel(Font myFont)
	{
		turnsRemaining = new JLabel("Turns remaining: ", JLabel.CENTER);
		turnsRemaining.setFont(myFont);
		add(turnsRemaining);
	}
	
	public void updateTurnsRemaining(ChessGameEngine ge)
	{
		turnsRemaining.setText("Turns remaining: " + ge.remainingTurns());
	}
	
	public void updateCurrentPlayer(ChessGameEngine ge)
	{
		turn.setText("Current player's turn: " + ge.getCurrentPlayerTurn());
	}
	
	
}
