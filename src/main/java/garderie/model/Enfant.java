/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

public class Enfant extends Personne implements Serializable {

    private String photo;   //url
    private DossierInscription dossier;
    private ArrayList<Filiation> listeParents;
    private InventaireEnfant inventaire;
    private ArrayList<Traitement> traitement;
    private Groupe groupe;

    public Enfant() {
    }

    //Constructeur
    public Enfant(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<PersonneAdresse> adresses, String photo, DossierInscription d, ArrayList<Filiation> parents, InventaireEnfant i, ArrayList<Traitement> t) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses);
        this.photo = photo;
        this.dossier = d;
        this.listeParents = parents;
        this.inventaire = i;
        this.traitement = t;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public DossierInscription getDossier() {
        return dossier;
    }

    public void setDossier(DossierInscription dossier) {
        this.dossier = dossier;
    }

    public ArrayList<Filiation> getListeParents() {
        return listeParents;
    }

    public void setListeParents(ArrayList<Filiation> listeParents) {
        this.listeParents = listeParents;
    }

    public InventaireEnfant getInventaire() {
        return inventaire;
    }

    public void setInventaire(InventaireEnfant inventaire) {
        this.inventaire = inventaire;
    }

    public ArrayList<Traitement> getTraitement() {
        return traitement;
    }

    public void setTraitement(ArrayList<Traitement> traitement) {
        this.traitement = traitement;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

}
