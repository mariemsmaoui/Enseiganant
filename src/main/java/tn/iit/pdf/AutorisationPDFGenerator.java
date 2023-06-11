package tn.iit.pdf;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tn.iit.model.Enseignant;

public class AutorisationPDFGenerator {

    public static ByteArrayOutputStream generatePDF(Enseignant enseignant) {
        LocalDate currentDate = LocalDate.now();

        // Calculer le nombre de semaines restantes dans l'année courante
        int remainingWeeks = 52 - currentDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);

        // Calculer le nombre d'heures autorisées pour l'enseignant
        int heuresAutorisees = remainingWeeks * 4;
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


        try {
            // Spécifier le chemin du fichier PDF généré
            // Créer un écrivain PDF
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            // Ouvrir le document
            document.open();

            // Ajouter le contenu au document
            document.add(new Paragraph("Autorisation de l'enseignant"));
            document.add(new Paragraph("Nom : "+enseignant.getNom()));
            document.add(new Paragraph("Email : "+enseignant.getEmail()));
            document.add(new Paragraph("CIN : "+enseignant.getCin()));
            document.add(new Paragraph("Téléphone : "+enseignant.getTelephone()));
            document.add(new Paragraph("Heures autorisées : "+heuresAutorisees));

            document.close();
            return outputStream;
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

}