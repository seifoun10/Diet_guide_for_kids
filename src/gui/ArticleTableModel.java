/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import dao.ArticleDAO;
import dao.PediatreDAO;
import dao.UserDAO;
import entities.Article;
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
public class ArticleTableModel extends AbstractTableModel {

    List<Article> listArticle;
    String []header = {"Id","Type","Titre","Login auteur"};
    
    public ArticleTableModel(String loginParent) { //remplissage de la liste des stocks
        listArticle=new ArticleDAO().getArticleList(loginParent);
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listArticle.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_Stock
                return listArticle.get(rowIndex).getId();
            case 1://colonne type_vetement
                return listArticle.get(rowIndex).getType();
            case 2:
                return listArticle.get(rowIndex).getTitre();
            case 3:
                return listArticle.get(rowIndex).getLoginAuteur();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    

}
