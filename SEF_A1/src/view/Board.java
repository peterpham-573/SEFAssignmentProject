package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {

	
	public void paint(Graphics g) {
		
		g.fillRect(100, 100, 400, 400);
		
		for(int i = 100; i <= 400; i += 100)
		{
			for(int j = 100; j <= 400; j += 100)
			{
				g.clearRect(i, j, 50, 50);
			}
		}
	}
}
