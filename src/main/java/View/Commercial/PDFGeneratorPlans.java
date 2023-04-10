package View.Commercial;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import Model.Plans;
import com.itextpdf.text.Font;


public class PDFGeneratorPlans {

    public static void generatePDFReport(ArrayList<Plans> plansList) throws DocumentException, IOException {

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\Reports\\PlansReport.pdf"));
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

// Agregamos el título
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add("Plans that we offer");
        document.add(title);

        // Creamos la tabla con 9 columnas
        PdfPTable table = new PdfPTable(9);
        Font font = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL);

        table.setTotalWidth(PageSize.A4.getWidth() - 15);
        table.setLockedWidth(true);
        // Definimos el ancho de cada columna
        table.setWidths(new float[] { 2, 2, 3, 2, 2, 2, 2, 2, 1 });

        // Agregamos las celdas del encabezado de la tabla
        table.addCell(new PdfPCell(new Phrase("Plan ID")));
        table.addCell(new PdfPCell(new Phrase("Plan Name")));
        table.addCell(new PdfPCell(new Phrase("Description")));
        table.addCell(new PdfPCell(new Phrase("Days")));
        table.addCell(new PdfPCell(new Phrase("Hours")));
        table.addCell(new PdfPCell(new Phrase("Price")));
        table.addCell(new PdfPCell(new Phrase("People")));
        table.addCell(new PdfPCell(new Phrase("Souvenir")));
        table.addCell(new PdfPCell(new Phrase("Children")));

        // Iteramos sobre la lista de planes y agregamos las celdas a la tabla
        for (Plans plan : plansList) {
            table.addCell(new PdfPCell(new Phrase(Integer.toString(plan.getIdPlan()),font)));
            table.addCell(new PdfPCell(new Phrase(plan.getNamePlan(),font)));
            table.addCell(new PdfPCell(new Phrase(plan.getDescriptionPlan(),font)));
            table.addCell(new PdfPCell(new Phrase(plan.getDays(),font)));
            table.addCell(new PdfPCell(new Phrase(plan.getHours(),font)));
            table.addCell(new PdfPCell(new Phrase(Double.toString(plan.getPricePlan()),font)));
            table.addCell(new PdfPCell(new Phrase(Integer.toString(plan.getAccountingPeople()),font)));
            table.addCell(new PdfPCell(new Phrase(plan.getSouvenir(),font)));
            table.addCell(new PdfPCell(new Phrase(Boolean.toString(plan.isChildren()),font)));
        }

        // Agregamos la tabla al documento
        document.add(table);
        document.close();

    }
}
