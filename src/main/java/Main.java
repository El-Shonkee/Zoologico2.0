import Control.CRUD.*;

import View.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //Se inicializan los arrays que contendran la información de las clases
        plansControl plans = new plansControl();
        usersControl users = new usersControl();
        sellsControl sells = new sellsControl();
        animalsControl animals = new animalsControl();

      /*  //Esto lee un archivo Json y crea un objeto de la clase especificada con los atributos que hay en dicho documento
        ObjectMapper mapperPlans = new ObjectMapper();
        Plans plan = mapperPlans.readValue(new File("Plans.json"), Plans.class);
        plansControl.addPlan(plan);*/

        /*ObjectMapper mapperAnimals = new ObjectMapper();
        Animals animal = mapperAnimals.readValue(new File("Animals.json"),Animals.class);
        animalsControl.addAnimal(animal);*/

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Plans[] planes = objectMapper.readValue(new File("Plans.json"), Plans[].class);
            for (Plans p : planes) {
                plansControl.addPlan(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Menu();
    }
}