package main;

import java.io.IOException;
import java.util.List;

import model.ExoticAnimal;
import model.Manager;
import model.Pet;
import model.Shelter;

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
       // printPets(adaptedExotics);
       UserView view = new UserView();
        
        
	}
	
	
	private static void printPets(List<Pet> pets) {
        for (Pet pet : pets) {
            System.out.println(pet.getID() + ": " + pet + (pet.isAdopted() ? " (Adopted)" : " (Available)"));
        }
    }
	

	}
		


