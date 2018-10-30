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
public class DossierContactUrgence {
    private ContactUrgence contactUrgence;
    private DossierInscription dossierInscription;
    private String lienParente;
    private boolean visible = true;

    public DossierContactUrgence() {
    }

    public DossierContactUrgence( ContactUrgence contactUrgence, DossierInscription dossierInscription, String lienParente) {
        this.contactUrgence = contactUrgence;
        this.dossierInscription = dossierInscription;
        this.lienParente = lienParente;
    }

 
   
    public ContactUrgence getContactUrgence() {
        return contactUrgence;
    }

    public void setContactUrgence(ContactUrgence contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }

    public DossierInscription getDossierInscription() {
        return dossierInscription;
    }

    public void setDossierInscription(DossierInscription dossierInscription) {
        this.dossierInscription = dossierInscription;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
