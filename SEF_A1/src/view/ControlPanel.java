package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.SplitActionListener;
import models.interfaces.ChessGameEngine;

public class ControlPanel extends JPanel{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton splitPiece;
	
	public ControlPanel(ChessGameEngine ge, Window b) {
		
		createButtons(ge, b);
	}
	
	
	//This create method only creates a button - a split piece button which has an action listener
	public void createButtons(ChessGameEngine ge, Window b){
		
		setLayout(new GridLayout(1,6));
		
		Font myFont = new Font("Arial", Font.PLAIN , 15);
		
		splitPiece = new JButton("Split Piece");
		splitPiece.setFont(myFont);
		splitPiece.setBackground(Color.WHITE);
		splitPiece.setEnabled(false);
		splitPiece.addActionListener(new SplitActionListener(ge, b));
		
		add(new JPanel());
		add(splitPiece);
		add(new JPanel());
		
	}
	
	//This method is only called when a merge piece is selected, to enable the split piece option
	public void setEnabled(boolean set) {
		splitPiece.setEnabled(set);;
	}
	
}
