package main;

import java.io.IOException;
import java.util.List;

import model.Dog;
import model.ExoticAnimal;
import model.Manager;
import model.Pet;
import model.Shelter;
import model.AgeComparator;
import model.SpeciesComparator;
import controller.AdoptButtonController;
import controller.ComboBoxController;
import controller.HelpButtonController;

import view.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Shelter <Pet> newShelter = new Shelter<>(); 
		Manager dataManager = new Manager(); 
		
		//Loads and prints pets loaded from pets.JSON
		List<Pet> loadedPets =dataManager.loadPets();
		System.out.println ("Loaded "+loadedPets.size() + " pets from Pets.JSON:");
		//printPets(loadedPets);
	    
		//Loads and prints pets loaded from exoticanimal.JSON
		List<ExoticAnimal>exotics = dataManager.loadExoticAnimals();
		List<Pet> adaptedExotics = dataManager.adaptExoticAnimals(exotics);
		System.out.println ("");
        System.out.println ("Loaded "+ adaptedExotics.size() + " exotic animals from exotic_animals.JSON:");
       // printPets(adaptedExotics)
        
        //adds pets loaded from JSON to shelter
        for(Pet pet : loadedPets) {
        	newShelter.addPet(pet);
        }
         
        //adds exotic animals loaded from JSON to shelter as adapted pets
        for(Pet pet : adaptedExotics) {
        	newShelter.addPet(pet);
        }
        
        //prints all pets currently in shelter
        System.out.println ("");
        System.out.println("All pets in shelter:");
        printPets(newShelter.getAllPets());
        
        
        //tests for adding and removing pet from shelter
        //can remove pet with actual pet being passed or the Id also seperately
        System.out.println ("");
        newShelter.addPet(new Dog(4, "Alex", null, "German Shepherd", 5));
        
      // String nameToRemove = "Iggy";
      // String typeToRemove = "Iguana";
       
       String nameToRemove = "Thumper";
       String typeToRemove = "Dutch";
       
        Pet petToRemove = newShelter.findPetByNameAndType(nameToRemove , typeToRemove);
        newShelter.removePet(petToRemove);
        
        //adopting pet
        Pet pet2 = newShelter.findPetByNameAndType("Whiskers" , "Siamese");
        Pet pet1 = newShelter.findPetByNameAndType("Zazu" , "Toucan");
        newShelter.adoptPet(pet2);
        newShelter.adoptPet(pet1);
        
        //sort by name
        newShelter.sortPets();
        
        //sort by age
        //newShelter.sortPets(new AgeComparator());
         
        //sort by species
        //newShelter.sortPets(new SpeciesComparator()); 
        
        UserView view = new UserView(newShelter);
        HelpButtonController helpController = new HelpButtonController(view);
        ComboBoxController sortByController = new ComboBoxController(view);
        AdoptButtonController adoptController = new AdoptButtonController(view);
         
        printPets(newShelter.getAllPets());
        
        //dataManager.saveOntoFile(newShelter.getAllPets());
        //System.out.println("Pets saved successfully onto JSON file");
	}
	
	
	private static void printPets(List<Pet> pets) {
        for (Pet pet : pets) {
            System.out.println(pet.getID() + ": " + pet + (pet.isAdopted() ? " (Adopted)" : " (Available)"));
        }
    }
	

	}
		


