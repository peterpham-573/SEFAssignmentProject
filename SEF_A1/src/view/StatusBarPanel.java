package view;


import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBarPanel extends JPanel{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel turn;
	
	public StatusBarPanel() {
		
		setLayout(new GridLayout(1,1));
		
		create();
	}
	
	public void create(){
		
		Font myFont = new Font("Sans Serif", Font.PLAIN , 25);
		
		turn = new JLabel("Current Player's Turn:", JLabel.LEFT);
		turn.setFont(myFont);
		
		
		add(turn);
		
	}
	
}
