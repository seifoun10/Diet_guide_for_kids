package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import entities.Article;
import util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ArticleDAO {
    
    public List<Article> getArticleList (String loginParent){
        List<Article> listeArticle = new ArrayList<Article>();
        String requete = "SELECT * FROM articles a, favoris_articles fa WHERE login_parent=? and fa.Id_Article=a.Id_Article";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, loginParent);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Article article= new Article();
                article.setId(resultat.getInt("a.Id_Article"));
                article.setTitre(resultat.getString("Titre"));
                article.setAuteur(resultat.getString("Auteur"));
                article.setType(resultat.getString("Type"));
                listeArticle.add(article);
            }
            return listeArticle;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des article. " + ex.getMessage());
            return null;
        }
    }

    List<Article> getOwnArticleList(String login) {
        List<Article> listeArticle = new ArrayList<Article>();
        String requete = "SELECT * FROM articles WHERE auteur=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Article article = new Article();                
                article.setId(resultat.getInt("Id_article"));
                article.setTitre(resultat.getString("Titre"));
                article.setAuteur(resultat.getString("Auteur"));
                article.setType(resultat.getString("Type"));
                article.setDateAjout(resultat.getDate("Date_Ajout"));
                article.setEvaluation(getArticleEvaluation(article.getId()));
                article.setNbLecture(resultat.getInt("Vues"));
                article.setNbFavoris(countFavoris(article.getId()));
                
                listeArticle.add(article);
            }
            return listeArticle;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des article. " + ex.getMessage());
            return null;
        }
    }
    
    public List<Article> displayAllArticle(String req) {
        List<Article> listeArticle = new ArrayList<Article>();
        String requete = "SELECT * FROM articles"+ req;
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Article article = new Article();                
                article.setId(resultat.getInt("Id_article"));
                article.setTitre(resultat.getString("Titre"));
                article.setAuteur(resultat.getString("Auteur"));
                article.setType(resultat.getString("Type"));
                article.setDateAjout(resultat.getDate("Date_Ajout"));
                article.setEvaluation(getArticleEvaluation(article.getId()));
                article.setNbLecture(resultat.getInt("Vues"));
                article.setNbr_partage(resultat.getInt("Partages"));
                article.setNbFavoris(countFavoris(article.getId()));
                
                listeArticle.add(article);
            }
            return listeArticle;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des article. " + ex.getMessage());
            return null;
        }
    }

    private int getArticleEvaluation(int id) {
        int note;
        int sommeNote=0;
        int nombreNote=-1;
        
        String requete = "SELECT SUM( Note ) as somme, count(*) as nombre FROM evaluations_articles where Id_Article=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                sommeNote=resultat.getInt("somme");
                nombreNote=resultat.getInt("nombre");
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'évaluation article "+ex.getMessage());
            return 0;
        }
        if(nombreNote==0) return 0;
        note=Math.round(sommeNote/nombreNote);
        return note;
    }
    
    
    
     public List getListEvaluationArticle(String s) {
        List<Article> listeArticle = new ArrayList<Article>();
         
         ArticleDAO artDAO=new ArticleDAO();
         listeArticle=artDAO.displayAllArticle(s);//liste des articles
         
         List<Integer> listeNote = new ArrayList();//liste des notes
         
         for(Article a: listeArticle){
        int note=-1;
        
        String requete = "SELECT AVG(Note) FROM evaluations_articles where Id_Article= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, a.getId());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                note=(int) resultat.getFloat(1);
                
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'évaluation article "+ex.getMessage());   
        }
        //ajouter à la liste
        listeNote.add(note);
    }
         return listeNote;
     }
     
     
      public int DisplayMaxOrMinInt (String s){
        String requete = "select "+s+" from articles";
       try {
           java.sql.Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           int a = 0;
            while(resultat.next()){
               
                a=(resultat.getInt(1));

                
            }
            return a;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement "+ex.getMessage());
            return 0;
        }
    }
     
     
     
     
    private int countFavoris(int id) {
        int nbFavoris=0;  
        String requete = "SELECT count(*) as nb FROM favoris_Articles where id_Article=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                nbFavoris=resultat.getInt("nb");
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche des favoris article "+ex.getMessage());
            return 0;
        }
        
        return nbFavoris;
    }
    
    
    
    private int getArticleEvaluationWhere(String s) {
        int note;
        int sommeNote=0;
        int nombreNote=-1;
        String requete = "SELECT SUM( Note ) as somme, count(*) as nombre FROM evaluations_articles ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, s);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                sommeNote=resultat.getInt("somme");
                nombreNote=resultat.getInt("nombre");
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'évaluation article "+ex.getMessage());
            return 0;
        }
        if(nombreNote==0) return 0;
        note=Math.round(sommeNote/nombreNote);
        return note;
    }
    
    
    
}
