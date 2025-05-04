package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/*
 * Shelter class that can store any type of pet using Generics 
 */
public class Shelter<T extends Pet> { 
private List<T> pets;

/*
 * Creates a array list of pets for shelter
 */
public Shelter() {
	this.pets = new ArrayList<>(); 
}

/*
 * adds a pet to the shelter when called
 */
public void addPet(T pet) {
	pets.add(pet);
}

/*
 * removes a pet from the shelter when called
 */
public boolean removePet(T pet) {
	return pets.remove(pet);
} 

/*
 * if passed the name and species, finds the pet and returns it, returns null if not found
 */
public T findPetByNameAndSpecies(String name, String type) {
	 for (T pet : pets) {
         if(pet.getName().equalsIgnoreCase(name) && pet.getSpecies().equalsIgnoreCase(type)) {
             return pet;
         }  
	}
	return null;
}

/*
 * adopts the pet that is passed to the method
 */
public boolean adoptPet(T pet) {
	if(pet != null) { 
		return pet.adopt();
	}
	return false; 
}

/*
 * returns all the pets in the shelter currently
 */
public List<T> getAllPets(){
	return new ArrayList<>(pets); 
}

/*
 * returns a list of pets that are not yet adopted
 */
public List<T> getAvailablePets(){
	List <T> availablePets = new ArrayList<>(); 
	for(T pet: pets ) {
		if(!pet.isAdopted()) {
			availablePets.add(pet);
		}
	}
	return availablePets; 
}

/*
 * sorts pets with default name 
 */
public void sortPets() {
	Collections.sort(pets);
}

/*
 * sorts pet with desired comparator (age or species) whatever is passed
 */
public void sortPets(Comparator<Pet> comparator) {
	pets.sort(comparator);
}
/*
 * saves the edited array list (shelter) on a newly created JSON file. 
 */
public void saveOntoFile() throws IOException{
	Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	String saveName = "src/main/resources/"+ time+ "pets.json";
	List<PetJson> petJsonList =new ArrayList<>();
	for(Pet pet : pets) {
		PetJson petJson = new PetJson();
		 petJson.id = pet.getID();
         petJson.name = pet.getName();
         petJson.type = pet.getType();
         petJson.species = pet.getSpecies();
         petJson.age = pet.getAge();
         petJson.adopted = pet.isAdopted();
         petJsonList.add(petJson);
	} 
	try(FileWriter writer= new FileWriter(saveName)){
		gson.toJson(petJsonList, writer); 

	}
}
}
