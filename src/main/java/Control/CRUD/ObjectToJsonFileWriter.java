//Clase que permite la lectura y creacion de las clases mediante archivos JSON
//El codigo fue creado con la ayuda de chatGPT
package Control.CRUD;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ObjectToJsonFileWriter {
    public static <T> void saveInFile(T object, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public static <T> void appendToFile(T object, String fileName) {
       try {

           String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));

           // Si el archivo ya contiene datos, agregar una coma separadora
           if (fileContent.trim().endsWith("]")) {
               fileContent = fileContent.trim().substring(0, fileContent.trim().length() - 1) + ",";
           } else if (fileContent.trim().isEmpty()) { // Si el archivo está vacío, agregar el corchete de apertura
               fileContent = "[";
           }

           // Convertir el objeto a JSON y agregarlo a la cadena
           Gson gson = new GsonBuilder().setPrettyPrinting().create();
           String json = gson.toJson(object);
           fileContent += json;

           // Agregar el corchete de cierre y escribir la cadena en el archivo
           fileContent += "]";
           Files.write(Paths.get(fileName), fileContent.getBytes(), StandardOpenOption.WRITE);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}