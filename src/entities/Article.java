package entities;

/*
 * To change this license header, choose License Headers in Project 
Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Date;

/**
 *
 * @author tictacf12
 */
public class Article {
    private int id;
    private String type;
    private String titre;
    private String auteur;
    private Date dateAjout;
    private int evaluation;
    private int nbLecture;
    private int nbFavoris;
    private int nbr_partage;

    public int getNbr_partage() {
        return nbr_partage;
    }

    public void setNbr_partage(int nbr_partage) {
        this.nbr_partage = nbr_partage;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getNbLecture() {
        return nbLecture;
    }

    public void setNbLecture(int nbLecture) {
        this.nbLecture = nbLecture;
    }

    public int getNbFavoris() {
        return nbFavoris;
    }

    public void setNbFavoris(int nbFavoris) {
        this.nbFavoris = nbFavoris;
    }
    
}
