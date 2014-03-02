/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Enfant;
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
public class EnfantDAO {
    public List<Enfant> getEnfantList(String parent){
        
        List<Enfant> listEnfant = new ArrayList<Enfant>();
        
        String requete = "SELECT * FROM enfants WHERE Login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, parent+"%");
            
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Enfant enfant =new Enfant();
                enfant.setId(resultat.getInt("Id"));
                enfant.setNom(resultat.getString("Nom"));
                enfant.setPrenom(resultat.getString("Prenom"));
                enfant.setDateNaissance(resultat.getDate("Date_De_Naissance"));
                enfant.setSexe(resultat.getBoolean("Sexe"));
                enfant.setNationalite(resultat.getString("Nationalite"));
                enfant.setDateAjout(resultat.getDate("Date_Ajout"));
                enfant.setImcActuel(resultat.getFloat("IMC_Actuelle"));
                enfant.setImcAjout(resultat.getFloat("IMC_Ajout"));
                listEnfant.add(enfant);
            }
            return listEnfant;
        }catch (SQLException ex){
            System.out.println("Erreur lors de la recherche dans la table enfants");
            return null;
        }
    }
    
}
