package model;

public class ExoticAdapter extends Pet{
private ExoticAnimal exoticAnimal;  

public ExoticAdapter(ExoticAnimal exoticAnimal) {
	super(Integer.parseInt(exoticAnimal.getUniqueId().substring(3)), exoticAnimal.getAnimalName(),exoticAnimal.getCategory(), exoticAnimal.getSubSpecies(), exoticAnimal.getYearsOld());
	this.exoticAnimal = exoticAnimal; 
}

public ExoticAnimal getExoticAnimal() {
	return exoticAnimal;
}
}

