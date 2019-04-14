package models;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.ChessGameEngine;
import models.pieces.Piece;

public class ChessGameEngineImpl implements ChessGameEngine
{
	private List<ChessPlayer> players = new ArrayList<ChessPlayer>();
	@Override
	public void addPlayer(ChessPlayer player) {
		// TODO Auto-generated method stub
		players.add(player);
	}

	@Override
	public void getPlayer(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlayer(ChessPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePiece(Piece piece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void capture(Piece piece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChessboard(ChessBoard cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChessboard(ChessBoard cb) {
		// TODO Auto-generated method stub
		
	}

}
