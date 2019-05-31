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
import models.ChessGameEngineImpl;
import models.ChessGameRegistry;
import models.ChessPlayer;
import models.interfaces.ChessGameEngine;

public class RegistrationApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	// Creates a new player to add to the registry
	public void CreatePlayer() {
		String playerName = JOptionPane.showInputDialog("Player name");
		String username = JOptionPane.showInputDialog("Player Username");
		String password = JOptionPane.showInputDialog("Player Password");

		if ((username != null) && (password != null) && (playerName != null) && username.length() != 0
				&& password.length() != 0 && playerName.length() != 0) {
			if (!(username.indexOf(' ') >= 0 || password.indexOf(' ') >= 0 || playerName.indexOf(' ') >= 0)) {
				ChessPlayer newPlayer = new ChessPlayer(playerName, username, password);
				if (chessGameRegistry.userNameCheckAndAdd(newPlayer)) {
					JOptionPane.showMessageDialog(null, "Username has been taken");
				}

			} else {
				JOptionPane.showMessageDialog(null, "None of the fields is permitted to have a space");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Please Enter Your Name, Username and Password");
		}

	}

	// Attempts to login a player to the game
	public void loginPlayer() {
		String username = usernameTextField.getText();
		char[] password = passwordField.getPassword();
		String passwordString = new String(password);
		String[] playerDetails = { username, passwordString };
		ChessPlayer player = chessGameRegistry.getPlayer(playerDetails);

		switch (chessGameRegistry.playerLogin(player)) {
		case 0:
			JOptionPane.showMessageDialog(null, "Player 1 added");
			addNumberOfMoves(player);
			usernameTextField.setText("");
			passwordField.setText("");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Invalid: Two of the same players cannot be added");
			usernameTextField.setText("");
			passwordField.setText("");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Player 2 added");
			addNumberOfMoves(player);
			createBoard();
			this.dispose();
			break;

		case 3:
			JOptionPane.showMessageDialog(null, "Player not in the system");
			passwordField.setText("");
			break;
		}
	}

	// Prompts the player to enter the number of moves they want to play
	public void addNumberOfMoves(ChessPlayer player) {
		// Gets input from the player for the number of turns they want
		String stringNoOfTurns;
		int noOfTurns;
		stringNoOfTurns = JOptionPane.showInputDialog("Please enter No of turns");
		if (stringNoOfTurns != null) {
			while (!stringNoOfTurns.matches("[0-9]+")) {
				stringNoOfTurns = JOptionPane.showInputDialog("Please enter VALID no of turns");
			}
		}
		noOfTurns = Integer.parseInt(stringNoOfTurns);
		player.setNoOfTurns(noOfTurns);
	}

	// Add players into the game engine from the Chess Game Registry, Calculates the
	// max turn and makes a
	// new window
	public void createBoard() {
		ChessGameEngine ge = new ChessGameEngineImpl();
		ge.setPlayerOne(chessGameRegistry.getplayers()[0]);
		ge.setPlayerTwo(chessGameRegistry.getplayers()[1]);
		ge.calculateMaxTurns();
		new Window(ge);

	}

}
