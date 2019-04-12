package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MovePanel extends JPanel {

	private JTextArea moves;
	private JButton signup, login;
	
	public MovePanel() {
		
		setPreferredSize(new Dimension(200, 150));
		setBorder(BorderFactory.createBevelBorder(1));
		
		createPanel();
	}
	
	public void createPanel() {
		
		Font myFont = new Font("Sans Serif", Font.BOLD, 20);
		
		moves = new JTextArea(30,10);
		moves.setFont(myFont);
		moves.setBorder(BorderFactory.createTitledBorder("Moves"));
		moves.setEditable(false);
		add(moves);
		
		add(new JPanel());
	
		
		
		
		
		
		
	}
	
}
