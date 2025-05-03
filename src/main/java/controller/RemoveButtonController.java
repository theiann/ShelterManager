package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Pet;
import view.UserView;

public class RemoveButtonController {
private UserView view;
	
	
	public RemoveButtonController(UserView v) {
		this.view = v;
		this.view.addRemoveButtonListener(new RemoveButtonListener());
	}
	
	class RemoveButtonListener implements ActionListener{

		/*
		 * This method removes the selected pet and then refreshes the table.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JTable table = view.getMainTable().getTable();
			
			
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog((Component) null,"You don't have a pet selected.", "Oops!", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				String selectedName = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String selectedSpecies = (String) table.getModel().getValueAt(table.getSelectedRow(), 2);
				System.out.println(selectedName + " " + selectedSpecies);
				Pet selectedPet = view.getShelter().findPetByNameAndSpecies(selectedName, selectedSpecies);
				view.getShelter().removePet(selectedPet);
				view.getMainTable().updateTable(view.getShelter().getAllPets());
			}
			
		}
		
	}
}
