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
public class Traitement {
    private Maladie maladie;
    private Enfant enfant;
    private String nomMedicament;
    private String specification;
    private String type;
    private double quantite;
    private int frequence;

    public Traitement(Maladie maladie, Enfant enfant, String nomMedicament, String specification, String type, double quantite, int frequence) {
        this.maladie = maladie;
        this.enfant = enfant;
        this.nomMedicament = nomMedicament;
        this.specification = specification;
        this.type = type;
        this.quantite = quantite;
        this.frequence = frequence;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
    
    
}
