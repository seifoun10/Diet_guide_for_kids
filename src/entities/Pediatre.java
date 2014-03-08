/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Killer
 */
public class Pediatre extends User{
    
    private String adresse;
    private String telephone;
    private String doc;
    private String info;
    private String cin;
    private int evaluation;
    private int nbTopic;
    private int nbFavoris;
    private int nbMessage;
    private List<Article> Article;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getNbTopic() {
        return nbTopic;
    }

    public void setNbTopic(int nbTopic) {
        this.nbTopic = nbTopic;
    }

    public int getNbFavoris() {
        return nbFavoris;
    }

    public void setNbFavoris(int nbFavoris) {
        this.nbFavoris = nbFavoris;
    }

    public int getNbMessage() {
        return nbMessage;
    }

    public void setNbMessage(int nbMessage) {
        this.nbMessage = nbMessage;
    }

    public List<Article> getArticle() {
        return Article;
    }

    public void setArticle(List<Article> Article) {
        this.Article = Article;
    }
}
