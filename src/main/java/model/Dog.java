package model;
/*
 * representation of dog in the shelter
 * constructor for Dog using super, so method from pet.java is used
 */
public class Dog extends Pet{

	public Dog(int id, String name, String type, String species, int age) {
		super(id,name,"Dog", species,age);
	}
	
}
