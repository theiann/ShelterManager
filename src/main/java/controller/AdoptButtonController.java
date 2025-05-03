package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controller.HelpButtonController.HelpButtonListener;
import model.Pet;
import view.UserView;
import javax.swing.table.TableModel;


public class AdoptButtonController {
	private UserView view;
	
	
	public AdoptButtonController(UserView v) {
		this.view = v;
		this.view.addAdoptButtonListener(new AdoptButtonListener());
	}
	
	class AdoptButtonListener implements ActionListener{

		
		/*
		 * This method gets the pet currently selected and tries to mark it as adopted.
		 * If the pet is already adopted or if no pet is selected, it will pop up with an error message.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JTable table = view.getMainTable().getTable();
			
			
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog((Component) null,"You don't have a pet selected.\nTo adopt a pet, select the pet you want to adopt from the list and click the adopt button.", "Oops!", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				String selectedName = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String selectedSpecies = (String) table.getModel().getValueAt(table.getSelectedRow(), 2);
				System.out.println(selectedName + " " + selectedSpecies);
				Pet selectedPet = view.getShelter().findPetByNameAndSpecies(selectedName, selectedSpecies);
				if(selectedPet.adopt() == true) {
					JOptionPane.showMessageDialog((Component) null,selectedPet.getName() + " has been marked as adopted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog((Component) null,selectedPet.getName() + " is already marked as adopted.", "Oops!", JOptionPane.ERROR_MESSAGE);
					}
			}
			
			
		}
		
	}
}
