package view;


//hi peter testing

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Board board;
	private PlayerStatus playerPanel;
	
	public Window()
	{
		super("Chess");
		
		
		setBounds(100, 100, 1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		board = new Board();
		board.setBackground(Color.BLUE);
		add(board, BorderLayout.CENTER);
		
		playerPanel = new PlayerStatus();
		add(playerPanel, BorderLayout.EAST);
		
		
		setVisible(true);
	}

}
