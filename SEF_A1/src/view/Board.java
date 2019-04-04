package view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
		
		g.fillRect(100, 100, 600, 600);
		
		for(int i = 200; i <= 600; i += 200)
		{
			for(int j = 100; j <= 650; j += 200)
			{
				g.clearRect(i, j, 100, 100);
			}
		}
		for(int i = 100; i <= 650; i += 200)
		{
			for(int j = 200; j <= 600; j += 200)
			{
				g.clearRect(i, j, 100, 100);
			}
		}
	}
}
