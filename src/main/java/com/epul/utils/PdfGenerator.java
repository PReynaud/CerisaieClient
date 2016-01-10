package com.epul.utils;

import com.epul.metier.Activite;
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
        Font fontNormalGras = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);


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

        document.add(Chunk.NEWLINE);


        PdfPTable detailSejour = new PdfPTable(2);
        detailSejour.setWidthPercentage(50.0f);
        detailSejour.setWidths(new float[]{3.0f, 2.0f});

        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase("Numéro de séjour : ", fontNormalGras));
        detailSejour.addCell(cell);
        detailSejour.addCell(Integer.toString(facture.getSejourClient().getNumSej()));

        cell.setPhrase(new Phrase("Numéro d’emplacement : ", fontNormalGras));
        detailSejour.addCell(cell);
        detailSejour.addCell(Integer.toString(facture.getSejourClient().getNumEmpl()));

        cell.setPhrase(new Phrase("Type d’emplacement : ", fontNormalGras));
        detailSejour.addCell(cell);
        detailSejour.addCell(facture.getTypeEmplacement().getLibtypepl());

        detailSejour.setHorizontalAlignment(Element.ALIGN_LEFT);
        document.add(detailSejour);

        document.add(Chunk.NEWLINE);

        PdfPTable detailClient = new PdfPTable(1);
        detailClient.setWidthPercentage(50.0f);
        cell.setPhrase(new Phrase("Numéro du client : " + facture.getSejourClient().getClient().getNumCli() + "\n"
                                     + facture.getSejourClient().getClient().getNomCli() + "\n"
                                     + facture.getSejourClient().getClient().getAdrRueCli() + "\n"
                                     + facture.getSejourClient().getClient().getCpCli() + " "
                                     + facture.getSejourClient().getClient().getVilleCli() + "\n"
                , fontNormal));
        detailClient.addCell(cell);
        detailClient.setHorizontalAlignment(Element.ALIGN_RIGHT);

        document.add(detailClient);

        document.add(Chunk.NEWLINE);

        document.add(new Paragraph("Sejour : ", fontTitre));

        PdfPTable detailSejourBis = new PdfPTable(4);
        detailSejourBis.setWidthPercentage(100.0f);
        detailSejourBis.setWidths(new float[]{25.0f, 25.0f, 25.0f, 25.0f});
        detailSejourBis.setSpacingBefore(10);

        cell.setPhrase(new Phrase("Date de début : ", fontNormalGras));
        detailSejourBis.addCell(cell);
        cell.setPhrase(new Phrase("Date de fin : ", fontNormalGras));
        detailSejourBis.addCell(cell);
        cell.setPhrase(new Phrase("Nombre de personnes : ", fontNormalGras));
        detailSejourBis.addCell(cell);
        cell.setPhrase(new Phrase("Prix/jour/personne : ", fontNormalGras));
        detailSejourBis.addCell(cell);

        detailSejourBis.addCell(facture.getSejourClient().getDatedebSej());
        detailSejourBis.addCell(facture.getSejourClient().getDateFinSej());
        detailSejourBis.addCell(Integer.toString(facture.getSejourClient().getNbPersonnes()));
        detailSejourBis.addCell(Float.toString(facture.getTypeEmplacement().getTariftypepl()));

        cell.setPhrase(new Phrase());
        cell.setBorder(0);
        detailSejourBis.addCell(cell);
        detailSejourBis.addCell(cell);
        cell.setPhrase(new Phrase("Total Séjour : ", fontNormalGras));
        cell.setBorder(Rectangle.BOX);
        detailSejourBis.addCell(cell);
        detailSejourBis.addCell(Float.toString(facture.getPrixSejour()));

        detailSejourBis.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(detailSejourBis);

        document.add(Chunk.NEWLINE);

        if(facture.getActiviteSport().size() != 0){
            document.add(new Paragraph("Prestations sportives : ", fontTitre));

            PdfPTable detailActivite = new PdfPTable(5);
            detailActivite.setWidthPercentage(100.0f);
            detailActivite.setWidths(new float[]{20.0f, 20.0f, 20.0f, 20.0f, 20.0f});

            detailActivite.setSpacingBefore(10);

            cell.setPhrase(new Phrase("Date", fontNormalGras));
            detailActivite.addCell(cell);
            cell.setPhrase(new Phrase("Nom du sport", fontNormalGras));
            detailActivite.addCell(cell);
            cell.setPhrase(new Phrase("Prix (unité)", fontNormalGras));
            detailActivite.addCell(cell);
            cell.setPhrase(new Phrase("Nombre d'unités", fontNormalGras));
            detailActivite.addCell(cell);
            cell.setPhrase(new Phrase("Montant", fontNormalGras));
            detailActivite.addCell(cell);

            for (Activite item: facture.getActiviteSport()) {
                detailActivite.addCell(item.getDateJour());
                detailActivite.addCell(item.getSport().getLibelleSport());
                detailActivite.addCell(Integer.toString(item.getSport().getTarifUnite()));
                detailActivite.addCell(Integer.toString(item.getNbloc()));
                detailActivite.addCell(Integer.toString(item.getSport().getTarifUnite() * item.getNbloc()));
            }

            cell.setPhrase(new Phrase());
            cell.setBorder(0);
            detailActivite.addCell(cell);
            detailActivite.addCell(cell);
            detailActivite.addCell(cell);

            cell.setPhrase(new Phrase("Total Activité : ", fontNormalGras));
            cell.setBorder(Rectangle.BOX);
            detailActivite.addCell(cell);
            detailActivite.addCell(Float.toString(facture.getPrixActivite()));

            detailActivite.setHorizontalAlignment(Element.ALIGN_CENTER);
            document.add(detailActivite);

            document.add(Chunk.NEWLINE);
        }

        PdfPTable total = new PdfPTable(2);
        cell.setPhrase(new Phrase("Total à payer : ", fontNormalGras));
        total.addCell(cell);
        total.addCell(Float.toString(facture.getPrix()));

        total.setWidthPercentage(40.0f);
        total.setHorizontalAlignment(Element.ALIGN_RIGHT);

        document.add(total);
    }
}