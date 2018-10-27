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
    private String reference;
    private double prixHT;
    private String nom;
    private String type;
    private TVA tva;

    public ObjetFacturable() {
    }
    
    public ObjetFacturable(String reference, double prixHT, String nom, String type, TVA tva) {
        this.reference = reference;
        this.prixHT = prixHT;
        this.nom = nom;
        this.type = type;
        this.tva = tva;
    }

    public int getIdObjectFacturable() {
        return idObjectFacturable;
    }

    public void setIdObjectFacturable(int idObjectFacturable) {
        this.idObjectFacturable = idObjectFacturable;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TVA getTva() {
        return tva;
    }

    public void setTva(TVA tva) {
        this.tva = tva;
    }
}
