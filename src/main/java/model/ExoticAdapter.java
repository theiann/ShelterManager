package model;
/*
 * adapter to make Exotic Animal compatible with Pet
 * This implements the adapter design pattern
 */
public class ExoticAdapter extends Pet{
private ExoticAnimal exoticAnimal;  
/*
 * Constructor to adapt Exotic animal to pet
 */
public ExoticAdapter(ExoticAnimal exoticAnimal) {
	super(Integer.parseInt(exoticAnimal.getUniqueId().substring(3)), exoticAnimal.getAnimalName(),exoticAnimal.getCategory(), exoticAnimal.getSubSpecies(), exoticAnimal.getYearsOld());
	this.exoticAnimal = exoticAnimal; 
}

/*
 * returns the underlying exotic animal 
 */
public ExoticAnimal getExoticAnimal() {
	return exoticAnimal;
}
}

