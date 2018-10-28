/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import garderie.model.*;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Maryline
 */
public class Groupe implements Serializable {
    private int idGroupe; 
    private NomGroupe nom;
    private int nbEnfant;
    private String descriptif;
    private Employe referant;
    private ArrayList<Enfant> listeEnfants;
    private boolean visible;

    public Groupe() {
    }
    
    public Groupe(NomGroupe nom, String descriptif, Employe referant,ArrayList<Enfant> liste) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.referant = referant;
        this.listeEnfants = liste;
        this.nbEnfant = this.listeEnfants.size();
        this.visible = true;
    }
 
    
    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public NomGroupe getNom() {
        return nom;
    }

    public void setNom(NomGroupe nom) {
        this.nom = nom;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Employe getReferant() {
        return referant;
    }

    public void setReferant(Employe referant) {
        this.referant = referant;
    }

    public ArrayList<Enfant> getListeEnfants() {
        return listeEnfants;
    }

    public void setListeEnfants(ArrayList<Enfant> listeEnfants) {
        this.listeEnfants = listeEnfants;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void ajouterEnfant(Enfant e){
        this.listeEnfants.add(e);
    }

    public void supprimerEnfant(Enfant e){
        this.listeEnfants.remove(e);
    }
}
