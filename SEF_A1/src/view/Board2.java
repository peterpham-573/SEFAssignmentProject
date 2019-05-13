package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board2 extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton[][] squares = new JButton[6][6];

	private Color blackSquare = Color.GRAY;
	private Color whiteSquare = Color.WHITE;
	
	private ImageIcon blackKnight = new ImageIcon("images/black_knight.png");
	private ImageIcon blackBishop = new ImageIcon("images/black_bishop.png");
	private ImageIcon blackRook = new ImageIcon("images/black_rook.png");
	
	private ImageIcon whiteKnight = new ImageIcon("images/white_knight.png");
	private ImageIcon whiteBishop = new ImageIcon("images/white_bishop.png");
	private ImageIcon whiteRook = new ImageIcon("images/white_rook.png");
	
	
	public Board2()
	{

		setLayout(new GridLayout(6,6));		

		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				squares[i][j] = new JButton();
				squares[i][j].setBorderPainted(false);

				if( (i + j)% 2 != 0)
				{
					squares[i][j].setBackground(blackSquare);
				}
				else
				{
					squares[i][j].setBackground(whiteSquare);
				}
				add(squares[i][j]);
			}
		}
		
		//testing
		
		paintPieces();
		
		setVisible(true);

	}


	public void paintPieces()
	{
		squares[0][0].setIcon(blackRook);
		squares[0][1].setIcon(blackBishop);
		squares[0][2].setIcon(blackKnight);
		squares[0][3].setIcon(blackKnight);
		squares[0][4].setIcon(blackBishop);
		squares[0][5].setIcon(blackRook);
		
		
		squares[5][0].setIcon(whiteRook);
		squares[5][1].setIcon(whiteBishop);
		squares[5][2].setIcon(whiteKnight);
		squares[5][3].setIcon(whiteKnight);
		squares[5][4].setIcon(whiteBishop);
		squares[5][5].setIcon(whiteRook);
		
		
	}	
}
