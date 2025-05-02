package model;

import java.util.Comparator;

public class AgeComparator implements Comparator<Pet>{
@Override 
public int compare(Pet pet1, Pet pet2) {
	return Integer.compare(pet1.getAge(), pet2.getAge());
}
}
