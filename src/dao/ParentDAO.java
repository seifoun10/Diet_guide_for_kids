/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Parent;
import entities.User;
import util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tictacf12
 */
public class ParentDAO {
    public Parent findUserByString(String login){
     Parent parent = new Parent();
     String requete = "select * from PARENT where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                parent.setLogin(resultat.getString("Login"));
                parent.setNom(resultat.getString("Nom"));
                parent.setPrenom(resultat.getString("Prenom"));
                parent.setEmail(resultat.getString("Email"));
                parent.setSexe(resultat.getBoolean("Sexe"));
                parent.setDateInscription(resultat.getDate("Date_Inscription"));
                parent.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                parent.setNationalite(resultat.getString("Nationalite"));
                parent.setTravail(resultat.getString("Travail"));
                
            }
            return depot;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
    
}
