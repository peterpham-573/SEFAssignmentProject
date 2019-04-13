package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridLayout;



import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlayerPanel extends JPanel {



	private JTextArea playerOneUsername, playerOneScore, playerTwoUsername, playerTwoScore, playerOneColor, playerTwoColor;
	private JPanel playerOne, playerTwo;
	private JButton signup1, login1, signup2, login2;


	public PlayerPanel()
	{
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(200, 150));
		setBorder(BorderFactory.createBevelBorder(1));

		setUp();
	}

	public void setUp()
	{

		Font myFont = new Font("Arial", Font.BOLD, 20);
		Font myFont2 = new Font("Arial", Font.PLAIN , 15);
		
		playerOne = new JPanel();
		playerOne.setFont(myFont);
		playerOne.setBorder(BorderFactory.createTitledBorder("Player One"));
		playerOne.setLayout(new GridLayout(8,1));
		add(playerOne);
		
		playerOneUsername = new JTextArea();
		playerOneUsername.setFont(myFont);
		playerOneUsername.setEditable(false);
		playerOneUsername.setBorder(BorderFactory.createTitledBorder("Username"));
		
		playerOneScore = new JTextArea();
		playerOneScore.setFont(myFont);
		playerOneScore.setEditable(false);
		playerOneScore.setBorder(BorderFactory.createTitledBorder("Score"));
		
		playerOneColor = new JTextArea();
		playerOneColor.setBorder(BorderFactory.createTitledBorder("Color"));
		playerOneColor.setEditable(false);
		
//		signup1 = new JButton("Sign Up");
//		signup1.setFont(myFont2);
//		signup1.setBackground(Color.WHITE);
//		
//		login1 = new JButton("Login");
//		login1.setFont(myFont2);
//		login1.setBackground(Color.WHITE);
//		
		playerOne.add(new JPanel());
		playerOne.add(new JPanel());		
		playerOne.add(playerOneUsername);
		playerOne.add(playerOneColor);
		playerOne.add(playerOneScore);
		playerOne.add(new JPanel());
		
		
		
		playerTwo = new JPanel();
		playerTwo.setFont(myFont);
		playerTwo.setBorder(BorderFactory.createTitledBorder("Player Two"));
		playerTwo.setLayout(new GridLayout(8,1));
		add(playerTwo);
		
		playerTwoUsername = new JTextArea();
		playerTwoUsername.setFont(myFont);
		playerTwoUsername.setEditable(false);
		playerTwoUsername.setBorder(BorderFactory.createTitledBorder("Username"));
		
		playerTwoScore = new JTextArea();
		playerTwoScore.setFont(myFont);
		playerTwoScore.setEditable(false);
		playerTwoScore.setBorder(BorderFactory.createTitledBorder("Score"));
		
		playerTwoColor = new JTextArea();
		playerTwoColor.setBorder(BorderFactory.createTitledBorder("Color"));
		playerTwoColor.setEditable(false);
		
//
//		signup2 = new JButton("Sign Up");
//		signup2.setFont(myFont2);
//		signup2.setBackground(Color.WHITE);
//
//		
//		login2 = new JButton("Login");
//		login2.setFont(myFont2);
//		login2.setBackground(Color.WHITE);
		
		
		playerTwo.add(new JPanel());
		playerTwo.add(new JPanel());	
		playerTwo.add(playerTwoUsername);
		playerTwo.add(playerTwoColor);
		playerTwo.add(playerTwoScore);
		playerTwo.add(new JPanel());
			}
	

}

