/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author andrea.correaa1
 */
public class Animals {
    String name, type, species;
    float age, weight;
    int quantity,zone;
    public Animals(String name, String type, String species, float age, float weight, int quantity, int zone) {
        this.name = name;
        this.type = type;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.quantity = quantity;
        this.zone = zone;
    }

    public Animals(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSpecies() {
        return species;
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getAge() {
        return age;
    }
    public void setAge(float age) {
        this.age = age;
    }
    public int getZone() {
        return zone;
    }
    public void setZone(int zone) {
        this.zone = zone;
    }
}

