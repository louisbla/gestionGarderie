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
    private Date datePaiement;
    private int nbEnfant;
    private ArrayList<LigneFacture> lignesFactures;
    private StatutFacture statut;
    private boolean visible;

    public Facture() {
    }
    
    public Facture(Date dateEmission, double montantTTC, Date datePaiement, int nbEnfant, StatutFacture statut) {
        this.dateEmission = dateEmission;
        this.montantTTC = montantTTC;
        this.datePaiement = datePaiement;
        this.nbEnfant = nbEnfant;
        this.lignesFactures = new ArrayList<>();
        this.statut = statut;
        this.visible = true;
    }

    public int getIdFacture() {
        return this.idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
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

    public Date getDatePaiement() {
        return this.datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }


    public int getNbEnfant() {
        return this.nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
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

    public StatutFacture getStatut() {
        return statut;
    }

    public void setStatut(StatutFacture statut) {
        this.statut = statut;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
      
    public void calculerTotalTTC() {
        int nbLigne = this.lignesFactures.size();
        
        for (int i = 0;i<nbLigne;i++){
            this.montantTTC = this.montantTTC + this.lignesFactures.get(i).getTotalTTC();
        }
    }
   
}
