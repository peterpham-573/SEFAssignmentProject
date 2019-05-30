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
	
	//The bottom panel on the appframe, 
	public StatusPanel(ChessGameEngine ge){
		
		this.ge = ge;
		
		setLayout(new GridLayout(1,2));
		create();
		
		updateTurnsRemaining(ge);
		updateCurrentPlayer(ge);
		
	}

	//Creates the view for the GUI
	private void create() 
	{	
		Font myFont = new Font("Arial", Font.PLAIN, 20);

		createCurrentPlayerTurnPanel(myFont);
		createTurnsRemainingPanel(myFont);
	}

	//Creates the view for the current players turn
	private void createCurrentPlayerTurnPanel(Font myFont)
	{
		turn = new JLabel("Current player's turn: ", JLabel.CENTER);
		turn.setFont(myFont);
		add(turn);
	}
	
	//Creates the view for the remaining number of turns
	private void createTurnsRemainingPanel(Font myFont)
	{
		turnsRemaining = new JLabel("Turns remaining: ", JLabel.CENTER);
		turnsRemaining.setFont(myFont);
		add(turnsRemaining);
	}
	
	//Method is called after each player makes a turn
	public void updateTurnsRemaining(ChessGameEngine ge)
	{
		turnsRemaining.setText("Turns remaining: " + ge.remainingTurns());
	}
	
	//Called after each valid player move
	public void updateCurrentPlayer(ChessGameEngine ge)
	{
		turn.setText("Current player's turn: " + ge.getCurrentPlayerTurn());
	}
	
	
}
