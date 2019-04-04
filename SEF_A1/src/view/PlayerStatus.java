package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayerStatus extends JPanel {
	
	private JPanel p1, p2;
	
	public PlayerStatus()
	{
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(750, 150));
		setBorder(BorderFactory.createBevelBorder(1));
		
		setUp();
	}
	
	public void setUp()
	{
		p1 = new JPanel();
		add(p1);
		p2 = new JPanel();
		add(p2);
	}
}
