package models;

import java.util.ArrayList;
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
	private boolean checkStart, checkEnd, checkValid, checkGameEnd = false;
	
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

	@Override
	public void removePlayer(ChessPlayer player) 
	{
		//do we even do anything with this method lol
	}

	/*
	 *	if returns false, piece has moved to empty place
	 *	if returns true, piece has merged with piece
	 */
	@Override
	public boolean movePiece(PiecePosition start, PiecePosition end)
	{
		
		//Checks for pieces on the board with the positions 
		Piece p = chessboard.getPiece(start);
		
		Piece p2 = chessboard.getPiece(end);

		// If where we move our chess piece has an existing piece AND is not their own piece then capture
		if(chessboard.getChessBoardArr()[end.getRow()][end.getCol()] instanceof Piece)
		{
			//If the opponent piece does not have their piece located on that spot
			if(p2.getIcon().equalsIgnoreCase("_"))
			{
				checkValid = chessboard.movePiece(start, end);
				return false;
			}
			else
			{
				//Checks to see if capturing enemy or self
				if( p.isWhite() != p2.isWhite())
				{
					capture( p, p2);
					return false;
				}
				else
				{
					if (p2 instanceof Knook || p2 instanceof Knightshop || p2 instanceof Bishook)
					{
						return false;
					}
					else
					{
						merge (p, p2, start, end);
						System.out.println("Piece has been merged");
						return true;
					}
				}
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public void capture(Piece piece, Piece piece2) 
	{
		//This method removes piece 2 and replaces it piece 1
		chessboard.removePiece(piece, piece2);
		//Updates the player's points by 5 every time a capture is successful
		//p.setPoints(p.getPoints()+ 5);
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
	public void split(PiecePosition place)
	{
		//TODO :: add split piece
	}

	@Override
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

	@Override
	public boolean checkStart() 
	{
		return checkStart;
	}

	@Override
	public boolean checkEnd() 
	{
		return checkEnd;
	}

	@Override
	public void resetChecks() 
	{
		checkStart = false;
		checkEnd = false;
	}
	
	public boolean getValidCheck()
	{
		return checkValid;
	}
	
	public boolean checkGameEnd() 
	{
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
	
}
