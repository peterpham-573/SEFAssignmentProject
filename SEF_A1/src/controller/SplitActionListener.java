package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.interfaces.ChessGameEngine;


public class SplitActionListener implements ActionListener {

	private ChessGameEngine ge;
	private Window b;


	public SplitActionListener(ChessGameEngine ge, Window window)
	{
		this.ge = ge;
		this.b = window;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
			if (!ge.getSplitCheck())
			{
				//Backend callbacks
				System.out.println("SPLIT CLICKED");
				JOptionPane.showMessageDialog(b, "Piece chosen to be split!");
				ge.setSplitCheck(true);
			}
			else
			{
				//Backend callbacks
				System.out.println("SPLIT UNCLICKED");
				JOptionPane.showMessageDialog(b, "Split action cancelled!");
				ge.setSplitCheck(false);
			}
	}

}
