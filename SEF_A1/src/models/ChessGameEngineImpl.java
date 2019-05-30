package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.interfaces.ChessGameEngine;
import models.pieces.Bishook;
import models.pieces.Bishop;
import models.pieces.Knight;
import models.pieces.Knightshop;
import models.pieces.Knook;
import models.pieces.Piece;
import models.pieces.Rook;

public class ChessGameEngineImpl implements ChessGameEngine
{
	private List<ChessPlayer> players = new ArrayList<ChessPlayer>();

	private ChessBoard chessboard;

	private ChessPlayer player1, player2;

	private PiecePosition start, end;
	private boolean checkStart, checkEnd, split = false, checkValid = false, checkGameEnd = false, isWhitePlayerTurn = true;
	private int maxTurns, turnNumber;

	public ChessGameEngineImpl()
	{
		chessboard = new ChessBoard();
	}

	@Override
	public void addPlayer(ChessPlayer player) 
	{
		players.add(player);
	}

	@Override
	public ChessPlayer getPlayer(String user) 
	{
		ChessPlayer p = null;
		for (int i = 0; i < players.size(); i++)
		{
			if (players.get(i).getPlayerUserName().equalsIgnoreCase(user))
			{
				p = players.get(i);
			}
		}
		return p;		
	}

	/*
	 *	if returns false, piece has moved to empty place
	 *	if returns true, piece has merged with piece
	 */
	@Override
	public boolean movePiece(PiecePosition start, PiecePosition end)
	{
		/*::PSEUDOCODE::
		 * GETS the piece of the start and end
		 * IF piece is empty, then return false
		 * 
		 * if piece is the same colour as player, CHECK if split button has been clicked
		 * 		IF split has been clicked, then split the pieces according.
		 * 
		 * ELSE move the piece.
		 * IF piece has been moved, game engine will check if the end piece contains a piece.
		 * IF piece is friendly & valid piece & valid movement, THEN merge the pieces together
		 * ELSE if piece is enemy, and valid movement, then CAPTURE the piece
		 * ADD points according to piece bounty ( +5 for normal piece, +10 for merged piece)
		 */

		//Checks for pieces on the board with the positions -- These are temporary values
		Piece p = chessboard.getPiece(start);

		Piece p2 = chessboard.getPiece(end);
		
		if (p.getIcon().equalsIgnoreCase("_"))
		{
			checkValid = false;
			return false;
		}

		if(p.isWhite() == isWhitePlayerTurn)
		{	
			if (split == true)
			{
				splitPieces(p, start, end);
			}
			else
			{
				//moving the piece positions
				checkValid = chessboard.movePiece(start, end);
				
				// If where we move our chess piece has an existing piece AND is not their own piece then capture
				if(chessboard.getChessBoardArr()[end.getRow()][end.getCol()] instanceof Piece)
				{
					//If the opponent piece does not have their piece located on that spot
					if(p2.getIcon().equalsIgnoreCase("_"))
					{
						if(checkValid) {
							turnNumber++;
						}
					}
					else
					{
						//Checks to see if capturing enemy or self
						if((p.isWhite() != p2.isWhite()) && checkValid)
						{
							//capturing is normal as moving the piece by itself, capturing is just setting up points
							capture(p,p2);
							turnNumber++;
						}
						else
						{
							if(p instanceof Knook || p instanceof Knightshop || p instanceof Bishook)
							{
								checkValid = false;
								return false;
							}
							else if(!(p2 instanceof Knook || p2 instanceof Knightshop || p2 instanceof Bishook) &&
									 (p instanceof Knight || p instanceof Bishop || p instanceof Rook) && checkValid)
							{
								merge(p, p2, start, end);
								turnNumber++;

								return true;
							}
						}
					}
				}
			}
		}


		return false;
	}

	@Override
	public void capture(Piece piece, Piece piece2) 
	{
		//Updates the player's points by 5 every time a capture is successful (or 10 if merged piece)
		if (piece2 instanceof Rook || piece2 instanceof Knight || piece2 instanceof Bishop)
		{
			if (piece2.isWhite() == true)
			{
				player1.setPoints(player1.getPoints() + 5);
			}
			else
			{
				player2.setPoints(player2.getPoints() + 5);
			}
		}
		else if (piece2 instanceof Knook || piece2 instanceof Knightshop || piece2 instanceof Bishook)
		{
			if (piece2.isWhite() == true)
			{
				player1.setPoints(player1.getPoints() + 10);
			}
			else
			{
				player2.setPoints(player2.getPoints() + 10);
			}
		}
		moveCheckEnd();
	}

