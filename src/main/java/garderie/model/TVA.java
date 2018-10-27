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
public class TVA implements Serializable {
    private int idTVA;
    private String nom;
    private double montant;

    public TVA() {
    }

    public TVA(String nom, double montant) {
        this.nom = nom;
        this.montant = montant;
    }

    public int getIdTVA() {
        return idTVA;
    }

    public void setIdTVA(int idTVA) {
        this.idTVA = idTVA;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
}
