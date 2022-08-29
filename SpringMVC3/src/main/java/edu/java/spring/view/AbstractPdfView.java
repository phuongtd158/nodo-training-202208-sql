package edu.java.spring.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

public abstract class AbstractPdfView extends AbstractView {

    public AbstractPdfView() {
        setContentType("application/pdf");
    }

    protected Document newDocument() {
        return new Document(PageSize.A4);
    }

    protected PdfWriter newWriter(Document document, OutputStream outputStream) throws DocumentException {
        return PdfWriter.getInstance(document, outputStream);
    }

    protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request) {
        writer.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences() {
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ByteArrayOutputStream byteOutput = createTemporaryOutputStream();
        Document document = newDocument();
        PdfWriter pdfWriter = newWriter(document, byteOutput);
        prepareWriter(model, pdfWriter, httpServletRequest);

        document.open();
        buildPdfDocument(model, document, pdfWriter, httpServletRequest, httpServletResponse);
        document.close();

        writeToResponse(httpServletResponse, byteOutput);
    }

    protected abstract void buildPdfDocument(Map<String, Object> model,
                                             Document document,
                                             PdfWriter writer,
                                             HttpServletRequest request,
                                             HttpServletResponse response) throws DocumentException;
}
