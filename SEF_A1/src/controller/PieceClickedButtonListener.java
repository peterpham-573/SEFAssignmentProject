package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import models.interfaces.ChessGameEngine;
import models.pieces.Bishook;
import models.pieces.Bishop;
import models.pieces.Knight;
import models.pieces.Knightshop;
import models.pieces.Knook;
import models.pieces.Piece;
import models.pieces.Rook;
import view.Board2;
import view.Window;

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
	private Window window;
	private Board2 b;

	public PieceClickedButtonListener(int i, int j, ChessGameEngine ge, Board2 b, Window window)
	{
		this.b = b;
		this.ge = ge;
		this.i = i;
		this.j = j;		
		this.window = window;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{

		if (ge.checkStart() == false)
		{
			ge.setStart(i, j);

			if (
					ge.getChessBoard().getPieceOnBoard(i, j) instanceof Knook || 
					ge.getChessBoard().getPieceOnBoard(i, j) instanceof Knightshop || 
					ge.getChessBoard().getPieceOnBoard(i, j) instanceof Bishook
					)
			{
				window.getControl().setEnabled(true);
				window.repaint();
				window.revalidate();
			}
		}
		else
		{
			ge.setEnd(i, j);

			if (ge.getStart().isEqual(ge.getEnd()))
			{
				//if player selects same place; deselect
				window.getControl().setEnabled(false);
				ge.resetChecks();
			}
			else
			{
				Piece tempPiece = ge.getChessBoard().getPiece(ge.getStart());
				boolean mergeCheck = ge.movePiece(ge.getStart(), ge.getEnd());
				window.getPlayerPanel().updateScore();
				boolean check = ge.getValidCheck();

				if (tempPiece.isWhite() != ge.isWhitePlayerTurn())
				{
					ge.resetChecks();
				}
				else if (tempPiece.isWhite() == ge.isWhitePlayerTurn())
				{
					if (ge.getSplitCheck())
					{
						splitMove();
					}
					else if (!ge.getSplitCheck())
					{
						if (mergeCheck == true && check == true)
						{
							mergeMove();
						}
						else if (check == false)
						{
							ge.resetChecks();
						}
						else if (mergeCheck == false)
						{
							if(check == true)
							{
								//MERGED PIECES
								mergeMove();
								//NORMAL PIECES
								normalMove();
							} 
						}

						b.repaint();
						b.revalidate();
					}

					if(ge.checkGameEnd()) 
					{
						JOptionPane.showMessageDialog(window, "Game has ended \n" + ge.getWinningMessage());
					}


					String turns = String.valueOf(ge.remainingTurns());

					//Updating of the player turn and the remaining turns -> White turn + Black turn = 1 Full Turn
					window.getStatusPanel().updateTurnsRemaining(turns);
					window.getStatusPanel().updateCurrentPlayer(ge.getCurrentPlayerTurn());


					ge.resetChecks();
				}
			}
		}
	}

	public void normalMove()
	{
		if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
			
			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackRook);
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteRook);
			}
			
			
			ge.changePlayerTurn();
		}
		else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
			
			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnight);
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnight);
			}
			ge.changePlayerTurn();
		}
		else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop)
		{

			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
			
			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishop);
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishop);
			}
			ge.changePlayerTurn();
		}
	}

	public void mergeMove()
	{
		if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knook)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
			
			if (!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnook);
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnook);
			}
			
			
			window.getControl().setEnabled(false);
			ge.changePlayerTurn();
		}
		else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knightshop)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
			
			if (!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnightshop);
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnightshop);
			}
			
			
			window.getControl().setEnabled(false);
			ge.changePlayerTurn();
		}
		else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishook)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
			
			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishook);
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishook);
			}
			
			
			window.getControl().setEnabled(false);
			ge.changePlayerTurn();
		}
	}
	
	public void splitMove()
	{
		//paint the start
		if(ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()) instanceof Bishop)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()).isWhite())
			{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(whiteBishop);
			}
			else
			{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(blackBishop);
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()) instanceof Rook)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()).isWhite())
			{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(whiteRook);
			}
			else
			{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(blackRook);
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()) instanceof Knight)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()).isWhite())
			{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(whiteKnight);
			}
			else
			{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(blackKnight);
			}
		}
		//paint the end
		if(ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()) instanceof Bishop)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()).isWhite())
			{
			b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishop);
			}
			else
			{
			b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishop);
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()) instanceof Rook)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()).isWhite())
			{
			b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteRook);
			}
			else
			{
			b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackRook);
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()) instanceof Knight)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()).isWhite())
			{
			b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnight);
			}
			else
			{
			b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnight);
			}
		}
		
		if(ge.getValidCheck())
		{
			ge.changePlayerTurn();
		}
		ge.setSplitCheck(false);
		ge.resetChecks();
		window.getControl().setEnabled(false);
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
