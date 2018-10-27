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
    private boolean visible;
    

    public DocumentOfficiel() {
    }
    
    public DocumentOfficiel(String nom, String url) {
        this.nom = nom;
        this.url = url;
        this.visible = true;
    }

    public int getIdDocument() {
        return this.idDocument;
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
