package model;

import java.util.ArrayList;
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

}
