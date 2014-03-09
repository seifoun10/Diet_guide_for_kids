/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.AdministrateurForum;
import entities.Administrateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.MyConnection;

/**
 *
 * @author tictacf12
 */
public class AdminForumDAO {

    public AdministrateurForum findAdminForumByString(String login) {
        AdministrateurForum adminF = new AdministrateurForum();
        String requete = "select * from admin_forum af, users u where af.login=? and u.login=af.login";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next())
            {
                adminF.setLogin(resultat.getString("Login"));
                adminF.setNom(resultat.getString("Nom"));
                adminF.setPrenom(resultat.getString("Prenom"));
                adminF.setEmail(resultat.getString("Email"));
                adminF.setSexe(resultat.getBoolean("Sexe"));
                adminF.setDateInscription(resultat.getDate("Date_Inscription"));
                adminF.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                adminF.setNationalite(resultat.getString("Nationalite"));
                
            }
            return adminF;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du parent "+ex.getMessage());
            return null;
        }
    }
    
}
