package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PieceClickedButtonListener;
import models.PiecePosition;
import models.interfaces.ChessGameEngine;

public class Board2 extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton[][] squares = new JButton[6][6];

	private Color blackSquare = Color.GRAY;
	private Color whiteSquare = Color.WHITE;
	private Color selectSquare = Color.CYAN;
	
	private ImageIcon blackKnight = new ImageIcon("images/black_knight.png");
	private ImageIcon blackBishop = new ImageIcon("images/black_bishop.png");
	private ImageIcon blackRook = new ImageIcon("images/black_rook.png");
	
	private ImageIcon whiteKnight = new ImageIcon("images/white_knight.png");
	private ImageIcon whiteBishop = new ImageIcon("images/white_bishop.png");
	private ImageIcon whiteRook = new ImageIcon("images/white_rook.png");
	

	
	
	public Board2(ChessGameEngine ge, Window window)
	{

		createBoard(ge, window);
		
		paintPieces();
		
		setVisible(true);

	}

	
	
	public void paintSelected(LinkedList<PiecePosition> pieces)
	{
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				for (PiecePosition r : pieces)
				{
					if (i == r.getRow() && j == r.getCol())
					{
						squares[i][j].setBackground(selectSquare);
					}
				}
			}
		}
	}
	
	
	public void createBoard(ChessGameEngine ge, Window window)
	{
		
		setLayout(new GridLayout(6,6));		
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				squares[i][j] = new JButton();

				if( (i + j)% 2 != 0)
				{
					squares[i][j].setBackground(blackSquare);
				}
				else
				{
					squares[i][j].setBackground(whiteSquare);
				}
				add(squares[i][j]);
				
				squares[i][j].addActionListener(new PieceClickedButtonListener(i,j,ge,this, window));

			}	
		}
	}
	
	
	public void repaintBackground()
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				if( (i + j)% 2 != 0)
				{
					squares[i][j].setBackground(blackSquare);
				}
				else
				{
					squares[i][j].setBackground(whiteSquare);
				}
			}	
		}
	}
	
	public JButton getTile(int i, int j)
	{
		return squares[i][j];
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
