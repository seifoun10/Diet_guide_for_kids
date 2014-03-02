/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.MyConnection;
import entities.Pediatre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Statement;

/**
 *
 * @author Killer
 */
public class PediatreDAO {
    
    public static void acceptPediatre(String login){
        String requete = "UPDATE pediatres SET isAccepted = true WHERE login = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("Pédiatre accepté.");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification. "+ex.getMessage());
        }
    }
    
    public static void deletePediatre(String login){
        String requete = "DELETE FROM users WHERE login = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("Pédiatre supprimé.");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression. "+ex.getMessage());
        }
    }
    
    public static List<Pediatre> displayAllInacceptedPediatres (){
        List<Pediatre> listePediatres = new ArrayList<Pediatre>();
        String requete = "SELECT * FROM users, pediatres WHERE pediatres.isAccepted = 0 AND users.login = pediatres.login ORDER BY users.login";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Pediatre pediatre = new Pediatre();
                
                pediatre.setLogin(resultat.getString("Login"));
                pediatre.setCin(resultat.getInt("CIN"));
                pediatre.setNom(resultat.getString("Nom"));
                pediatre.setPrenom(resultat.getString("Prenom"));
                pediatre.setEmail(resultat.getString("Email"));
                pediatre.setPwd(resultat.getString("pwd"));
                pediatre.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                pediatre.setDateInscription(resultat.getDate("Date_Inscription"));
                pediatre.setNationalite(resultat.getString("Nationalite"));
                pediatre.setSexe(resultat.getBoolean("Sexe"));
                pediatre.setDoc(resultat.getString("Doc"));
                
                listePediatres.add(pediatre);
            }
            return listePediatres;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des pediatres. " + ex.getMessage());
            return null;
        }
    }
}
