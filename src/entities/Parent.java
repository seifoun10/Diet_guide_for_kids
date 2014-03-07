/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.List;

/**
 *
 * @author tictacf12
 */
public class Parent extends User {
    private List<Enfant> enfant;
    int nbTopic;
    int nbMessage;
    private List<Pediatre> pediatreFavoris;

    public int getNbTopic() {
        return nbTopic;
    }

    public void setNbTopic(int nbTopic) {
        this.nbTopic = nbTopic;
    }

    public int getNbMessage() {
        return nbMessage;
    }

    public void setNbMessage(int nbMessage) {
        this.nbMessage = nbMessage;
    }

    public List<Pediatre> getPediatreFavoris() {
        return pediatreFavoris;
    }

    public void setPediatreFavoris(List<Pediatre> pediatreFavoris) {
        this.pediatreFavoris = pediatreFavoris;
    }

    public List<Article> getArticleFavoris() {
        return articleFavoris;
    }

    public void setArticleFavoris(List<Article> articleFavoris) {
        this.articleFavoris = articleFavoris;
    }
    private List<Article> articleFavoris;
    

    public List<Enfant> getEnfant() {
        return enfant;
    }

    public void setEnfant(List<Enfant> enfant) {
        this.enfant = enfant;
    }
    
}
