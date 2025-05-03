package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import view.UserView;

public class SaveButtonController {
	private UserView view;
	
	
	public SaveButtonController(UserView v) {
		this.view = v;
		this.view.addSaveButtonListener(new SaveButtonListener());
	}
	
	class SaveButtonListener implements ActionListener{

		
		/*
		 * This method saves the list of pets currently in shelter to a json file when the save button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				view.getShelter().saveOntoFile();
				JOptionPane.showMessageDialog((Component) null,"File successfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog((Component) null,"Something went wrong.", "Oops!", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
		}
		
	}
}
