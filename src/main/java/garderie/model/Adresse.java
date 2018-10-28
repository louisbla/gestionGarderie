/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;


public class Adresse implements Serializable {
    private int idAdresse;
    private boolean facturation; 
    private boolean domicile;
    private String ligne1;
    private String ligne2;
    private String ligne3;
    private String ville;
    private String codePostal;
    private String pays;
    private boolean visible;

    public Adresse() {
    }
    
    //Constructeur 
    public Adresse(boolean facturation, boolean domicile, String ligne1, String ligne2, String ligne3, String ville, String codePostale, String pays) {
        this.facturation = facturation;
        this.domicile = domicile;
        this.ligne1 = ligne1;
        this.ligne2 = ligne2;
        this.ligne3 = ligne3;
        this.ville = ville;
        this.codePostal = codePostale;
        this.pays = pays;
        this.visible = true;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }
    

    public boolean isFacturation() {
        return facturation;
    }

    public boolean isDomicile() {
        return domicile;
    }

    public String getLigne1() {
        return ligne1;
    }

    public String getLigne2() {
        return ligne2;
    }

    public String getLigne3() {
        return ligne3;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostale() {
        return codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setFacturation(boolean facturation) {
        this.facturation = facturation;
    }

    public void setDomicile(boolean domicile) {
        this.domicile = domicile;
    }

    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public void setLigne3(String ligne3) {
        this.ligne3 = ligne3;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostale(String codePostale) {
        this.codePostal = codePostale;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
}
