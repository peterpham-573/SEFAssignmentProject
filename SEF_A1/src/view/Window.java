package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Board board;
	
	public Window()
	{
		super("Chess");
		
		
		setBounds(100, 100, 1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		board = new Board();
		
		
		setVisible(true);
	}

}
