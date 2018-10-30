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
    private ArrayList<DossierContactUrgence> contactsUrgences = new ArrayList();
    private ArrayList<DocumentOfficiel> documentsOfficiels = new ArrayList();
    private boolean visible = true;
    private ArrayList<RapportJournalier> listeRapports = new ArrayList();

    public DossierInscription() {
    }

    public DossierInscription(Date dateInscription, int nbDemiJourneeInscrit, int nbDemiJourneeAbsent, String medecinTraitant, Enfant enfant, ArrayList<DossierContactUrgence> contactsUrgences, ArrayList<DocumentOfficiel> documentsOfficiels) {
        this.dateInscription = dateInscription;
        this.nbDemiJourneeInscrit = nbDemiJourneeInscrit;
        this.nbDemiJourneeAbsent = nbDemiJourneeAbsent;
        this.medecinTraitant = medecinTraitant;
        this.enfant = enfant;
        this.contactsUrgences = contactsUrgences;
        this.documentsOfficiels = documentsOfficiels;
    }

    

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
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

    public ArrayList<DossierContactUrgence> getContactsUrgences() {
        return contactsUrgences;
    }

    public void setContactsUrgences(ArrayList<DossierContactUrgence> contactsUrgences) {
        this.contactsUrgences = contactsUrgences;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ArrayList<DocumentOfficiel> getDocumentsOfficiels() {
        return documentsOfficiels;
    }

    public void setDocumentsOfficiels(ArrayList<DocumentOfficiel> documentsOfficiels) {
        this.documentsOfficiels = documentsOfficiels;
    }

    public ArrayList<RapportJournalier> getListeRapports() {
        return listeRapports;
    }

    public void setListeRapports(ArrayList<RapportJournalier> listeRapports) {
        this.listeRapports = listeRapports;
    } 
}
