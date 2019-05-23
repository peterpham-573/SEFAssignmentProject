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

public class SplitActionListener implements ActionListener {

	private ChessGameEngine ge;


	public SplitActionListener(ChessGameEngine ge)
	{
		this.ge = ge;

	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (!ge.getSplitCheck)
		{
			ge.setSplitCheck(true);
		}
		else
		{
			ge.setSplitCheck(false);
		}
	}

}
