/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DAO.*;
import Connection.MyConnection;
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
        String requete = "DELETE FROM pediatres WHERE login = ?";
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
        String requete = "SELECT * FROM pediatres WHERE isAccepted = 0 ORDER BY login";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Pediatre pediatre = new Pediatre();
                Date sqlDate = resultat.getDate(7);
                
                pediatre.setLogin(resultat.getString(1));
                pediatre.setCin(resultat.getInt(2));
                pediatre.setNom(resultat.getString(3));
                pediatre.setPrenom(resultat.getString(4));
                pediatre.setEmail(resultat.getString(5));
                pediatre.setPwd(resultat.getString(6));
                pediatre.setDateDeNaissance(new java.util.Date(sqlDate.getTime()));
                pediatre.setNationalite(resultat.getString(8));
                pediatre.setSexe(resultat.getBoolean(9));
                pediatre.setDoc(resultat.getString(10));
                
                listePediatres.add(pediatre);
            }
            return listePediatres;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des pediatres. " + ex.getMessage());
            return null;
        }
    }
}
