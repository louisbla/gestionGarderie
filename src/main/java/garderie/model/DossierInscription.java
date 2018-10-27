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
public class DossierInscription implements Serializable {
    private int idDossier;
    private Date dateInscription;
    private int nbDemiJourneeInscrit;
    private int nbDemiJourneeAbsent;
    private String medecinTraitant;
    private Enfant enfant;
    private ArrayList<ContactUrgence> contactsUrgences;
    private ArrayList<DocumentOfficiel> documentsOfficiels;
    private boolean visible;

    public DossierInscription() {
    }

    public DossierInscription(Date dateInscription, int nbDemiJourneeInscrit, int nbDemiJourneeAbsent, String medecinTraitant) {
        this.dateInscription = dateInscription;
        this.nbDemiJourneeInscrit = nbDemiJourneeInscrit;
        this.nbDemiJourneeAbsent = nbDemiJourneeAbsent;
        this.medecinTraitant = medecinTraitant;
        this.visible = true;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public int getNbDemiJourneeInscrit() {
        return nbDemiJourneeInscrit;
    }

    public void setNbDemiJourneeInscrit(int nbDemiJourneeInscrit) {
        this.nbDemiJourneeInscrit = nbDemiJourneeInscrit;
    }

    public int getNbDemiJourneeAbsent() {
        return nbDemiJourneeAbsent;
    }

    public void setNbDemiJourneeAbsent(int nbDemiJourneeAbsent) {
        this.nbDemiJourneeAbsent = nbDemiJourneeAbsent;
    }

    public String getMedecinTraitant() {
        return medecinTraitant;
    }

    public void setMedecinTraitant(String medecinTraitant) {
        this.medecinTraitant = medecinTraitant;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public ArrayList<ContactUrgence> getContactsUrgences() {
        return contactsUrgences;
    }

    public void setContactsUrgences(ArrayList<ContactUrgence> contactsUrgences) {
        this.contactsUrgences = contactsUrgences;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
}
