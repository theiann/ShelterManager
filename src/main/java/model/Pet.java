package model;

/*
 * Abstract class that represents a pet in the shelter
 */
public abstract class Pet implements Comparable<Pet>{
private int id;
private String name;
private String type;
private String species;
private int age; 
private boolean adopted; 

/*
 * Constructor for pet
 */
public Pet(int id, String name, String type, String species, int age) {
	this.id = id;
	this.name = name;
	this.type = type;
	this.species = species; 
	this.age=age;
	this.adopted= false;
}

/*
 * sets the pet ID to passed value
 */
public void setID(int id) {
	this.id = id;
}

/*
 * gets the pet Id when this method is called
 */
public int getID() {
	return id; 
}

/*
 * sets the pet's name as the passed string
 */
public void setName(String name) {
	this.name = name;
}

/**
 * returns the pet's name when method called
 * @return 
 */
public String getName() {
	return name; 
}

/**
 * set's thepet's type to whatever string is passed
 * @param type
 */
public void setType(String type) {
	this.type = type;
}

/**
 * gets the pets type when this method is called
 * @return
 */
public String getType() {
	return type;
}

/**
 * sets the pet's species to whatever that was passed
 * @param species
 */
public void setSpecies(String species){
	this.species = species;
}

/**
 * returns the pet's species when method is called
 * @return
 */
public String getSpecies() {
	return species;
}
/**
 * sets the pet's age as the value that was passed
 * @param age
 */

public void setAge(int age) {
	this.age = age;
}

/**
 * returns the age of the pet
 * @return
 */
public int getAge() {
	return age; 
}

/**
 * method to check weather pet is adopted or not
 * @return
 */
public boolean isAdopted() {
	return adopted;
}

/*
 * sets a pet's adoption status
 */
public void setAdopted(boolean adopted) {
	this.adopted = adopted; 
}

/*
 * Everytime a new pet is created, sets their adoption status to false
 */
public Pet() {
	this.adopted = false; 
}

/*
 * adopts a pet if not already adopted, if was adopted already returns false otherise returns true
 */
public boolean adopt() {
	if(adopted != true) {
		this.adopted = true;
		return true;
	}
	return false; 
}

/*
 * for the comparison of name between pets
 */
public int compareTo(Pet other) {
	return this.name.compareTo(other.name);
}  

/*
 * string representation of the pet
 */
public String toString() {
	return name + ":" + type + "(" + species + ")" + age + "years old, " + (adopted? "Adoption status:" : "Available");
}

}
