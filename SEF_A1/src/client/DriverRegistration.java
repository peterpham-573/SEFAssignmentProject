package client;
import javax.swing.SwingUtilities;

import models.ChessGameRegistry;
import view.RegistrationApp;

public class DriverRegistration 
{
	//Driver for the Registration
	public static void main(String[] args) 
	{
		final ChessGameRegistry chessGameRegistry = new ChessGameRegistry();
		SwingUtilities.invokeLater(() -> new RegistrationApp(chessGameRegistry));
	}
}
