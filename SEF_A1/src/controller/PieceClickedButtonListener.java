package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import models.interfaces.ChessGameEngine;
import models.pieces.Bishook;
import models.pieces.Bishop;
import models.pieces.Knight;
import models.pieces.Knightshop;
import models.pieces.Knook;
import models.pieces.Rook;
import view.Board2;

public class PieceClickedButtonListener implements ActionListener {


	private ImageIcon blackKnight = new ImageIcon("images/black_knight.png");
	private ImageIcon blackBishop = new ImageIcon("images/black_bishop.png");
	private ImageIcon blackRook = new ImageIcon("images/black_rook.png");
	private ImageIcon blackKnook = new ImageIcon("images/black_knook.png");
	private ImageIcon blackKnightshop = new ImageIcon("images/black_knightshop.png");
	private ImageIcon blackBishook = new ImageIcon("images/black_bishook.png");

	private ImageIcon whiteKnight = new ImageIcon("images/white_knight.png");
	private ImageIcon whiteBishop = new ImageIcon("images/white_bishop.png");
	private ImageIcon whiteRook = new ImageIcon("images/white_rook.png");
	private ImageIcon whiteKnook = new ImageIcon("images/white_knook.png");
	private ImageIcon whiteKnightshop = new ImageIcon("images/white_knightshop.png");
	private ImageIcon whiteBishook = new ImageIcon("images/white_bishook.png");

	private int i;
	private int j;
	private ChessGameEngine ge;
	private Board2 b;

	public PieceClickedButtonListener(int i, int j, ChessGameEngine ge, Board2 b)
	{
		this.b = b;
		this.ge = ge;
		this.i = i;
		this.j = j;		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{

		if (ge.checkStart() == false)
		{
			ge.setStart(i, j);
		}
		else
		{
			ge.setEnd(i, j);

			if (ge.getStart() == ge.getEnd())
			{
				//if player selects same place; deselect
				ge.resetChecks();
			}
			else
			{
				boolean mergeCheck = ge.movePiece(ge.getStart(), ge.getEnd());
				
				boolean check = ge.getValidCheck();
				
				//if the merge is true
				if (mergeCheck == true)
				{
					b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
					
					if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knook && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
					{
						b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnook);
					}
					else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knightshop && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
					{
						b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnightshop);
					}
					else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishook && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
					{
						b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishook);
					}
					else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knook && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
					{
						b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnook);
					}
					else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knightshop && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
					{
						b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnightshop);
					}
					else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishook && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
					{
						b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishook);
					}
				}
				else
				{
						if(check == true)
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
		
							if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackRook);
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnight);
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishop);
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteRook);
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnight);
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishop);
							}
						} 
				}
				
					
				ge.resetChecks();
				b.repaint();
				b.revalidate();
			}


		}





	}

	/*
	 * 
	 * All three cases require movement validation
	 * 

	 * Case 1: Move into empty spot
	 * Case 2: Capture an enemy piece
	 * Case 3: Capture own piece (merge)
	 * 
	 * Case 4: Split
	 * 
	 * Case 5: Deselecting a piece 
	 * 
	 * */


}
