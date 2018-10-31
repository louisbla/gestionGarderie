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
public class RapportJournalier implements Serializable {
    private int idRapportJournalier;
    private Date dateRapport;
    private boolean present;
    private String resumeJournee;
    private DossierInscription dossierenfant;
    private boolean visible;

    public RapportJournalier() {
    }

    public RapportJournalier(Date dateRapport, boolean present, String resumeJournee, DossierInscription enfant) {
        this.dateRapport = dateRapport;
        this.present = present;
        this.resumeJournee = resumeJournee;
        this.dossierenfant = enfant;
        this.visible = true;
    }

    public int getIdRapportJournalier() {
        return idRapportJournalier;
    }

    public void setIdRapportJournalier(int idRapportJournalier) {
        this.idRapportJournalier = idRapportJournalier;
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

    public DossierInscription getDossierInscription() {
        return dossierenfant;
    }

    public void setDossierInscription(DossierInscription enfant) {
        this.dossierenfant = enfant;
    }


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
     
}
