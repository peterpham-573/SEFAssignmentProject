package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import models.interfaces.ChessGameEngine;


public class Window extends JFrame {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PlayerPanel playerPanel;
	private ControlPanel controlPanel;
	private TopMenuBar menuBar;
	private StatusPanel status;
	private Board board2;

	private ChessGameEngine gameEngine;
	
	
	//The container that contains all components
	public Window(ChessGameEngine gameEngine)
	{
		super("Chess");
		
		this.gameEngine = gameEngine;
		
		setView();
		
		menuBar = new TopMenuBar(this);
		setJMenuBar(menuBar);
		
		board2 = new Board(this.gameEngine, this);
		add(board2, BorderLayout.CENTER);
		
		controlPanel = new ControlPanel(this.gameEngine, this);
		add(controlPanel, BorderLayout.NORTH);
		
		playerPanel = new PlayerPanel(this.gameEngine);
		add(playerPanel, BorderLayout.WEST);
		
		status = new StatusPanel(this.gameEngine);
		add(status, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	
	//AppFrame methods which sets the views options
	private void setView()
	{
		setBounds(100, 100, 1250, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1250, 900));	
	}
	

	//Getters and setters
	public PlayerPanel getPlayerPanel()
	{
		return playerPanel;
	}
	
	public StatusPanel getStatusPanel()
	{
		return status;
	}
	
	public Board getBoard()
	{
		return board2;
	}
	
	public ControlPanel getControl()
	{
		return controlPanel;
	}
	
}


