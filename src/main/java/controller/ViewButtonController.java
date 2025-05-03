package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Pet;
import view.UserView;

public class ViewButtonController {
private UserView view;
	
	
	public ViewButtonController(UserView v) {
		this.view = v;
		this.view.addViewButtonListener(new ViewButtonListener());
	}
	
	class ViewButtonListener implements ActionListener{

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
				Pet selectedPet = view.getShelter().findPetByNameAndType(selectedName, selectedSpecies);
				String petInfo = "Name: " + selectedPet.getName() + 
						"\nAge: " + selectedPet.getAge() +
						"\nType: " + selectedPet.getType() +
						"\nSpecies: " + selectedPet.getSpecies() +
						"\nID Number: " + selectedPet.getID() +
						"\nAdopted: " + selectedPet.isAdopted();					
				JOptionPane.showMessageDialog((Component) null,petInfo, "Pet Info", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
		}
		
	}
}