	@Override
	public void merge(Piece piece, Piece piece2, PiecePosition start, PiecePosition end)
	{
		//sets the merged piece to the end position of where the player wants to move
		//sets the start position as a new piece
		if ( (piece instanceof Rook && piece2 instanceof Knight) || (piece instanceof Knight && piece2 instanceof Rook))
		{
			chessboard.setPiece(new Piece(), start.getRow(), start.getCol());
			chessboard.setPiece(new Knook(piece.isWhite(), new PiecePosition(end.getRow(), end.getCol())), end.getRow(), end.getCol());
		}
		else if ( (piece instanceof Bishop && piece2 instanceof Knight) || (piece instanceof Knight && piece2 instanceof Bishop))
		{
			chessboard.setPiece(new Piece(), start.getRow(), start.getCol());
			chessboard.setPiece(new Knightshop(piece.isWhite(), new PiecePosition(end.getRow(), end.getCol())), end.getRow(), end.getCol());
		}
		else if ( (piece instanceof Rook && piece2 instanceof Bishop) || (piece instanceof Bishop && piece2 instanceof Rook))
		{
			chessboard.setPiece(new Piece(), start.getRow(), start.getCol());
			chessboard.setPiece(new Bishook(piece.isWhite(), new PiecePosition(end.getRow(), end.getCol())), end.getRow(), end.getCol());
		}



	}

	@Override
	public boolean splitPieces(Piece piece, PiecePosition start, PiecePosition end)
	{
		boolean s = false;
		//TODO :: add split piece
		/*
		 * PSEUDO CODE:
		 * 
		 *  Check for which piece split is,
		 *  Check for where the end position is for the split pieces
		 *  set piece at the position of the board if the tile is empty
		 */
		if(piece instanceof Knook)
		{
			//Make temporary pieces at the starting position
			Piece tempK = new Knight(piece.isWhite(), start);
			Piece tempR = new Rook(piece.isWhite(), start);
			
			//Creates the valid positions for knights at the point, checks if the end position is correct
			LinkedList<PiecePosition> kPos = tempK.validMovementsList(chessboard.getChessBoardArr());
			for (PiecePosition k : kPos)
			{
				if (end.getRow() == k.getRow() && end.getCol() == k.getCol())
				{
					//if the position is valid, then set the correct piece at the valid end position
					if (chessboard.getPiece(end).getIcon().equalsIgnoreCase("_"))
					{
						chessboard.putPiece(end.getRow(), end.getCol(), new Knight(piece.isWhite(), end));
						chessboard.putPiece(start.getRow(), start.getCol(), tempR);
						s = true;
					}
				}
			}
			LinkedList<PiecePosition> rPos = tempR.validMovementsList(chessboard.getChessBoardArr());
			for (PiecePosition r : rPos)
			{
				if (end.getRow() == r.getRow() && end.getCol() == r.getCol())
				{
					//if the position is valid, then set the correct piece at the valid end position
					if (chessboard.getPiece(end).getIcon().equalsIgnoreCase("_"))
					{
						chessboard.putPiece(end.getRow(), end.getCol(), new Rook(piece.isWhite(), end));
						chessboard.putPiece(start.getRow(), start.getCol(), tempK);
						s = true;
					}
				}
			}
			
		}
		else if(piece instanceof Knightshop)
		{
			//Make temporary pieces at the starting position
			Piece tempK = new Knight(piece.isWhite(), start);
			Piece tempB = new Bishop(piece.isWhite(), start);
			
			//Creates the valid positions for knights at the point, checks if the end position is correct
			LinkedList<PiecePosition> kPos = tempK.validMovementsList(chessboard.getChessBoardArr());
			for (PiecePosition k : kPos)
			{
				if (end.getRow() == k.getRow() && end.getCol() == k.getCol())
				{
					//if the position is valid, then set the correct piece at the valid end position
					if (chessboard.getPiece(end).getIcon().equalsIgnoreCase("_"))
					{
						chessboard.putPiece(end.getRow(), end.getCol(), new Knight(piece.isWhite(), end));
						chessboard.putPiece(start.getRow(), start.getCol(), tempB);
						s = true;
					}
				}
			}
			LinkedList<PiecePosition> bPos = tempB.validMovementsList(chessboard.getChessBoardArr());
			for (PiecePosition b : bPos)
			{
				if (end.getRow() == b.getRow() && end.getCol() == b.getCol())
				{
					//if the position is valid, then set the correct piece at the valid end position
					if (chessboard.getPiece(end).getIcon().equalsIgnoreCase("_"))
					{
						chessboard.putPiece(end.getRow(), end.getCol(), new Bishop(piece.isWhite(), end));
						chessboard.putPiece(start.getRow(), start.getCol(), tempK);
						s = true;
					}
				}
			}
			
		}
		else if(piece instanceof Bishook)
		{
			//Make temporary pieces at the starting position
			Piece tempB = new Bishop(piece.isWhite(), start);
			Piece tempR = new Rook(piece.isWhite(), start);
			
			//Creates the valid positions for knights at the point, checks if the end position is correct
			LinkedList<PiecePosition> bPos = tempB.validMovementsList(chessboard.getChessBoardArr());
			for (PiecePosition b : bPos)
			{
				if (end.getRow() == b.getRow() && end.getCol() == b.getCol())
				{
					//if the position is valid, then set the correct piece at the valid end position
					if (chessboard.getPiece(end).getIcon().equalsIgnoreCase("_"))
					{
						chessboard.putPiece(end.getRow(), end.getCol(), new Bishop(piece.isWhite(), end));
						chessboard.putPiece(start.getRow(), start.getCol(), tempR);
						s = true;
					}
				}
			}
			LinkedList<PiecePosition> rPos = tempR.validMovementsList(chessboard.getChessBoardArr());
			for (PiecePosition r : rPos)
			{
				if (end.getRow() == r.getRow() && end.getCol() == r.getCol())
				{
					//if the position is valid, then set the correct piece at the valid end position
					if (chessboard.getPiece(end).getIcon().equalsIgnoreCase("_"))
					{
						chessboard.putPiece(end.getRow(), end.getCol(), new Rook(piece.isWhite(), end));
						chessboard.putPiece(start.getRow(), start.getCol(), tempB);
						s = true;
					}
				}
			}
			
		}
		
		if (s == false)
		{
			resetChecks();
		}
		return s;
	}

