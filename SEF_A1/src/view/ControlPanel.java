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
//	private JLabel turn;
	private JButton splitPiece;
	
	public ControlPanel(ChessGameEngine ge, Window b) {
		
		setLayout(new GridLayout(1,6));
		
		create(ge, b);
	}
	
	public void create(ChessGameEngine ge, Window b){
		
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
	public void setEnabled(boolean set) {
		splitPiece.setEnabled(set);;
	}
	
}
