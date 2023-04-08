import Control.CRUD.*;

import View.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.*;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //Se inicializan los arrays que contendran la información de las clases
        plansControl plans = new plansControl();
        usersControl users = new usersControl();
        sellsControl sells = new sellsControl();
        animalsControl animals = new animalsControl();

        //Esto lee un archivo Json y crea un objeto de la clase especificada con los atributos que hay en dicho documento
        ObjectMapper mapperPlans = new ObjectMapper();
        Plans plan = mapperPlans.readValue(new File("Plans.json"), Plans.class);
        plansControl.addPlan(plan);

        ObjectMapper mapperAnimals = new ObjectMapper();
        Animals animal = mapperAnimals.readValue(new File("Animals.json"),Animals.class);
        animalsControl.addAnimal(animal);

        new Menu();
    }
}