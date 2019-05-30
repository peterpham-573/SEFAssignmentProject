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
import view.Board;
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
	private Board b;

	public PieceClickedButtonListener(int i, int j, ChessGameEngine ge, Board b, Window window)
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
		//IF the start position has not been set, then set the starting posions (ge.setStart(i, j))
		if (ge.checkStart() == false)
		{
			if (ge.getChessBoard().getPieceOnBoard(i, j).isWhite() == ge.isWhitePlayerTurn() && !ge.getChessBoard().getPieceOnBoard(i, j).getIcon().equalsIgnoreCase("_"))
			{
				ge.setStart(i, j);

				Piece temp = ge.getChessBoard().getPiece(ge.getStart());
				window.getBoard().paintSelected(temp.validMovementsList(ge.getChessBoard().getChessBoardArr()));
			}
			//IF the piece is a merged piece, enable the split button
			if (
					(ge.getChessBoard().getPieceOnBoard(i, j) instanceof Knook || 
							ge.getChessBoard().getPieceOnBoard(i, j) instanceof Knightshop || 
							ge.getChessBoard().getPieceOnBoard(i, j) instanceof Bishook) &&
					ge.isWhitePlayerTurn() == ge.getChessBoard().getPieceOnBoard(i, j).isWhite()
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

			//IF the same tile is clicked twice, cancel the move
			if (ge.getStart().isEqual(ge.getEnd()))
			{
				window.getBoard().repaintBackground();
				window.getControl().setEnabled(false);
				ge.resetChecks();
			}
			//ELSE IF the piece moving is a merged piece, and the end position is the same colour, call invalid movement
			else if(((ge.getChessBoard().getPiece(ge.getStart()) instanceof Knight &&
					ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight) ||

					(ge.getChessBoard().getPiece(ge.getStart()) instanceof Bishop &&
							ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop) ||

					(ge.getChessBoard().getPiece(ge.getStart()) instanceof Rook &&
							ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook) ||

					(ge.getChessBoard().getPiece(ge.getStart()) instanceof Bishook &&
							ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishook) ||

					(ge.getChessBoard().getPiece(ge.getStart()) instanceof Knightshop &&
							ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knightshop) ||

					(ge.getChessBoard().getPiece(ge.getStart()) instanceof Knook &&
							ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knook)
					) && 
					(ge.getChessBoard().getPiece(ge.getEnd()).isWhite() == ge.getChessBoard().getPiece(ge.getStart()).isWhite())
					)
			{
				JOptionPane.showMessageDialog(b, "Warning: Invalid Move!");
				window.getBoard().repaintBackground();
				ge.resetChecks();
			}
			else
			{
				Piece tempPiece = ge.getChessBoard().getPiece(ge.getStart());
				boolean mergeCheck = ge.movePiece(ge.getStart(), ge.getEnd());
				window.getPlayerPanel().updateScore();
				boolean check = ge.getValidCheck();
				//if piece colour is not same as the colour of the player's turn
				if (tempPiece.isWhite() != ge.isWhitePlayerTurn())
				{
					window.getBoard().repaintBackground();
					ge.resetChecks();
				}
				//if piece is same as player turn
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
							//repaints the chessboard from the blue valid movements
							window.getBoard().repaintBackground();
							ge.resetChecks();
						}
						else if (mergeCheck == false)
						{
							if(check == true)
							{
								//PAINTS WHAT EVER IS MOVED
								
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


					//Updating of the player turn and the remaining turns -> White turn + Black turn = 1 Full Turn
					window.getStatusPanel().updateTurnsRemaining(ge);
					window.getStatusPanel().updateCurrentPlayer(ge);


					ge.resetChecks();
				}
			}
		}
	}
	//normalMove(), mergeMove(), splitMove() are all repaints to repaint the icon according to what is on the tile
	public void normalMove()
	{
		if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);

			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackRook);
				window.getBoard().repaintBackground();
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteRook);
				window.getBoard().repaintBackground();
			}


			ge.changePlayerTurn();
		}
		else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight)
		{
			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);

			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnight);
				window.getBoard().repaintBackground();
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnight);
				window.getBoard().repaintBackground();
			}
			ge.changePlayerTurn();
		}
		else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop)
		{

			b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);

			if(!ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishop);
				window.getBoard().repaintBackground();
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishop);
				window.getBoard().repaintBackground();
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
				window.getBoard().repaintBackground();
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnook);
				window.getBoard().repaintBackground();
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
				window.getBoard().repaintBackground();
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnightshop);
				window.getBoard().repaintBackground();
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
				window.getBoard().repaintBackground();
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishook);
				window.getBoard().repaintBackground();
			}


			window.getControl().setEnabled(false);
			ge.changePlayerTurn();
		}
	}

	public void splitMove()
	{
		boolean startCheck = false;
		boolean endCheck = false;
		//paint the start
		if(ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()) instanceof Bishop)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()).isWhite())
			{
				b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(whiteBishop);
				
				startCheck = true;
			}
			else
			{
				b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(blackBishop);
			
				startCheck = true;
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()) instanceof Rook)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()).isWhite())
			{
				b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(whiteRook);
			
				startCheck = true;
			}
			else
			{
				b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(blackRook);
			
				startCheck = true;
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()) instanceof Knight)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getStart().getRow(), ge.getStart().getCol()).isWhite())
			{
				b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(whiteKnight);
			
				startCheck = true;
			}
			else
			{
				b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(blackKnight);
		
				startCheck = true;
			}
		}
		//paint the end
		if(ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()) instanceof Bishop)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishop);
			
				endCheck = true;
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishop);
		
				endCheck = true;
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()) instanceof Rook)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteRook);
			
				endCheck = true;
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackRook);
			
				endCheck = true;
			}
		}
		else if(ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()) instanceof Knight)
		{
			if (ge.getChessBoard().getPieceOnBoard(ge.getEnd().getRow(), ge.getEnd().getCol()).isWhite())
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnight);

				endCheck = true;
			}
			else
			{
				b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnight);
				
				endCheck = true;
			}
		}
				if(startCheck == true && endCheck == true)
				{
					ge.changePlayerTurn();
				}
		ge.setSplitCheck(false);
		ge.resetChecks();
		window.getBoard().repaintBackground();
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
