package model;
/*
 * this is mainly used for the adapter from exotic to normal Pet, nowhere else
 */
public class ExoticAnimal {
	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    /*
     * Constructor for ExoticAnimal that has different structure from normal PET
     */
    public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
        this.uniqueId = uniqueId;
        this.animalName =animalName;
        this.category =category;
        this.subSpecies =subSpecies;
        this.yearsOld = yearsOld;
    }

    /*
     * Getters and Setters for ExoticAnimal 
     */
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId =uniqueId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName =animalName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category =category;
    }

    public String getSubSpecies() {
        return subSpecies;
    }

    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
