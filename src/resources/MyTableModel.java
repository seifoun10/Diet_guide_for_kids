/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resources;

import dao.UserDAO;
import entities.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tictacf12
 */
public class MyTableModel extends AbstractTableModel {

    List<User> listUser = new ArrayList<User>();
    String []header = {"Login","Nom","Prenom","Email","Date d'inscription","Date de naissance","Sexe","Nationalité","Type"};
    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    
    public MyTableModel(String login, String nom, String prenom,String email,String nationnalite,Date dateInscription,Date dateNaissance, Boolean sexe, String[] type) { //remplissage de la liste des stocks
        java.sql.Date dateInscriptionSQL;
        if(dateInscription==null)dateInscriptionSQL=null;
        else dateInscriptionSQL=new java.sql.Date(dateInscription.getTime()) ;
        
        java.sql.Date dateNaissanceSQL;
        if(dateNaissance==null)dateNaissanceSQL=null;
        else dateNaissanceSQL=new java.sql.Date(dateNaissance.getTime()) ;
        
        listUser=new UserDAO().getUserList(login,nom,prenom,email,nationnalite,dateInscriptionSQL,dateNaissanceSQL,sexe,type);
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listUser.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_Stock
                return listUser.get(rowIndex).getLogin();
            case 1://colonne type_vetement
                return listUser.get(rowIndex).getNom();
            case 2://colonne quantité
                return listUser.get(rowIndex).getPrenom();
            case 3://colonne adresse depot
                return listUser.get(rowIndex).getEmail();
            case 4://colonne adresse depot
                return formater.format(listUser.get(rowIndex).getDateInscription());
            case 5://colonne adresse depot
                return formater.format(listUser.get(rowIndex).getDateNaissance());
            case 6://colonne adresse depot
                if(listUser.get(rowIndex).isSexe())return "Homme"; else return "Femme";
            case 7://colonne adresse depot
                return listUser.get(rowIndex).getNationalite();
            case 8://colonne adresse depot
                return listUser.get(rowIndex).getType();
                
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    

}
