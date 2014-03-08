/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;


/**
 *
 * @author Killer
 */
public class AdministrateurForum extends User {
    
    public AdministrateurForum(String login, String pwd, String nom, String prenom, String email, boolean sexe, Date dateNaissance, String nationalite, Date dateInscription, String type) {
        super(login, pwd, nom, prenom, email, sexe, dateNaissance, nationalite, dateInscription, type);
    }

    public AdministrateurForum() {
        super();
    }

   @Override
    public String toString() {
        return super.toString() + '}';
    }
}
