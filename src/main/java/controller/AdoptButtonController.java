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
				Pet selectedPet = view.getShelter().findPetByNameAndType(selectedName, selectedSpecies);
				if(selectedPet.adopt() == true) {
					JOptionPane.showMessageDialog((Component) null,"This pet has been marked as adopted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog((Component) null,"This pet is already marked as adopted.", "Oops!", JOptionPane.ERROR_MESSAGE);
					}
			}
			//JOptionPane.showMessageDialog((Component) null,"To adopt a pet, select the pet you want to adopt from the list and click the adopt button.", "Help", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
}
