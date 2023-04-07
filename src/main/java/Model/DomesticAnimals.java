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
public class DomesticAnimals extends Animals {
    String color;

    public DomesticAnimals(String name, String type, String species, float age, float weight, int quantity, int zone, String color) {
        super(name, type, species, age, weight, quantity, zone);
        this.color = color;
    }

    public DomesticAnimals(){}
}
