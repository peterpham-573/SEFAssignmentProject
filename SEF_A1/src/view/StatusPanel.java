package view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
	
	private JLabel turn;
	
	
	public StatusPanel(){
		
		setLayout(new GridLayout(1,1));
		create();
		
	}

	private void create() {

		
		Font myFont = new Font("Arial", Font.PLAIN, 20);

		turn = new JLabel("Current player's turn: ", JLabel.CENTER);
		turn.setFont(myFont);
		
		add(turn);
	}

	
	
	
}
