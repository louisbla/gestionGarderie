/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;

/**
 *
 * @author Katsuo
 */
public class ObjetFacturable implements Serializable {
    private int idObjectFacturable;
    private double prixHT;
    private String nom;
    private TVA tva;
    private boolean visible;
    private Activite activite;
    
    public ObjetFacturable() {
    }
    
    public ObjetFacturable(double prixHT, String nom,  TVA tva) {
        this.prixHT = prixHT;
        this.nom = nom;
        this.tva = tva;
        this.visible = true;
        this.activite = null;
    }

    public int getIdObjectFacturable() {
        return idObjectFacturable;
    }

    public void setIdObjectFacturable(int idObjectFacturable) {
        this.idObjectFacturable = idObjectFacturable;
    }



    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT (double prixHT) {
        this.prixHT = prixHT;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TVA getTva() {
        return tva;
    }

    public void setTva(TVA tva) {
        this.tva = tva;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }
}
