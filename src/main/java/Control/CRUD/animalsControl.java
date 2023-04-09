package Control.CRUD;

import Model.*;
import java.util.ArrayList;


public class animalsControl {

    public static ArrayList<Animals> animalsArrayList;
    public static ArrayList<String> animalsNames;

    public animalsControl() {
        animalsArrayList = new ArrayList<>();
        animalsNames = new ArrayList<>();
    }

    public static void addAnimal(Animals animal) {
        animalsArrayList.add(animal);
        animalsNames.add(animal.getName());
    }

    public void deleteAnimal(Animals animal){
        animalsArrayList.remove(animal);
    }

    public static Animals searchAnimal(String name){
        for(Animals animal: animalsArrayList){
            if(animal.getName().equals(name)){
                return animal;
            }
        }
        return null;
    }

    public boolean modifyAnimal(String name, String type, String species, float age, float weight, int quantity, int zone ){
        Animals animalModified = searchAnimal(name);

        if(animalModified != null){
            animalModified.setName(name);
            animalModified.setType(type);
            animalModified.setSpecies(species);
            animalModified.setAge(age);
            animalModified.setWeight(weight);
            animalModified.setQuantity(quantity);
            animalModified.setZone(zone);
            return true;
        }
        return false;
    }

}
