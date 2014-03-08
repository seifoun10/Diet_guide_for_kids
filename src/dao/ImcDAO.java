/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.MyConnection;

/**
 *
 * @author Killer
 */
public class ImcDAO {
    public static float getLastIMC(int idEnfant) {

        float poids = 0, taille = 0;
        String requete = "SELECT poids, taille FROM imc WHERE enfant = ? ORDER BY date_de_mesurage DESC";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, idEnfant);
            ResultSet resultat = ps.executeQuery();
            
            resultat.next();
            poids = resultat.getFloat("poids");
            taille = resultat.getFloat("taille");
            
            return poids / (taille * taille);
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche de l\'imc | "+ex.getMessage());
            return 0;
        }
    }
    
    public static float getFirstIMC(int idEnfant) {

        float poids = 0, taille = 0;
        String requete = "SELECT poids, taille FROM imc WHERE enfant = ? ORDER BY date_de_mesurage ASC";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, idEnfant);
            ResultSet resultat = ps.executeQuery();
            
            resultat.next();
            poids = resultat.getFloat("poids");
            taille = resultat.getFloat("taille");
            
            return poids / (taille * taille);
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche de l\'imc | "+ex.getMessage());
            return 0;
        }
    }
}
