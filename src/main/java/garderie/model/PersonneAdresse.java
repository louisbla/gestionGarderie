/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

/**
 *
 * @author Maryline
 */
public class PersonneAdresse {
    
    private boolean facturation;
    private boolean domicile;
    private Adresse adresse;
    private Personne personne;
    private boolean visible;

    public PersonneAdresse() {
    }

    public PersonneAdresse(boolean facturation, boolean domicile, Adresse adresse, Personne personne) {
        this.facturation = facturation;
        this.domicile = domicile;
        this.adresse = adresse;
        this.personne = personne;
        this.visible = true;
    }

    public boolean isFacturation() {
        return facturation;
    }

    public void setFacturation(boolean facturation) {
        this.facturation = facturation;
    }

    public boolean isDomicile() {
        return domicile;
    }

    public void setDomicile(boolean domicile) {
        this.domicile = domicile;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
