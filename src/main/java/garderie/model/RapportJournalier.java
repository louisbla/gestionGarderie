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
public class RapportJournalier implements Serializable {
    private int idRapportJournalier;
    private Date dateRapport;
    private boolean present;
    private String resumeJournee;
    private Enfant enfant;
    private ArrayList<Employe> referants;
    private boolean visible;

    public RapportJournalier() {
    }

    public RapportJournalier(Date dateRapport, boolean present, String resumeJournee, Enfant enfant, ArrayList<Employe> referants) {
        this.dateRapport = dateRapport;
        this.present = present;
        this.resumeJournee = resumeJournee;
        this.enfant = enfant;
        this.referants = referants;
        this.visible = true;
    }

    public int getIdRapportJournalier() {
        return idRapportJournalier;
    }

    public Date getDateRapport() {
        return dateRapport;
    }

    public void setDateRapport(Date dateRapport) {
        this.dateRapport = dateRapport;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getResumeJournee() {
        return resumeJournee;
    }

    public void setResumeJournee(String resumeJournee) {
        this.resumeJournee = resumeJournee;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public ArrayList<Employe> getReferants() {
        return referants;
    }

    public void setReferants(ArrayList<Employe> referants) {
        this.referants = referants;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
     
}
