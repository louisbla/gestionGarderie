/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Maryline
 */
public class ContactUrgence extends Personne implements Serializable {
    private String numTel;
    private String lien;
    private ArrayList<DossierContactUrgence> dossier;

    public ContactUrgence() {
    }
    
    public ContactUrgence(String numTel, String lien, String nom, String prenom, String sexe, Date dateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses, ArrayList<DossierContactUrgence> d) {
        super(nom, prenom, sexe, dateNaissance, numSecu, adresses);
        this.numTel = numTel;
        this.lien = lien;
        this.dossier = d;
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

    public ArrayList<DossierContactUrgence> getDossier() {
        return dossier;
    }

    public void setDossier(ArrayList<DossierContactUrgence> dossier) {
        this.dossier = dossier;
    }
    
    
    
}
