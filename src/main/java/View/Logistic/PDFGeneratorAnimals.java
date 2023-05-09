package View.Logistic;

import Model.Animals;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PDFGeneratorAnimals {

    public static void generatePDFReport(ArrayList<Animals> animalsList) throws  DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\Reports\\Animals-Report.pdf"));
        document.open();
        PdfContentByte canvas = writer.getDirectContent();

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        Image image = null;
        try {
            image = Image.getInstance("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\src\\main\\java\\View\\img\\header.png");
            image.setAlignment(Element.ALIGN_LEFT);
            image.scaleToFit(PageSize.A4.getWidth(), 200);
            image.setAbsolutePosition(0, PageSize.A4.getHeight() - image.getScaledHeight());
            image.scaleAbsoluteWidth(PageSize.A4.getWidth());
            document.add(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PdfPTable table = new PdfPTable(7);
        Font font = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL);

        table.setTotalWidth(PageSize.A4.getWidth() - 15);
        table.setLockedWidth(true);
        // Definimos el ancho de cada columna
        table.setWidths(new float[] { 2, 2, 2, 2, 2, 2, 2});

        int totalAnimals = animalsList.size();

        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add("Animals report");
        document.add(title);
        document.add(new Paragraph(" "));

        PdfPTable summaryTable = new PdfPTable(2);
        summaryTable.setTotalWidth(PageSize.A4.getWidth() - 15);
        summaryTable.setLockedWidth(true);
        summaryTable.setWidths(new float[] { 1, 1 });

        document.add(new Paragraph(" "));

        table.addCell(new PdfPCell(new Phrase("Animal ID")));
        table.addCell(new PdfPCell(new Phrase("name")));
        table.addCell(new PdfPCell(new Phrase("Gender")));
        table.addCell(new PdfPCell(new Phrase("Specie")));
        table.addCell(new PdfPCell(new Phrase("Age")));
        table.addCell(new PdfPCell(new Phrase("Weight")));
        table.addCell(new PdfPCell(new Phrase("Zone")));

        for(Animals animal : animalsList){
            table.addCell(new PdfPCell(new Phrase(String.valueOf(animal.getAnimalID()),font)));
            table.addCell(new PdfPCell(new Phrase(animal.getName(),font)));
            table.addCell(new PdfPCell(new Phrase(animal.getGender(),font)));
            table.addCell(new PdfPCell(new Phrase(animal.getSpecies(),font)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(animal.getAge()),font)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(animal.getWeight()),font)));
            table.addCell(new PdfPCell(new Phrase(animal.getZone(),font)));
        }

        document.add(table);
        document.close();





    }
}
