/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;


public class Parent extends Personne implements Serializable {
    private int nbEnfantsInscrits; 
    private String numTel;
    private String lienParente;
    private ArrayList<Filiation> listeEnfants;
    private ArrayList<ParentFacture> factures;

    public Parent() {
    }

    //Constructeur
    public Parent(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses, ArrayList<Filiation> listeEnf, String numTel, String lienParente, ArrayList<ParentFacture> fact) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses);
        this.listeEnfants = listeEnf;
        this.nbEnfantsInscrits = this.listeEnfants.size();
        this.numTel = numTel;
        this.lienParente = lienParente;
        this.factures = fact;
    }
  
    
    public int getNbEnfantsInscrits() {
        return nbEnfantsInscrits;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setNbEnfantsInscrits(int nbEnfantsInscrits) {
        this.nbEnfantsInscrits = nbEnfantsInscrits;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }
    
    public ArrayList<Filiation> getListeEnfants() {
        return listeEnfants;
    }

    public void setListeEnfants(ArrayList<Filiation> listeEnfants) {
        this.listeEnfants = listeEnfants;
    }

    public ArrayList<ParentFacture> getFactures() {
        return factures;
    }

    public void setFactures(ArrayList<ParentFacture> factures) {
        this.factures = factures;
    }
    
    
    
    
}
