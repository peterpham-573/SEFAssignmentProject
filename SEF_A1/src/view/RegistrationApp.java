package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AddPlayerButtonActionListener;
import controller.LoginPlayerButtonActionListener;
import models.ChessGameRegistry;
import models.ChessPlayer;

public class RegistrationApp extends JFrame{
	private JLabel registrationLabel, usernameLabel, passwordLabel;
	private JTextField usernameTextField;
	private JButton registerButton, loginButton;
	private JPasswordField passwordField;
	private ChessGameRegistry chessGameRegistry;
	public RegistrationApp(ChessGameRegistry chessGameRegistry) {
	super("Regisation App");
	this.chessGameRegistry = chessGameRegistry;
	  registrationLabel = new JLabel("Chess Game Registration Form");
	  registrationLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
	  usernameLabel = new JLabel("Username:");
	  passwordLabel = new JLabel("Password:");
	  usernameTextField = new JTextField();
	  passwordField = new JPasswordField();
	  registerButton = new JButton("Register Here");
	  loginButton = new JButton("Login");

	  registrationLabel.setBounds(140, 50, 400, 30);
	  usernameLabel.setBounds(90, 120, 200, 30);
	  passwordLabel.setBounds(90, 170, 200, 30);
	  usernameTextField.setBounds(320, 120, 200, 30);
	  passwordField.setBounds(320, 170, 200, 30);
	  registerButton.setBounds(90, 220, 200, 30);
	  registerButton.addActionListener(new AddPlayerButtonActionListener(this));
	  loginButton.setBounds(320, 220, 200, 30);
	  loginButton.addActionListener(new LoginPlayerButtonActionListener(this));
	  
	  add(registrationLabel);
	  add(usernameLabel);
	  add(usernameTextField);
	  add(passwordLabel);
	  add(passwordField);
	  add(registerButton);
	  add(loginButton);

	  setSize(650, 350);
	  setLayout(null);
	  setVisible(true);
	 }
	
	public void CreatePlayer(){
		//Creates a new player to add to the registry
		String playerName;
		playerName = JOptionPane.showInputDialog("Player name");
		String username;
		username = JOptionPane.showInputDialog("Player Username");
		String password;
		password = JOptionPane.showInputDialog("Player Password");
		
		if (!(!(username != null) || !(password != null) || !(playerName != null))) {
			if(!(username.indexOf(' ') >= 0 || password.indexOf(' ') >= 0  || playerName.indexOf(' ') >= 0)) {
				if(!(username.trim().equals("") || password.trim().equals("")) || playerName.trim().equals("")) {
					ChessPlayer newPlayer = new ChessPlayer(playerName, username, password);
					if(!chessGameRegistry.userNameCheck(newPlayer)) {
						chessGameRegistry.addPlayerToRegistration(newPlayer);
					}
					else {
						JOptionPane.showMessageDialog(null,"Username has been taken");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid Name, Username or Password");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null,"None of the fields is permitted to have a space");
			}
				
		}
		else {
			JOptionPane.showMessageDialog(null,"Please Enter Your Name, Username and Password");
		}
	}
	
	public void addPlayer() {
		//Logins a player to the game
		String username = usernameTextField.getText();
		char[] password = passwordField.getPassword();
		String passwordString = new String(password);
		String[] playerDetails = {username, passwordString};
		ChessPlayer player = chessGameRegistry.getPlayer(playerDetails);
	
		switch(chessGameRegistry.playerLogin(player)){
		case 0:
			JOptionPane.showMessageDialog(null,"Player 1 added");
			addNumberOfMoves(player);
			usernameTextField.setText("");
			passwordField.setText("");
			break;
		case 1:
			JOptionPane.showMessageDialog(null,"Invalid: Two of the same players cannot be added");
			usernameTextField.setText("");
			passwordField.setText("");
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Player 2 added");
			addNumberOfMoves(player);
			
			//MAKE NEW FRAME HERE
			//THIS IS WHERE THE REGISTRATION ENDS
			//THE TWO PLAYERS CAN BE RETRIVED VIA
			//chessGameRegistry.getplayers() WHICH IS A ARRAY OF TWO PLAYERS

			dispose();
			break;
			
		case 3:
			JOptionPane.showMessageDialog(null,"Player not in the system");
			passwordField.setText("");
			break;
		}
	}
	
	public void addNumberOfMoves(ChessPlayer player) {
		//Gets input from the player for the number of turns they want
		String stringNoOfTurns;
		int noOfTurns;
		stringNoOfTurns =  JOptionPane.showInputDialog("Please enter No of turns");
		if(stringNoOfTurns != null) {
			while(!stringNoOfTurns.matches("[0-9]+")) {
				stringNoOfTurns = JOptionPane.showInputDialog("Please enter VALID no of turns");
			}
		}
		noOfTurns = Integer.parseInt(stringNoOfTurns);
		player.setNoOfTurns(noOfTurns);
	}
	
}
