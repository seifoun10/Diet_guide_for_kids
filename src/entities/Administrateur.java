/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;


/**
 *
 * @author Admin
 */
public class Administrateur extends User {
    
    public Administrateur(String login, String pwd, String nom, String prenom, String email, boolean sexe, Date dateNaissance, String nationalite, Date dateInscription, String type) {
        super(login, pwd, nom, prenom, email, sexe, dateNaissance, nationalite, dateInscription, type);
    }

    public Administrateur() {
        super();
    }

   @Override
    public String toString() {
        return super.toString() + '}';
    }
}
