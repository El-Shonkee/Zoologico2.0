package Control.CRUD;

import Model.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class plansControl{

    public static ArrayList<Plans> plansArrayList;
    public static ArrayList<String> planNames;

    public plansControl() {
        plansArrayList = new ArrayList<>();
        planNames = new ArrayList<>();
    }

    public static void addPlan(Plans plan) {
        plansArrayList.add(plan);
        planNames.add(plan.getNamePlan());
    }

    public static ArrayList<Plans> getPlansArrayList() {
        return plansArrayList;
    }

    public static void removePlan(Plans plan){
        plansArrayList.remove(plan);
    }

    public static Plans searchPlan(String name){
        for(Plans plan: plansArrayList){
            if(plan.getNamePlan().equals(name)){
                return plan;
            }
        }
        return null;
    }

    public static boolean modifyPlan(Path filePath, String currentNamePlan, String newNamePlan, String descriptionPlan, String days, String hours, int pricePlan, int accountingPeople, String souvenir) throws IOException {
        // Leer el archivo JSON como una cadena
        String jsonStr = Files.readString(filePath, StandardCharsets.UTF_8);

        // Parsear la cadena JSON a un array de objetos Plans
        Gson gson = new Gson();
        Plans[] plansArr = gson.fromJson(jsonStr, Plans[].class);

        // Actualizar los datos del plan
        for (Plans plan : plansArr) {
            if (plan.getNamePlan().equals(currentNamePlan)) {
                plan.setNamePlan(newNamePlan);
                plan.setDescriptionPlan(descriptionPlan);
                plan.setDays(days);
                plan.setHours(hours);
                plan.setPricePlan(pricePlan);
                plan.setAccountingPeople(accountingPeople);
                plan.setSouvenir(souvenir);
            }
        }

        // Convertir el array actualizado a una cadena JSON y escribirlo en el archivo
        String updatedJsonStr = gson.toJson(plansArr);
        Files.writeString(filePath, updatedJsonStr, StandardCharsets.UTF_8);

        return true;
    }

    public static void loadPlansFromJSON(Path filePath) throws IOException {
        // Leer el archivo JSON como una cadena
        String jsonStr = Files.readString(filePath, StandardCharsets.UTF_8);

        // Parsear la cadena JSON a un array de objetos Plans
        Gson gson = new Gson();
        Plans[] plansArr = gson.fromJson(jsonStr, Plans[].class);

        // Actualizar la lista de planes en memoria
        plansArrayList = new ArrayList<>(Arrays.asList(plansArr));
        planNames = new ArrayList<>();
        for (Plans plan : plansArrayList) {
            planNames.add(plan.getNamePlan());
        }
    }

    @Override
    public String toString() {
        return "plansControl{" +
                "usersArrayList=" + plansArrayList +
                '}';
    }

    public static void updatePlanNames() {
        planNames.clear();
        for (Plans p : plansArrayList) {
            planNames.add(p.getNamePlan());
        }
    }

}
