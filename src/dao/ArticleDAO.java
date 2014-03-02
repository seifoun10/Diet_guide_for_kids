/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author tictacf12
 */
public class ArticleDAO {
    
    public static List<Article> getArticleList (String loginParent){
        List<Article> listeArticle = new ArrayList<Article>();
        String requete = "SELECT * FROM article, article_pediatres WHERE login_parent=? and Id_Article=Id";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, loginParent);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Article article = new Article();                
                article.setId(resultat.getInt("Id"));
                article.setTitre(resultat.getString("Titre"));
                article.setLoginAuteur(resultat.getString("Login_Auteur"));
                article.setType(resultat.getString("Type"));
                listeArticle.add(article);
            }
            return listeArticle;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des article. " + ex.getMessage());
            return null;
        }
    }
    
}
