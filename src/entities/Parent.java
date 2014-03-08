/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tictacf12
 */
public class Parent extends User {
    private List<Enfant> enfants;
    private int nbTopic;
    private int nbMessage;
    private List<Pediatre> pediatresFavoris;
    private List<Article> articlesFavoris;
    
    public List<Enfant> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Enfant> enfants) {
        this.enfants = enfants;
    }

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

    public List<Pediatre> getPediatresFavoris() {
        return pediatresFavoris;
    }

    public void setPediatresFavoris(List<Pediatre> pediatresFavoris) {
        this.pediatresFavoris = pediatresFavoris;
    }

    public List<Article> getArticlesFavoris() {
        return articlesFavoris;
    }

    public void setArticlesFavoris(List<Article> articlesFavoris) {
        this.articlesFavoris = articlesFavoris;
    }

    public Parent(List<Enfant> enfants, int nbTopic, int nbMessage, List<Pediatre> pediatresFavoris, String login, String pwd, String nom, String prenom, String email, boolean sexe, Date dateNaissance, String nationalite, Date dateInscription, String type) {
        super(login, pwd, nom, prenom, email, sexe, dateNaissance, nationalite, dateInscription, type);
        this.enfants = enfants;
        this.nbTopic = nbTopic;
        this.nbMessage = nbMessage;
        this.pediatresFavoris = pediatresFavoris;
    }

    public Parent() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + " enfants=" + enfants + ", nbTopic=" + nbTopic + ", nbMessage=" + nbMessage + ", pediatresFavoris=" + pediatresFavoris + '}';
    }
}
