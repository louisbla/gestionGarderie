/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.ArrayList;
import java.sql.Date;


public class Personne {
    private int idPersonne; 
    private String nom;
    private String prenom;
    private String sexe; 
    private Date dateNaissance; 
    private String numSecu; 
    private ArrayList<PersonneAdresse> adresses;
    private CompteUser compteUser;
    private boolean visible = true;

    public Personne() {
    }
  
    //Constructeur
    public Personne(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses, CompteUser compteUser) {
        this.nom = Nom;
        this.prenom = Prenom;
        this.sexe = Sexe;
        this.dateNaissance = DateNaissance;
        this.numSecu = numSecu;
        this.adresses = adresses;
        this.compteUser = compteUser;
    }

    public Personne(String nom, String prenom, String sexe, Date dateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses) {
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

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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

    public ArrayList<PersonneAdresse> getAdresses() {
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

    public void setAdresses(ArrayList<PersonneAdresse> adresses) {
        this.adresses = adresses;
    }
    
    public CompteUser getCompteUser() {
        return compteUser;
    }

    public void setCompteUser(CompteUser compteUser) {
        this.compteUser = compteUser;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
        
}
