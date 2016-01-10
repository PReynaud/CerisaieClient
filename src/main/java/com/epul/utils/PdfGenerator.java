package com.epul.utils;

import com.epul.metier.Facture;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class PdfGenerator extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Facture facture = (Facture) model.get("facture");
        Font fontTitre = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font fontGrosTitre = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.UNDERLINE);
        Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN, 12);


        document.addTitle("Facture" + facture.getSejourClient().getNumSej());
        document.addKeywords("Facture, camping, Cerisaie");
        document.addAuthor("Cerisaie");
        document.addCreator("Cerisaie");

        Paragraph adresseCerisaie = new Paragraph();
        adresseCerisaie.add(new Paragraph("Cerisaie", fontTitre));
        adresseCerisaie.add(new Paragraph("Route de la plage", fontNormal));
        adresseCerisaie.add(new Paragraph("33121 - Carcans", fontNormal));
        adresseCerisaie.add(new Paragraph("Etoiles : **", fontNormal));
        adresseCerisaie.add(new Paragraph("Téléphone : 05-67-78-56-45", fontNormal));
        adresseCerisaie.add(new Paragraph("Fax : 05-67-78-34-25", fontNormal));

        document.add(adresseCerisaie);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        Paragraph titre = new Paragraph("Facturation du séjour " + facture.getSejourClient().getNumSej(), fontGrosTitre);
        titre.setAlignment(Element.ALIGN_CENTER);
        document.add(titre);

        document.add(Chunk.NEWLINE);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Paragraph facturationDate = new Paragraph("Date de facturation : " + dateFormat.format(date), fontNormal);
        facturationDate.setAlignment(Element.ALIGN_RIGHT);
        document.add(facturationDate);

        PdfPTable detailSejour = new PdfPTable(2);
        detailSejour.setWidthPercentage(50.0f);
        detailSejour.setWidths(new float[]{3.0f, 2.0f});

        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase("Numéro de séjour : ", fontNormal));
        detailSejour.addCell(cell);
        detailSejour.addCell(Integer.toString(facture.getSejourClient().getNumSej()));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Book Title", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Author", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("ISBN", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Published Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);

        document.add(table);
    }
}