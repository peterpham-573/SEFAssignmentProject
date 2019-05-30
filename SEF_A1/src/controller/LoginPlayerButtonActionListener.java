package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RegistrationApp;

public class LoginPlayerButtonActionListener implements ActionListener{

	private RegistrationApp registrationApp;
	
	public LoginPlayerButtonActionListener(RegistrationApp registrationApp) {
		this.registrationApp= registrationApp;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		registrationApp.loginPlayer();
	}

}
