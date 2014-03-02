/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Karray
 */
public class MyConnection {

   private static final  String driver = "com.mysql.jdbc.Driver";
   private static final  String url = "jdbc:mysql://localhost:3306/Diet_Guide_For_Kids";
   private static final  String login = "root";
   private static final  String pwd = "root";
   private static Connection con;


   private MyConnection(){

   }

   public Connection etablirConnexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion établie.");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de chargement de driver. "+ex.getMessage());
        } catch (SQLException ex){
            System.out.println("Probleme d'etablissement de connexion."+ex.getMessage());
        }

        return con;
    }
   public static Connection getInstance(){
       if (con==null){
           new MyConnection().etablirConnexion();
       }
   return con;
   }
}
