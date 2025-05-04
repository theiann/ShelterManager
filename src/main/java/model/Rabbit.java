package model;
/*
 * representation of Rabbit in the shelter
 * constructor for Rabbit using super, so method from pet.java is used
 */
public class Rabbit extends Pet{
	public Rabbit(int id, String name, String type, String species, int age) {
		super(id,name,"Rabbit", species,age);
	}
}
