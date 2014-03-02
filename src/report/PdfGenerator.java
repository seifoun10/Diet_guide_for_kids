/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import util.MyConnection;

/**
 *
 * @author Killer
 */
public class PdfGenerator {
    public void generatePDF() {
        // - Paramètres de connexion à la base de données
        Connection connection;
        try {
            // - Connexion à la base
            connection = MyConnection.getInstance();
            // - Chargement et compilation du rapport (charger le fichier jrxml déjà généré)
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\users\\killer\\desktop\\TraitementsPediatres.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\users\\killer\\desktop\\Traitements_Pediatres_"
                    + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "_"
                    + Calendar.getInstance().get(Calendar.MONTH) + "_"
                    + Calendar.getInstance().get(Calendar.YEAR) + "_"
                    + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + "h"
                    + Calendar.getInstance().get(Calendar.MINUTE)
                    + ".pdf");
            System.out.println("Rapport créé avec succès");
        }

        catch (JRException e) {
            System.out.println("Erreur de compilation. "+ e.getMessage());
        } 
    }
}
