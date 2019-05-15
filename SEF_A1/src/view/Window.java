package view;


//hi peter testing

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import models.interfaces.ChessGameEngine;


public class Window extends JFrame {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Board board;
	private PlayerPanel playerPanel;
	private ControlPanel statusBarPanel;
	private TopMenuBar menuBar;
	private MovePanel moves;
	private StatusPanel status;
	private Board2 board2;

	private ChessGameEngine gameEngine;
	
	public Window(ChessGameEngine gameEngine)
	{
		super("Chess");
		
		this.gameEngine = gameEngine;
		
		setBounds(100, 100, 1250, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(1250, 900));
		
		menuBar = new TopMenuBar(this);
		setJMenuBar(menuBar);
		
		moves = new MovePanel();
		add(moves, BorderLayout.EAST);
		
//		board = new Board();
//		add(board, BorderLayout.CENTER);
		
		board2 = new Board2(gameEngine, this);
		add(board2, BorderLayout.CENTER);
		
		
		statusBarPanel = new ControlPanel();
		add(statusBarPanel, BorderLayout.NORTH);
		
		playerPanel = new PlayerPanel(gameEngine);
		add(playerPanel, BorderLayout.WEST);
		
		status = new StatusPanel();
		add(status, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

	public PlayerPanel getPlayerPanel()
	{
		return playerPanel;
	}
	
	public MovePanel getMovePanel()
	{
		return moves;
	}
	
	public StatusPanel getStatusPanel()
	{
		return status;
	}
	
	public Board2 getBoard()
	{
		return board2;
	}
	
	
}


