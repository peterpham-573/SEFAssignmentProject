package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.interfaces.ChessGameEngine;


public class SplitActionListener implements ActionListener {

	private ChessGameEngine ge;


	public SplitActionListener(ChessGameEngine ge)
	{
		this.ge = ge;

	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (!ge.getSplitCheck())
		{
			System.out.println("SPLIT CLICKED");
			ge.setSplitCheck(true);
		}
		else
		{
			System.out.println("SPLIT UNCLICKED");
			ge.setSplitCheck(false);
		}
	}

}
