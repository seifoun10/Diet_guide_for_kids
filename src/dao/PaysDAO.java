/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Pays;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author Admin
 */
public class PaysDAO {
    public List<Pays> recuperer_pays(){
   
           List<Pays> p = new ArrayList<Pays>();
        String requete = "select fr from pays";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Pays pays=new Pays();
                pays.setPays(resultat.getString(1));
                p.add(pays);
                
            }
            return p;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
           
             return null;
        }
        
    }
}
