package model;

import java.util.Comparator;
/*
 * Comparator for sorting pets by species
 */
public class SpeciesComparator implements Comparator<Pet>{
	@Override
    public int compare(Pet pet1, Pet pet2) {
        return pet1.getSpecies().compareToIgnoreCase(pet2.getSpecies());
    }
}
