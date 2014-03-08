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
public class User {
    private String login;
    private String pwd;
    private String nom;
    private String prenom;
    private String email;
    private boolean sexe;
    private Date dateNaissance;
    private String nationalite;
    private Date dateInscription;
    private String type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationnalite) {
        this.nationalite = nationnalite;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public User(String login, String pwd, String nom, String prenom, String email, boolean sexe, Date dateNaissance, String nationalite, Date dateInscription, String type) {
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.dateInscription = dateInscription;
        this.type = type;
    }

    public User() {}

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", pwd=" + pwd + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", sexe=" + sexe + ", dateNaissance=" + dateNaissance + ", nationalite=" + nationalite + ", dateInscription=" + dateInscription + ", type=" + type;
    }
}
