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
public class LigneFacture implements Serializable {
    private int idLigneFacture;
    private double totalTTC;
    private double totalHT;
    private int quantite;
    private Facture facture;
    private ArrayList<ObjetFacturable> objetsFacturables;

    public LigneFacture() {
    }

    public LigneFacture(double totalTTC, double totalHT, int quantite,
            Facture facture) {
        this.totalTTC = totalTTC;
        this.totalHT = totalHT;
        this.quantite = quantite;
        this.facture = facture;
        this.objetsFacturables = new ArrayList<>();
    }

    public int getIdLigneFacture() {
        return idLigneFacture;
    }

    public void setIdLigneFacture(int idLigneFacture) {
        this.idLigneFacture = idLigneFacture;
    }

    public double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(double totalTTC) {
        this.totalTTC = totalTTC;
    }

    public double getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(double totalHT) {
        this.totalHT = totalHT;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public ArrayList<ObjetFacturable> getObjetsFacturables() {
        return objetsFacturables;
    }

    public void setObjetsFacturables(ArrayList<ObjetFacturable> objetsFacturables) {
        this.objetsFacturables = objetsFacturables;
    }
    
    private void ajouterObjetFacturable(ObjetFacturable objetFacturable) {
        this.objetsFacturables.add(objetFacturable);
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
    
}
