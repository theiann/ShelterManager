package model;

/*
 * representation of Cat in the shelter
 * constructor for Cat using super, so method from pet.java is used
 */
public class Cat extends Pet{
	public Cat(int id, String name, String type, String species, int age) {
		super(id,name,"Cat", species,age);
	}
}
