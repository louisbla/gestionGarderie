/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;


public class Employe extends Personne implements Serializable {
        private String numTel;
        private String poste;
        private boolean externe;
        private DossierEmploye dossier;

    public Employe() {
    }

    public Employe(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses, String numTel,   String poste,  boolean externe, DossierEmploye dossier) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses);
        this.numTel = numTel;
        this.poste = poste;
        this.externe = externe;
        this.dossier = dossier;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public boolean isExterne() {
        return externe;
    }

    public void setExterne(boolean externe) {
        this.externe = externe;
    }
    
    public DossierEmploye getDossier() {
        return dossier;
    }

    public void setDossier(DossierEmploye dossier) {
        this.dossier = dossier;
    }
 
    /*
    public void modifierInventaire(){
    }
    
    public void modifierCalendrier(){
    }
    
    public void accesDosier(){
    }
    
    public void editerRapportJournalier(){
    }
    
    */
    
}
