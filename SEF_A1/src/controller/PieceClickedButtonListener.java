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
				//window.getControl().setEnabled(false);
				ge.resetChecks();
				System.out.println("testies");
				//				window.repaint();
				//				window.revalidate();
			}
			else
			{
				Piece tempPiece = ge.getChessBoard().getPiece(ge.getStart());
				boolean mergeCheck = ge.movePiece(ge.getStart(), ge.getEnd());
				window.getPlayerPanel().updateScore();
				boolean check = ge.getValidCheck();

				System.out.println(ge.getChessBoard().getPiece(ge.getEnd()).isWhite());
				System.out.println(ge.isWhitePlayerTurn());
				//if the merge is true
				if (tempPiece.isWhite() == ge.isWhitePlayerTurn())
				{
					if (mergeCheck == true && check == true)
					{

						if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knook && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
							b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnook);
							ge.changePlayerTurn();
						}
						else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knightshop && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
							b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnightshop);
							ge.changePlayerTurn();
						}
						else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishook && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
							b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishook);
							ge.changePlayerTurn();
						}
						else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knook && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
							b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnook);
							ge.changePlayerTurn();
						}
						else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knightshop && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
							b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnightshop);
							ge.changePlayerTurn();
						}
						else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishook && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
						{
							b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
							b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishook);
							ge.changePlayerTurn();
						}
					}
					else if (check == false)
					{
						ge.resetChecks();
					}
					else if (mergeCheck == false)
					{
						if(check == true)
						{

							if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackRook);
								ge.changePlayerTurn();
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackKnight);
								ge.changePlayerTurn();
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop && !ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{

								b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(blackBishop);
								ge.changePlayerTurn();
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Rook && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteRook);
								ge.changePlayerTurn();
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Knight && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteKnight);
								ge.changePlayerTurn();
							}
							else if (ge.getChessBoard().getPiece(ge.getEnd()) instanceof Bishop && ge.getChessBoard().getPiece(ge.getEnd()).isWhite())
							{
								b.getTile(ge.getStart().getRow(), ge.getStart().getCol()).setIcon(null);
								b.getTile(ge.getEnd().getRow(), ge.getEnd().getCol()).setIcon(whiteBishop);
								ge.changePlayerTurn();	
							}
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
