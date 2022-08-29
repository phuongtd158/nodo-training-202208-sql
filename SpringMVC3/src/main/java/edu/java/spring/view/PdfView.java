package edu.java.spring.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.java.spring.model.JavaClazz;
import edu.java.spring.model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws DocumentException {
        JavaClazz clazz = (JavaClazz) model.get("clazzObj");
        PdfPTable pdfPTable = new PdfPTable(3);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        PdfPCell cell = new PdfPCell();

        pdfPTable.setWidthPercentage(100.0f);
        pdfPTable.setWidths(new float[]{2.0f, 3.0f, 1.5f});
        pdfPTable.setSpacingBefore(10);

        font.setColor(BaseColor.WHITE);

        cell.setBackgroundColor(BaseColor.CYAN);
        cell.setPadding(5);

        cell.setPhrase(new Phrase("ID", font));
        pdfPTable.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        pdfPTable.addCell(cell);

        cell.setPhrase(new Phrase("Age", font));
        pdfPTable.addCell(cell);

        pdfPTable.completeRow();

        for (Student student : clazz.getStudents()) {
            pdfPTable.addCell(String.valueOf(student.getId()));
            pdfPTable.addCell(String.valueOf(student.getName()));
            pdfPTable.addCell(String.valueOf(student.getAge()));

            pdfPTable.completeRow();
        }

        document.add(pdfPTable);
    }
}
