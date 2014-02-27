/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Parent;
import entities.User;
import util.MyConnection;
import java.sql.Date;
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
public class UserDAO {
    
    public List<User> getUserList(String login, String nom, String prenom, String email, String nationalite, Date dateInscription, Date dateNaissance, Boolean sexe){
        
        List<User> listUser = new ArrayList<User>();
        
        String requete = "SELECT * FROM users WHERE Login LIKE ? AND Nom LIKE ? AND Prenom LIKE ? AND Email LIKE ? AND Nationalite LIKE ? AND Date_Inscription LIKE ? AND Date_De_Naissance LIKE ? AND Sexe LIKE ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login+"%");
            ps.setString(2, nom+"%");
            ps.setString(3, prenom+"%");
            ps.setString(4, email+"%");
            ps.setString(5, nationalite+"%");
            if(dateInscription!=null)ps.setString(6, dateInscription+"%"); else ps.setString(6,"%");
            if(dateNaissance!=null)ps.setString(7, dateNaissance+"%");else ps.setString(7,"%");
            if(sexe==null)ps.setString(8,"%");else if(sexe.booleanValue()) ps.setString(8,"1"); else ps.setString(8,"0");
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                User user =new User();
                user.setLogin(resultat.getString("Login"));
                user.setPwd(resultat.getString("pwd"));
                user.setNom(resultat.getString("Nom"));
                user.setPrenom(resultat.getString("Prenom"));
                user.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                if(resultat.getString(6).equals("Homme")) user.setSexe(true); else user.setSexe(false);
                user.setEmail(resultat.getString("Email"));
                user.setNationalite(resultat.getString("Nationalite"));
                user.setDateInscription(resultat.getDate("Date_Inscription"));
                listUser.add(user);
            }
            return listUser;
        }catch (SQLException ex){
            System.out.println("Erreur lors de la recherche dans la table users");
            return null;
        }
    }
}
