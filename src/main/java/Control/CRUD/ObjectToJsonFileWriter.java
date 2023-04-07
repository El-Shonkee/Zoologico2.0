package Control.CRUD;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;



public class ObjectToJsonFileWriter {
    public static <T> void saveInFile(T object, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}