	public ChessBoard getChessBoard() {
		return chessboard;
	}


	public ChessPlayer getPlayerOne()
	{
		return player1;
	}

	public ChessPlayer getPlayerTwo()
	{
		return player2;
	}

	public void setPlayerOne(ChessPlayer player)
	{
		player1 = player;
	}

	public void setPlayerTwo(ChessPlayer player)
	{
		player2 = player;
	}

	public PiecePosition getStart()
	{
		return start;		
	}

	public PiecePosition getEnd()
	{
		return end;
	}

	public void setStart(int i, int j)
	{
		start = new PiecePosition(i, j);
		checkStart = true;
	}

	public void setEnd(int i, int j)
	{
		end = new PiecePosition(i, j);
		checkEnd = true;
	}

	public boolean checkStart() 
	{
		return checkStart;
	}

	public boolean checkEnd() 
	{
		return checkEnd;
	}

	public void resetChecks() 
	{
		checkStart = false;
		checkEnd = false;
		checkValid = false;
	}

	public boolean getValidCheck()
	{
		return checkValid;
	}

	public boolean checkGameEnd() 
	{
		//If turnNumber = 0

		moveCheckEnd();
		turnCheckEnd();
		return checkGameEnd;
	}

	public void moveCheckEnd() {
		if(player1.getPoints() == 30) {
			checkGameEnd = true;
		}
		if(player2.getPoints() == 30) {
			checkGameEnd = true;
		}
	}

	public void turnCheckEnd() {
		if(turnNumber/2 == maxTurns) {
			checkGameEnd = true;
		}
	}

	public void calculateMaxTurns() {
		maxTurns = (player1.getNoOfTurns() + player2.getNoOfTurns()) / 2;
	}

	public int remainingTurns()
	{
		return maxTurns - (turnNumber/2);
	}

	public String getWinningMessage() {

		if(player1.getPoints() > player2.getPoints())
		{
			return player1.getPlayerName() + " wins with " + player1.getPoints() + " points.";
		}
		else if(player1.getPoints() == player2.getPoints())
		{
			return "Draw.";
		}
		else
		{
			return player2.getPlayerName() + " wins with " + player2.getPoints() + " points.";
		}
	}

	public String getCurrentPlayerTurn()
	{
		if(isWhitePlayerTurn)
		{
			return player1.getPlayerUserName();
		}
		else
		{
			return player2.getPlayerUserName();
		}
	}

	public boolean isWhitePlayerTurn()
	{
		return isWhitePlayerTurn;
	}
	//changeplayerturn
	public void changePlayerTurn()
	{
		if (isWhitePlayerTurn == true)
		{
			isWhitePlayerTurn = false;
		}
		else
		{
			isWhitePlayerTurn = true;
		}		
	}

	public void setSplitCheck(boolean c) 
	{
		this.split = c;
	}

	public boolean getSplitCheck() 
	{
		return split;
	}
}
