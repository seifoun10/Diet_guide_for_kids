/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import dao.PediatreDAO;
import dao.UserDAO;
import entities.Enfant;
import entities.Pediatre;
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
public class PediatreTableModel extends AbstractTableModel {

    List<Pediatre> listPediatre;
    String []header = {"Login","Nom"};
    
    public PediatreTableModel(String loginParent) { //remplissage de la liste des stocks
        listPediatre=new PediatreDAO().getPediatreList(loginParent);
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listPediatre.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_Stock
                return listPediatre.get(rowIndex).getLogin();
            case 1://colonne type_vetement
                return ( listPediatre.get(rowIndex).getPrenom()+" "+listPediatre.get(rowIndex).getNom());  
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    

}
