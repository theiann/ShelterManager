package controller;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



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

		
		
		/*
		 * This method allows the user to select between 3 different ways to sort the table of pets.
		 * After it sorts, it then refreshes the list.
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String selection = (String)e.getItem().toString();
					
					switch (selection) {
						case "Age":
							view.getShelter().sortPets(new AgeComparator());
							break;
						case "Species":
							view.getShelter().sortPets(new SpeciesComparator());
							break;
						case "Name":
							view.getShelter().sortPets();
							break;
					}
					
					view.getMainTable().updateTable(view.getShelter().getAllPets());
				}
			}
			
			
		}
		
	}
}
