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
	
	
	/*
	 * This method displays the help popup when clicked.
	 */
	class HelpButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog((Component) null,"To adopt a pet, select the pet you want to adopt from the list and then click the Adopt button."
					+ "\n\nTo display info on a pet, select the pet you want to view from the list and then click the View Details button."
					+ "\n\nTo remove a pet from the shelter, select the pet you want to remove from the list and then click the Remove button."
					+ "\n\nTo add a pet to the shelter, click the Add Pet button and fill out all prompts."
					+ "\n\nTo save all pets as a .json file, click the Save button.", "Help", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
}
