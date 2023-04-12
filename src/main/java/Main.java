import Control.CRUD.*;

import View.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.*;
import java.io.File;
import java.io.IOException;
import Control.CRUD.plansControl;

public class Main {
    public static void main(String[] args) throws IOException {
        //Se inicializan los arrays que contendran la información de las clases
        plansControl plans = new plansControl();
        usersControl users = new usersControl();
        sellsControl sells = new sellsControl();
        animalsControl animals = new animalsControl();
        new Menu();

        ObjectMapper objectMapperPlans = new ObjectMapper();
        ObjectMapper objectMapperAnimals = new ObjectMapper();
        try {
            Plans[] planes = objectMapperPlans.readValue(new File("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Plans.json"), Plans[].class);

            Animals[] animal = objectMapperAnimals.readValue(new File("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Animals.json"), Animals[].class);
            for (Plans p : planes) {
                plansControl.addPlan(p);
            }

            for (Animals a : animal) {
                animalsControl.addAnimal(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}