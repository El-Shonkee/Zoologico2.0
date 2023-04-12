/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 *
 * @author andrea.correaa1
 */

public class Animals {
    String name;
    String gender;

    String species;
    String zone;
    float weight;
    float age;
    private int animalID;

    private static Set<Integer> iDsGenerated = new HashSet<Integer>();
    private static Random randomGenerator = new Random();

    public Animals(String name,
                   String gender,
                   String species,
                   float age,
                   float weight,
                   String zone) {
        this.animalID = randomIdGenerator();
        this.name = name;
        this.gender = gender;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.zone = zone;
    }

    public Animals() {

    }
    public String getSpecies() {
        return species;
    }

    public String getZone() {
        return zone;
    }

    public int getAnimalID(){
        return animalID;
    }

    public void setAnimalID(int animalID){
        this.animalID = animalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    private static int randomIdGenerator() {
        int newId;
        do {
            newId = randomGenerator.nextInt(1000000);
        } while (iDsGenerated.contains(newId));
        iDsGenerated.add(newId);
        return newId;
    }

    @Override
    public String toString(){
        return "Animal ID= "+animalID + " " +
               "Name="+ name + " " +
               "Gender="+ gender + " " +
               "Specie="+ species + " " +
               "Age="+ age + " " +
               "Weight="+ weight + " " +
               "Zone="+ zone;
    }

}

