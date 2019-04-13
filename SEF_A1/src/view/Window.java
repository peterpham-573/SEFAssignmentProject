package view;


//hi peter testing

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Window extends JFrame {


	
	private Board board;
	private PlayerPanel playerPanel;
	private ControlPanel statusBarPanel;
	private TopMenuBar menuBar;
	private MovePanel moves;
	private StatusPanel status;

	
	public Window()
	{
		super("Chess");
		
		
		setBounds(100, 100, 1250, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1250, 900));
		
		menuBar = new TopMenuBar(this);
		setJMenuBar(menuBar);
		
		moves = new MovePanel();
		add(moves, BorderLayout.EAST);
		
		board = new Board();
		board.setBackground(Color.BLUE);
		add(board, BorderLayout.CENTER);
		
		statusBarPanel = new ControlPanel();
		add(statusBarPanel, BorderLayout.NORTH);
		
		playerPanel = new PlayerPanel();
		add(playerPanel, BorderLayout.WEST);
		
		status = new StatusPanel();
		add(status, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

}
