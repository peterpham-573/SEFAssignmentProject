package view;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridLayout;



import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlayerPanel extends JPanel {



	private JTextArea playerOneUsername, playerOneScore, playerTwoUsername, playerTwoScore;
	private JPanel playerOne, playerTwo;


	public PlayerPanel()
	{
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(200, 150));
		setBorder(BorderFactory.createBevelBorder(1));

		setUp();
	}

	public void setUp()
	{

		Font myFont = new Font("Sans Serif", Font.BOLD, 20);
		
		playerOne = new JPanel();
		playerOne.setFont(myFont);
		playerOne.setBorder(BorderFactory.createTitledBorder("Player One"));
		playerOne.setLayout(new GridLayout(4,1));
		add(playerOne);
		
		playerOneUsername = new JTextArea();
		playerOneUsername.setFont(myFont);
		playerOneUsername.setEditable(false);
		playerOneUsername.setBorder(BorderFactory.createTitledBorder("Username"));
		
		playerOneScore = new JTextArea();
		playerOneScore.setFont(myFont);
		playerOneScore.setEditable(false);
		playerOneScore.setBorder(BorderFactory.createTitledBorder("Score"));
		
		playerOne.add(new JPanel());		
		playerOne.add(playerOneUsername);
		playerOne.add(playerOneScore);
		
		
		playerTwo = new JPanel();
		playerTwo.setFont(myFont);
		playerTwo.setBorder(BorderFactory.createTitledBorder("Player Two"));
		playerTwo.setLayout(new GridLayout(4,1));
		add(playerTwo);
		
		playerTwoUsername = new JTextArea();
		playerTwoUsername.setFont(myFont);
		playerTwoUsername.setEditable(false);
		playerTwoUsername.setBorder(BorderFactory.createTitledBorder("Username"));
		
		playerTwoScore = new JTextArea();
		playerTwoScore.setFont(myFont);
		playerTwoScore.setEditable(false);
		playerTwoScore.setBorder(BorderFactory.createTitledBorder("Score"));
		
		playerTwo.add(new JPanel());	
		playerTwo.add(playerTwoUsername);
		playerTwo.add(playerTwoScore);
				
	}
	

}

