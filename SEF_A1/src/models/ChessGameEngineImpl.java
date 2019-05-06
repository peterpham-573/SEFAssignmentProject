package models;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.ChessGameEngine;
import models.pieces.Piece;

public class ChessGameEngineImpl implements ChessGameEngine
{
	private List<ChessPlayer> players = new ArrayList<ChessPlayer>();

	private ChessBoard chessboard;

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
	public void movePiece(String start, String end)
	{
		
		//Converts the strings to positions 
		PiecePosition z = chessboard.toPos(start);

		PiecePosition x = chessboard.toPos(end);
		
		//Checks for pieces on the board with the positions 
		
		Piece p = chessboard.getChessBoardArr()[z.getRow()][z.getCol()];

		Piece p2 = chessboard.getPieceOnBoard(x.getRow(), x.getCol());

		// If where we move our chess piece has an existing piece AND is not their own piece then capture
		if(chessboard.getChessBoardArr()[x.getRow()][x.getCol()] instanceof Piece)
		{
			
			//If the oponent piece does not have their piece located on that spot
			if(p2.getIcon().equalsIgnoreCase("_"))
			{
				chessboard.movePiece(start, end);
			}
			else
			{
				//Checks to see if capturing enemy or self
				if( p.isWhite() != p2.isWhite())
				{
					capture( p, p2);
				}
				else
				{
					//You can not capture your own piece.
				}
			}
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
}
