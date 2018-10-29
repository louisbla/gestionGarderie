/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Katsuo
 */
public class Activite implements Serializable{
    private int idActivite;
    private String nom;
    private String description;
    private int nbEnfantMax;
    private String lieu;
    private boolean visible;

    public Activite() {
    }

    public Activite(int idActivite, String nom, String description, int nbEnfantMax, String lieu) {
        this.idActivite = idActivite;
        this.nom = nom;
        this.description = description;
        this.nbEnfantMax = nbEnfantMax;
        this.lieu = lieu;
        this.visible = true;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbEnfantMax() {
        return nbEnfantMax;
    }

    public void setNbEnfantMax(int nbEnfantMax) {
        this.nbEnfantMax = nbEnfantMax;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
