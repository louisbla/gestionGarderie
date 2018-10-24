/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.ArrayList;
import java.util.Date;


public abstract class Personne {
    private int idPersonne; 
    private String nom;
    private String prenom;
    private String sexe; 
    private Date dateNaissance; 
    private String numSecu; 
    private ArrayList<Adresse> adresses;
    private CompteUser compteUser;        
  
    //Constructeur
    public Personne(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<Adresse> adresses, CompteUser compteUser) {
        this.nom = Nom;
        this.prenom = Prenom;
        this.sexe = Sexe;
        this.dateNaissance = DateNaissance;
        this.numSecu = numSecu;
        this.adresses = adresses;
        this.compteUser = compteUser;
    }

    public Personne(String nom, String prenom, String sexe, Date dateNaissance, String numSecu, ArrayList<Adresse> adresses) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.numSecu = numSecu;
        this.adresses = adresses;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public ArrayList<Adresse> getAdresses() {
        return adresses;
    }
       
    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public void setSexe(String Sexe) {
        this.sexe = Sexe;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.dateNaissance = DateNaissance;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public void setAdresses(ArrayList<Adresse> adresses) {
        this.adresses = adresses;
    }
        
}
