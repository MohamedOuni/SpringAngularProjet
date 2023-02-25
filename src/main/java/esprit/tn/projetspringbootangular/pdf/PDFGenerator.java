package esprit.tn.projetspringbootangular.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import esprit.tn.projetspringbootangular.Entities.Partnership;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PDFGenerator {

    // List to hold all Students
     List<Partnership> partnerships;

    public void generate(HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document
        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);

        // Creating paragraph
        Paragraph paragraph = new Paragraph("List Of Students", fontTiltle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        // Creating a table of 3 columns
        PdfPTable table = new PdfPTable(3);

        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 3, 3, 3 });
        table.setSpacingBefore(5);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.MAGENTA);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Section", font));
        table.addCell(cell);

        // Iterating over the list of students
        for (Partnership partnership : partnerships) {
            // Adding partnership id
            table.addCell(String.valueOf(partnership.getIdPartnership()));
            // Adding partnership representative name
            table.addCell(partnership.getRepresentative_Email());
            // Adding partnership representative email
            table.addCell(partnership.getRepresentative_Email());


        }
        // Adding the created table to document
        document.add(table);

        // Closing the document
        document.close();

    }
}
