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
    private ArrayList<DossierContactUrgence> dossier = new ArrayList();

    public ContactUrgence() {
    }
    
    public ContactUrgence(String numTel, String nom, String prenom, String sexe, Date dateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses, ArrayList<DossierContactUrgence> d) {
        super(nom, prenom, sexe, dateNaissance, numSecu, adresses);
        this.numTel = numTel;
        this.dossier = d;
    }

    public String getNumTel() {
        return this.numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public ArrayList<DossierContactUrgence> getDossier() {
        return dossier;
    }

    public void setDossier(ArrayList<DossierContactUrgence> dossier) {
        this.dossier = dossier;
    }
    
    
    
}
