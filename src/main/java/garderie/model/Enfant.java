/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Enfant extends Personne implements Serializable {
    private boolean visible;
    private String photo;   //url
    private DossierInscription dossier;
    private ArrayList<Parent> listeParents;
    private InventaireEnfant inventaire;
    
    public Enfant() {
    }

    //Constructeur
    public Enfant(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<Adresse> adresses, String photo,DossierInscription d, ArrayList<Parent> parents, InventaireEnfant i) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses);
        this.visible = true;
        this.photo = photo;
        this.dossier = d; 
        this.listeParents = parents;
        this.inventaire = i;
    }
        
    public boolean isVisible() {
        return visible;
    }

    public String getPhoto() {
        return photo;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public ArrayList<Parent> getListeParents() {
        return listeParents;
    }

    public void setListeParents(ArrayList<Parent> listeParents) {
        this.listeParents = listeParents;
    }

    public InventaireEnfant getInventaire() {
        return inventaire;
    }

    public void setInventaire(InventaireEnfant inventaire) {
        this.inventaire = inventaire;
    }
 
}
