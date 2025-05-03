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


public T findPetByNameAndSpecies(String name, String type) {
	 for (T pet : pets) {
         if(pet.getName().equalsIgnoreCase(name) && pet.getSpecies().equalsIgnoreCase(type)) {
             return pet;
         }  
	}
	return null;
}

public boolean adoptPet(T pet) {
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
