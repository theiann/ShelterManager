package model;

public abstract class Pet implements Comparable<Pet>{
private int id;
private String name;
private String type;
private String species;
private int age; 
private boolean adopted; 

public Pet(int id, String name, String type, String species, int age) {
	this.id = id;
	this.name = name;
	this.type = type;
	this.species = species; 
	this.age=age;
	this.adopted= false;
}

public void setID(int id) {
	this.id = id;
}

public int getID() {
	return id; 
}

public void setName(String name) {
	this.name = name;
}

public String getName() {
	return name; 
}

public void setType(String type) {
	this.type = type;
}

public String getType() {
	return type;
}

public void setSpecies(String species){
	this.species = species;
}

public String getSpecies() {
	return species;
}

public void setAge(int age) {
	this.age = age;
}

public int getAge() {
	return age; 
}

public boolean isAdopted() {
	return adopted;
}

public void setAdopted(boolean adopted) {
	this.adopted = adopted; 
}

}
