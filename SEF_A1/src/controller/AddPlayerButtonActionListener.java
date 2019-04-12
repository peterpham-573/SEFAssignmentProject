package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RegistrationApp;

public class AddPlayerButtonActionListener implements ActionListener{

	private RegistrationApp registrationApp;
	
	public AddPlayerButtonActionListener(RegistrationApp registrationApp) {
		this.registrationApp= registrationApp;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		registrationApp.CreatePlayer();
	}
}
