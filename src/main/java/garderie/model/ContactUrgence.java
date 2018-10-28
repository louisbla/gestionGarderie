/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Maryline
 */
public class ContactUrgence extends Personne implements Serializable {
    private String numTel;
    private String lien;

    public ContactUrgence() {
    }
    
    public ContactUrgence(String numTel, String lien, String nom, String prenom, String sexe, Date dateNaissance, String numSecu, ArrayList<Adresse> adresses) {
        super(nom, prenom, sexe, dateNaissance, numSecu, adresses);
        this.numTel = numTel;
        this.lien = lien;
    }

    public String getNumTel() {
        return this.numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getLien() {
        return this.lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
    
    
}
