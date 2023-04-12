package View.Administrative;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Model.Sells;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static Control.CRUD.sellsControl.summarizeSellsByPlan;


public class PDFGeneratorSells {

    public static void generatePDFReport(ArrayList<Sells> sellsList) throws DocumentException, IOException {

        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\Reports\\Sells-Report.pdf"));
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

        // Creamos la tabla con 7 columnas
        PdfPTable table = new PdfPTable(11);
        Font font = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL);

        table.setTotalWidth(PageSize.A4.getWidth() - 15);
        table.setLockedWidth(true);
        // Definimos el ancho de cada columna
        table.setWidths(new float[] { 2, 2, 3, 2, 2, 2, 2,2,2,2,2});

        double totalPrice = 0;
        for (Sells sell : sellsList) {
            totalPrice += sell.getPrice();
        }

        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add("Sells report");
        document.add(title);
        document.add(new Paragraph(" "));

        // Agregamos la tabla de resumen de ventas
        PdfPTable summaryTable = new PdfPTable(2);
        summaryTable.setTotalWidth(PageSize.A4.getWidth() - 15);
        summaryTable.setLockedWidth(true);
        summaryTable.setWidths(new float[] { 1, 1 });

        summaryTable.addCell(new PdfPCell(new Phrase("Total sales:", new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD))));
        summaryTable.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", totalPrice), new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL))));
        document.add(summaryTable);

        HashMap<String, Integer> summary = summarizeSellsByPlan(sellsList);

    // Agregamos una línea en blanco y el título de la sección
        document.add(new Paragraph(" "));
        Paragraph title2 = new Paragraph();
        title2.setAlignment(Element.ALIGN_CENTER);
        title2.add("Sells summary by plan");
        document.add(title2);
        document.add(new Paragraph(" "));

    // Creamos una nueva tabla con 2 columnas
        PdfPTable table2 = new PdfPTable(2);
        table2.setWidthPercentage(50);
        table2.setHorizontalAlignment(Element.ALIGN_CENTER);

    // Agregamos las celdas del encabezado de la tabla
        table2.addCell(new PdfPCell(new Phrase("Plan name")));
        table2.addCell(new PdfPCell(new Phrase("Total sells")));

    // Iteramos sobre el mapa y agregamos las celdas a la tabla
        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            table2.addCell(new PdfPCell(new Phrase(entry.getKey())));
            table2.addCell(new PdfPCell(new Phrase(String.valueOf(entry.getValue()))));
        }
    // Agregamos la tabla al documento
        document.add(table2);

        document.add(new Paragraph(" "));

        // Agregamos las celdas del encabezado de la tabla
        table.addCell(new PdfPCell(new Phrase("Name")));
        table.addCell(new PdfPCell(new Phrase("ID")));
        table.addCell(new PdfPCell(new Phrase("Email")));
        table.addCell(new PdfPCell(new Phrase("Bill number")));
        table.addCell(new PdfPCell(new Phrase("Adults")));
        table.addCell(new PdfPCell(new Phrase("Children")));
        table.addCell(new PdfPCell(new Phrase("Price")));
        table.addCell(new PdfPCell(new Phrase("Plan Name")));
        table.addCell(new PdfPCell(new Phrase("Description")));
        table.addCell(new PdfPCell(new Phrase("Souvenir")));
        table.addCell(new PdfPCell(new Phrase("Date")));

        // Iteramos sobre la lista de planes y agregamos las celdas a la tabla
        for (Sells sell : sellsList) {
            table.addCell(new PdfPCell(new Phrase(sell.getUser().getName(),font)));
            table.addCell(new PdfPCell(new Phrase(sell.getUser().getId(),font)));
            table.addCell(new PdfPCell(new Phrase(sell.getUser().getEmail(),font)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(sell.getBillNumber()),font)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(sell.getAdults()),font)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(sell.getChildren()),font)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf("$ "+sell.getPrice()),font)));
            table.addCell(new PdfPCell(new Phrase(sell.getPlan().getNamePlan(),font)));
            table.addCell(new PdfPCell(new Phrase(sell.getPlan().getDescriptionPlan(),font)));
            table.addCell(new PdfPCell(new Phrase(sell.getPlan().getSouvenir(),font)));
            table.addCell(new PdfPCell(new Phrase(sell.getDate().toString(),font)));
        }

        // Agregamos la tabla al documento
        document.add(table);
        document.close();

    }
}
