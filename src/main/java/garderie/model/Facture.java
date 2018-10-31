/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Katsuo
 */
public class Facture implements Serializable {
    private int idFacture;
    private Date dateEmission;
    private double montantTTC;
    private Date datePaiement;
    private ArrayList<LigneFacture> lignesFactures = new ArrayList<>();
    private StatutFacture statut;
    private boolean visible = true;
    private ArrayList<ParentFacture> parent = new ArrayList<>();

    public Facture() {
    }
    
    public Facture(Date dateEmission, double montantTTC, Date datePaiement, StatutFacture statut,ArrayList<ParentFacture> p) {
        this.dateEmission = dateEmission;
        this.montantTTC = montantTTC;
        this.datePaiement = datePaiement;
        this.statut = statut;
        this.parent = p;
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
        for (LigneFacture ligneFacture : lignesFactures) {
            this.montantTTC = this.montantTTC + ligneFacture.getTotalTTC();
        }
    }
    

    public ArrayList<ParentFacture> getParent() {
        return parent;
    }

    public void setParent(ArrayList<ParentFacture> parent) {
        this.parent = parent;
    }
   
    
}
