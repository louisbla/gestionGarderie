/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

/**
 *
 * @author Katsuo
 */
public class ObjetFacturable {
    private int idObjectFacturable;
    private String reference;
    private double prixTTC;
    private String nom;
    private String type;
    private TVA tva;

    public ObjetFacturable(String reference, double prixTTC, String nom, String type, TVA tva) {
        this.reference = reference;
        this.prixTTC = prixTTC;
        this.nom = nom;
        this.type = type;
        this.tva = tva;
    }

    public int getIdObjectFacturable() {
        return idObjectFacturable;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(double prixTTC) {
        this.prixTTC = prixTTC;
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
