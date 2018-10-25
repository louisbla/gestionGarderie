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
public class Facture implements Serializable {
    private int idFacture;
    private Date dateEmission;
    private double montantTTC;
    private double montantHT;
    private Date datePaiement;
    private boolean paye;
    private int nbEnfant;
    private ArrayList<LigneFacture> lignesFactures;

    public Facture() {
    }
    
    public Facture(Date dateEmission, double montantTTC, double montantHT, Date datePaiement, boolean paye, int nbEnfant) {
        this.dateEmission = dateEmission;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
        this.datePaiement = datePaiement;
        this.paye = paye;
        this.nbEnfant = nbEnfant;
        this.lignesFactures = new ArrayList<>();
    }

    public int getIdFacture() {
        return this.idFacture;
    }

    public Date getDateEmission() {
        return this.dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public double getMontantTTC() {
        return this.montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public double getMontantHT() {
        return this.montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public Date getDatePaiement() {
        return this.datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public boolean isPaye() {
        return this.paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public int getNbEnfant() {
        return this.nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }
    
    public void calculerTotalTTC() {
        
    }

    public ArrayList<LigneFacture> getLignesFactures() {
        return lignesFactures;
    }

    public void setLignesFactures(ArrayList<LigneFacture> lignesFactures) {
        this.lignesFactures = lignesFactures;
    }
    
    public void ajouterLigneFacture(LigneFacture ligneFacture) {
        this.lignesFactures.add(ligneFacture);
    }
    
}
