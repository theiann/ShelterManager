package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.FileReader;

public class Manager {

private String PETS_FILE = "src/main/resources/pets.json";
private String EXOTICANIMALS_FILE = "src/main/resources/exotic_animals.json";

private Gson gson = new GsonBuilder().setPrettyPrinting().create(); 

public List<Pet> loadPets() throws IOException{
	List<Pet> allPets = new ArrayList<>(); 
	try(Reader reader = new FileReader(PETS_FILE)){
		List<PetJson> petJsonList = gson.fromJson(reader, new TypeToken<List<PetJson>>(){}.getType());
		for(PetJson petJson : petJsonList) {
			Pet pet = null;
			switch(petJson.type) {
			case "Cat":
				pet = new Cat(petJson.id, petJson.name,petJson.type, petJson.species, petJson.age);
				break;
			case "Dog":
				pet = new Dog(petJson.id, petJson.name,petJson.type, petJson.species, petJson.age);
				break;
			case "Rabbit":
				pet = new Rabbit(petJson.id, petJson.name,petJson.type, petJson.species, petJson.age);
				break;
			}
			if(pet != null) {
				pet.setAdopted(petJson.adopted);
				allPets.add(pet);
			}
		}
	}
	return allPets; 
}







}
