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
    private String travail;
    

    public List<Enfant> getEnfant() {
        return enfant;
    }

    public void setEnfant(List<Enfant> enfant) {
        this.enfant = enfant;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }
    
    
}
