package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter<T extends Pet> { 
private List<T> pets;

public Shelter() {
	this.pets = new ArrayList<>(); 
}

public void addPet(T pet) {
	pets.add(pet);
}

public boolean removePet(T pet) {
	return pets.remove(pet);
} 

public T removePetByID(int id) {
	for(int i = 0; i<pets.size(); i++) {
		if(pets.get(i).getID() == id) {
			return pets.remove(i);
		}
	}
	return null; 
}

public T findPetByNameAndType(String name, String type) {
	for(int i = 0; i<pets.size(); i++) {
        if(pets.get(i).getName().equalsIgnoreCase(name) && pets.get(i).getSpecies().equalsIgnoreCase(type)) {
            return pets.remove(i);
        }
	}
	return null;
}

public boolean adoptPet(String name, String type) {
	T pet = findPetByNameAndType(name,type);
	if(pet != null) {
		return pet.adopt();
	}
	return false; 
}

public List<T> getAllPets(){
	return new ArrayList<>(pets); 
}


public List<T> getAvailablePets(){
	List <T> availablePets = new ArrayList<>(); 
	for(T pet: pets ) {
		if(!pet.isAdopted()) {
			availablePets.add(pet);
		}
	}
	return availablePets; 
}

public void sortPets() {
	Collections.sort(pets);
}

public void sortPets(Comparator<Pet> comparator) {
	pets.sort(comparator);
}

}
