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
    private Date date;
    private String description;
    private int nbEnfantMax;
    private String lieu;
    private double prix;
    private boolean visible;

    public Activite() {
    }

    public Activite(int idActivite, String nom, Date date, String description, int nbEnfantMax, String lieu, double prix) {
        this.idActivite = idActivite;
        this.nom = nom;
        this.date = date;
        this.description = description;
        this.nbEnfantMax = nbEnfantMax;
        this.lieu = lieu;
        this.prix = prix;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
