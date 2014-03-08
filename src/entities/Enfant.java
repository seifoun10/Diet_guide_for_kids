/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author Killer
 */
public class Enfant {
    private int id;
    private String parent;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String Nationalite;
    private Date dateAjout;
    private boolean sexe;
    private float imcAjout;
    private float imcActuel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationalite() {
        return Nationalite;
    }

    public void setNationalite(String Nationalite) {
        this.Nationalite = Nationalite;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
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
    
    public Enfant(int id, String parent, String nom, String prenom, Date dateNaissance, String Nationalite, Date dateAjout, boolean sexe, float imcAjout, float imcActuel) {
        this.id = id;
        this.parent = parent;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.Nationalite = Nationalite;
        this.dateAjout = dateAjout;
        this.sexe = sexe;
        this.imcAjout = imcAjout;
        this.imcActuel = imcActuel;
    }
    
    public Enfant(){}

    @Override
    public String toString() {
        return "Enfant{" + "id=" + id + ", parent=" + parent + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", Nationalite=" + Nationalite + ", dateAjout=" + dateAjout + ", sexe=" + sexe + ", imcAjout=" + imcAjout + ", imcActuel=" + imcActuel + '}';
    }
}
