package Control.CRUD;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ObjectToFileWriter{

    public static void saveInDocument(Object objeto, String archiveName) {
        try {
            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(archiveName));
            document.open();

            // Crear un párrafo y agregar el objeto como texto
            Paragraph paragraph = new Paragraph(objeto.toString());
            document.add(paragraph);

            // Cerrar el documento
            document.close();

            // Escribir el contenido del archivo en formato UTF-8
            FileOutputStream fos = new FileOutputStream(archiveName);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(objeto.toString());
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}