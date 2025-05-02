package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import controller.HelpButtonController.HelpButtonListener;
import view.UserView;
import model.AgeComparator;
import model.SpeciesComparator;


public class ComboBoxController {
	private UserView view;
	
	public ComboBoxController(UserView v) {
		this.view = v;
		this.view.addComboBoxListener(new ComboBoxListener());
	}
	
	
	class ComboBoxListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String selection = (String)e.getItem().toString();
					
					switch (selection) {
						case "Age":
							view.getShelter().sortPets(new AgeComparator());
							view.getMainTable().updateTable(view.getShelter().getAllPets());
							break;
						case "Species":
							view.getShelter().sortPets(new SpeciesComparator());
							view.getMainTable().updateTable(view.getShelter().getAllPets());
							break;
						case "Name":
							view.getShelter().sortPets();
							view.getMainTable().updateTable(view.getShelter().getAllPets());
							break;
					}
					
					
				}
			}
			
			
		}
		
	}
}
