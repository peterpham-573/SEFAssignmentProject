package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JLabel turn;
	private JButton startGame, splitPiece;
	
	public ControlPanel() {
		
		setLayout(new GridLayout(1,6));
		
		create();
	}
	
	public void create(){
		
		Font myFont = new Font("Arial", Font.PLAIN , 15);
		
		splitPiece = new JButton("Split Piece");
		splitPiece.setFont(myFont);
		splitPiece.setBackground(Color.WHITE);
		splitPiece.setEnabled(false);
		
		
		startGame = new JButton("Start Game");
		startGame.setFont(myFont);
		startGame.setBackground(Color.WHITE);

		add(new JPanel());
		add(splitPiece);
		add(new JPanel());
		add(startGame);	
		add(new JPanel());
		
	}
	public void setEnabled(boolean set) {
		splitPiece.setEnabled(set);;
	}
	
}
