package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import javax.swing.JTextField;

import model.Pet;
import view.UserView;

public class AddButtonController {
	private UserView view;
	
	
	public AddButtonController(UserView v) {
		this.view = v;
		this.view.addAddButtonListener(new AddButtonListener());
	}
	
	class AddButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JTextField name = new JTextField();
			JTextField type = new JTextField();
			JTextField species = new JTextField();
			JTextField id = new JTextField();
			JTextField age = new JTextField();
			Object[] message = {
				    "Name:", name,
				    "Type:", type,
				    "Species:", species,
				    "ID:", id,
				    "Age:", age
				};
			int option = JOptionPane.showConfirmDialog(null, message, "Add Pet", JOptionPane.OK_CANCEL_OPTION);
			if(option == 0) {
				String validatorMsg = isPetInputValid(id.getText(), name.getText(), type.getText(), species.getText(), age.getText());
				if(validatorMsg == "true") {
					Pet newPet = new Pet(Integer.parseInt(id.getText()), name.getText(), type.getText(), species.getText(), Integer.parseInt(age.getText())) {};
					view.getShelter().addPet(newPet);
					view.getMainTable().updateTable(view.getShelter().getAllPets());
					JOptionPane.showMessageDialog((Component) null,newPet.getName() + " has been added to the shelter!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog((Component) null,validatorMsg, "Oops!", JOptionPane.ERROR_MESSAGE);
				}	
			}
		}
	}
	
	
	/*
	 * Checks if the given inputs for adding a pet are valid. This is meant to be used only in AddButtonController.
	 * @return Returns "true" as a string if all inputs are valid. If inputs are invalid, it will return an error message as a string.
	 * 
	 */
	private String isPetInputValid(String id, String name, String type, String species, String age) {
		if((id.isBlank() == true)
				|| (name.isBlank() == true)
				|| (type.isBlank() == true)
				|| (species.isBlank() == true)
				|| (age.isBlank() == true))
		{
			return "You must fill out every text field.";
		} else {
			try {
	            Integer.parseInt(id);
	            Integer.parseInt(age);
	        } catch (NumberFormatException e) {
	            return "ID and Age can only contain digits.";
	        }
		}
		
		
		return "true";
	}
}
