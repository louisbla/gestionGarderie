/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Katsuo
 */
public class Maladie implements Serializable {
    private int idMaladie;
    private String nom;
    private String descriptif;
    private boolean visible;
    private ArrayList<Traitement> traitement;

    public Maladie() {
    }

    public Maladie(String nom, String descriptif, ArrayList<Traitement> t) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.visible = true;
        this.traitement = t;
    }

    public int getIdMaladie() {
        return idMaladie;
    }

    public void setIdMaladie(int idMaladie) {
        this.idMaladie = idMaladie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ArrayList<Traitement> getTraitement() {
        return traitement;
    }

    public void setTraitement(ArrayList<Traitement> traitement) {
        this.traitement = traitement;
    }
 
}
