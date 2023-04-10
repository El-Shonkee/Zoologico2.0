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

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Plans[] planes = objectMapper.readValue(new File("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Plans.json"), Plans[].class);
            for (Plans p : planes) {
                plansControl.addPlan(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}