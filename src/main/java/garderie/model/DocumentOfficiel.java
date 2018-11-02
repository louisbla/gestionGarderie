/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;

/**
 *
 * @author Maryline
 */
public class DocumentOfficiel implements Serializable {
    
    private int idDocument;
    private String nom;
    private String url;
    private boolean visible = true;
    private DossierInscription dossier;
    

    public DocumentOfficiel() {
    }
    
    public DocumentOfficiel(String nom, String url, DossierInscription d) {
        this.nom = nom;
        this.url = url;
        this.dossier = d;
    }

    public int getIdDocument() {
        return this.idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return this.url;
    }

    public DossierInscription getDossier() {
        return dossier;
    }

    public void setDossier(DossierInscription dossier) {
        this.dossier = dossier;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
