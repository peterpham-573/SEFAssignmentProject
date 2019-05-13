package models;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.ChessGameEngine;
import models.pieces.Piece;

public class ChessGameEngineImpl implements ChessGameEngine
{
	private List<ChessPlayer> players = new ArrayList<ChessPlayer>();

	private ChessBoard chessboard;
	
	private ChessPlayer player1, player2;
	
	private PiecePosition start, end;
	private boolean checkStart, checkEnd;

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
		// TODO Auto-generated method stub
	}

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
				chessboard.movePiece2(start, end);
				return true;
			}
			else
			{
				//Checks to see if capturing enemy or self
				if( p.isWhite() != p2.isWhite())
				{
					capture( p, p2);
					return true;
				}
				else
				{
					//merge (p, p2);
					System.out.println("wow");
					return true;
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
	
}
