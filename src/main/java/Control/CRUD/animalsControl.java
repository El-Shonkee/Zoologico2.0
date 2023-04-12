package Control.CRUD;

import Model.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;


public class animalsControl {

    public static ArrayList<Animals> animalsArrayList;
    public static ArrayList<Integer> animalsIDs;

    public animalsControl() {
        animalsArrayList = new ArrayList<>();
        animalsIDs = new ArrayList<>();
    }

    public static void addAnimal(Animals animal) {
        animalsArrayList.add(animal);
        animalsIDs.add(animal.getAnimalID());
    }

    public static ArrayList<Animals> getAnimalsArrayList() {
        return animalsArrayList;
    }

    public static void deleteAnimal(Animals animal){
        animalsArrayList.remove(animal);
    }

    public static Animals searchAnimal(int ID){
        for(Animals animal: animalsArrayList){
            if(animal.getAnimalID() == ID){
                return animal;
            }
        }
        return null;
    }

    public static boolean modifyAnimal(Path filePath,int currentAnimalID, String name, String gender, String species, float age, float weight, String zone ) throws IOException {
        // Leer el archivo JSON como una cadena
        String jsonStr = Files.readString(filePath, StandardCharsets.UTF_8);

        // Parsear la cadena JSON a un array de objetos Plans
        Gson gson = new Gson();
        Animals[] animalsArr = gson.fromJson(jsonStr, Animals[].class);

        for (Animals animal : animalsArr) {
            if (animal.getAnimalID() == currentAnimalID) {
                animal.setAnimalID(currentAnimalID);
                animal.setAge(age);
                animal.setGender(gender);
                animal.setWeight(weight);
                animal.setZone(zone);
                animal.setSpecies(species);
            }
        }
        String updatedJsonStr = gson.toJson(animalsArr);
        Files.writeString(filePath, updatedJsonStr, StandardCharsets.UTF_8);

        return true;
    }

    public static void loadAnimalsFromJSON(Path filePath) throws IOException {
        // Leer el archivo JSON como una cadena
        String jsonStr = Files.readString(filePath, StandardCharsets.UTF_8);

        // Parsear la cadena JSON a un array de objetos Plans
        Gson gson = new Gson();
        Animals[] animalsArr = gson.fromJson(jsonStr, Animals[].class);

        // Actualizar la lista de planes en memoria
        animalsArrayList = new ArrayList<>(Arrays.asList(animalsArr));
        animalsIDs = new ArrayList<>();
        for (Animals animal : animalsArrayList) {
            animalsIDs.add(animal.getAnimalID());
        }
    }

    @Override
    public String toString() {
        return "animalsControl{"+animalsArrayList +"}";
    }

    public static void updateAnimalIDs() {
        animalsIDs.clear();
        for (Animals a : animalsArrayList) {
            animalsIDs.add(a.getAnimalID());
        }
    }


}
