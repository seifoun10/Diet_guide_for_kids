/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entities.Administrateur;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import util.MyConnection;
public class AdminDAO {
    static Administrateur admindao;
    public static String log,pass,cin;
    //public  static void main(String[] args){
  /*  public void recuperer_admin(){
   

        String requete = "select * from admin";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                admindao =new Administrateur();
                admindao.setLogin(resultat.getString("login"));
                admindao.setPassword(resultat.getString("passwd"));
                log=admindao.getLogin();
                pass=admindao.getPassword();
                
                System.out.println(admindao.toString());
            }
            //return admindao;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            //return null;
        }
    }
    
     public void updateMP(Administrateur d){
        String requete = "update admin set passwd=? where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getPassword());
            ps.setString(2, d.getLogin());
            ps.executeUpdate();
            System.out.println("");
            JOptionPane.showMessageDialog(null, "modification mot de passe avec succès","Mot de passe",1);
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Vous n'êtes pas connecté sur la machine qui contien la base","",1);
        }
    }*/
//}

    public Administrateur findAdministrateurByString(String login) {
        Administrateur admin = new Administrateur();
     String requete = "select * from admins p, users u where p.login_admin=? and u.login=p.login_admin";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                admin.setLogin(resultat.getString("Login"));
                admin.setNom(resultat.getString("Nom"));
                admin.setPrenom(resultat.getString("Prenom"));
                admin.setEmail(resultat.getString("Email"));
                admin.setSexe(resultat.getBoolean("Sexe"));
                admin.setDateInscription(resultat.getDate("Date_Inscription"));
                admin.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                admin.setNationalite(resultat.getString("Nationalite"));
                admin.setCin(resultat.getString("Cin"));
                
            }
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du parent "+ex.getMessage());
            return null;
        }
    }

}