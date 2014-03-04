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
 * @author tictacf12
 */
public class TopicDAO {
    
    public int countTopic(String posteur){
        String requete = "SELECT COUNT(*) as nb_topic FROM topics WHERE login_createur=?";
        int nbTopic=-1;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, posteur);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                nbTopic=resultat.getInt("nb_topic");
            }            
        
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du comptage "+ex.getMessage()); 
        }
        return nbTopic;
               
    }
    
}
