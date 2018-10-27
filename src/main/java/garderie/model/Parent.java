/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Parent extends Personne implements Serializable {
    private int nbEnfantsInscrits; 
    private String numTel;
    private String lienParente;
    private boolean visible;
    private ArrayList<Enfant> listeEnfants;

    public Parent() {
    }

    //Constructeur
    public Parent(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<Adresse> adresses, CompteUser compteUser, ArrayList<Enfant> listeEnf, String numTel, String lienParente) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses, compteUser);
        this.listeEnfants = listeEnf;
        this.nbEnfantsInscrits = this.listeEnfants.size();
        this.numTel = numTel;
        this.lienParente = lienParente;
        this.visible = true;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ArrayList<Enfant> getListeEnfants() {
        return listeEnfants;
    }

    public void setListeEnfants(ArrayList<Enfant> listeEnfants) {
        this.listeEnfants = listeEnfants;
    }
    
    
}
