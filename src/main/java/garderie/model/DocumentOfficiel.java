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
public class DocumentOfficiel {
    
    private int idDocument;
    private String nom;
    private String url;

    public DocumentOfficiel(String nom, String url) {
        this.nom = nom;
        this.url = url;
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
    
    
    
}
