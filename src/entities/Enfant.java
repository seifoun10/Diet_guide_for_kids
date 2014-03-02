/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author tictacf12
 */
public class Enfant {
    private int id;
    private String nom;
    private String prenom;
    private boolean sexe;
    private String nationalite;
    private Date dateNaissance;
    private Date dateAjout;
    private float imcAjout;
    private float imcActuel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationnalite) {
        this.nationalite = nationnalite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public float getImcAjout() {
        return imcAjout;
    }

    public void setImcAjout(float imcAjout) {
        this.imcAjout = imcAjout;
    }

    public float getImcActuel() {
        return imcActuel;
    }

    public void setImcActuel(float imcActuel) {
        this.imcActuel = imcActuel;
    }
}
