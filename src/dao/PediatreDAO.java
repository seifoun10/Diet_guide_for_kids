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
    
    //ahmed
    public static void acceptPediatre(String login){
        String requete = "UPDATE pediatres SET isAccepted = true WHERE login_pediatre = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("Pédiatre accepté.");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification. "+ex.getMessage());
        }
    }
    //ahmed
    public static void deletePediatre(String login){
        String requete = "DELETE FROM users WHERE login_user = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("Pédiatre supprimé.");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression. "+ex.getMessage());
        }
    }
    //ahmed
    public static List<Pediatre> displayAllInacceptedPediatres (){
        List<Pediatre> listePediatres = new ArrayList<Pediatre>();
        String requete = "SELECT * FROM users, pediatres WHERE pediatres.isAccepted = 0 AND users.login_user = pediatres.login_pediatre ORDER BY users.login_user";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                Pediatre pediatre = new Pediatre();
                
                pediatre.setLogin(resultat.getString("Login_user"));
                pediatre.setCin(resultat.getString("CIN"));
                pediatre.setNom(resultat.getString("Nom"));
                pediatre.setPrenom(resultat.getString("Prenom"));
                pediatre.setEmail(resultat.getString("Email"));
                pediatre.setPwd(resultat.getString("pwd"));
                pediatre.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                pediatre.setDateInscription(resultat.getDate("Date_Inscription"));
                pediatre.setNationalite(resultat.getString("Nationalite"));
                pediatre.setSexe(resultat.getBoolean("Sexe"));
                pediatre.setDoc(resultat.getString("Doc"));
                pediatre.setAdresse(resultat.getString("Adresse"));
                pediatre.setTelephone(resultat.getString("Telephone"));
                
                listePediatres.add(pediatre);
            }
            return listePediatres;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des pediatres. " + ex.getMessage());
            return null;
        }
    }
    //taha
    public static List<Pediatre> getPediatreList (String loginParent){
        List<Pediatre> listePediatres = new ArrayList<Pediatre>();
        String requete = "SELECT Login_user, Nom, Prenom FROM users, favoris_pediatres WHERE login_parent=? and login_pediatre=login_user";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, loginParent);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Pediatre pediatre = new Pediatre();                
                pediatre.setLogin(resultat.getString("Login_user"));
                pediatre.setNom(resultat.getString("Nom"));
                pediatre.setPrenom(resultat.getString("Prenom"));                
                listePediatres.add(pediatre);
            }
            return listePediatres;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des pediatres. " + ex.getMessage());
            return null;
        }
    }
    //taha
    public Pediatre findPediatreByString(String login) {

        Pediatre pediatre = new Pediatre();
        String requete = "select * from Pediatres p, users u where p.login_pediatre=? and u.login_user=p.login_pediatre";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                pediatre.setLogin(resultat.getString("Login_user"));
                pediatre.setNom(resultat.getString("Nom"));
                pediatre.setPrenom(resultat.getString("Prenom"));
                pediatre.setEmail(resultat.getString("Email"));
                pediatre.setSexe(resultat.getBoolean("Sexe"));
                pediatre.setDateInscription(resultat.getDate("Date_Inscription"));
                pediatre.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                System.out.println(pediatre.getDateNaissance());
                pediatre.setNationalite(resultat.getString("Nationalite"));
                pediatre.setAdresse(resultat.getString("Adresse"));
                pediatre.setTelephone(resultat.getString("Telephone"));
                pediatre.setCin(resultat.getString("CIN"));
                pediatre.setEvaluation(calculEvaluation(pediatre.getLogin()));
                pediatre.setNbMessage(new MessageDAO().countMessage(pediatre.getLogin()));
                pediatre.setNbTopic(new TopicDAO().countTopic(pediatre.getLogin()));
                pediatre.setNbFavoris(countFavoris(pediatre.getLogin()));
                pediatre.setArticle(new ArticleDAO().getOwnArticleList(pediatre.getLogin()));
            }
            return pediatre;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du pediatre "+ex.getMessage());
            return null;
        }
    }
    //taha
    private int countFavoris(String login) {
        int nbFavoris=0;  
        String requete = "SELECT count(*) as nb FROM favoris_pediatres where Login_Pediatre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                nbFavoris=resultat.getInt("nb");
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche des favoris pédiatre "+ex.getMessage());
            return 0;
        }
        
        return nbFavoris;        
    }
    //taha
    private int calculEvaluation(String login) {
        int note;
        int sommeNote=0;
        int nombreNote=-1;
        String requete = "SELECT SUM( Note ) as somme, count(*) as nombre FROM evaluations_pediatres where Login_Pediatre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                sommeNote=resultat.getInt("somme");
                nombreNote=resultat.getInt("nombre");
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'évaluation pédiatre "+ex.getMessage());
            return 0;
        }
        if(nombreNote==0) return 0;
        note=Math.round(sommeNote/nombreNote);
        return note;
    }
}
