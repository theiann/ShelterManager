package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.UserView;

public class HelpButtonController {
	private UserView view;
	
	
	public HelpButtonController(UserView v) {
		this.view = v;
		this.view.addHelpButtonListener(new HelpButtonListener());
	}
	
	class HelpButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog((Component) null,"To adopt a pet, select the pet you want to adopt from the list and click the adopt button.", "Help", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
}
