/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import garderie.model.*;
import java.io.Serializable;
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

    public Groupe() {
    }
    
    public Groupe(NomGroupe nom, int nbEnfant, String descriptif, Employe referant) {
        this.nom = nom;
        this.nbEnfant = nbEnfant;
        this.descriptif = descriptif;
        this.referant = referant;
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
    
    

}
