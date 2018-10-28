/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

/**
 *
 * @author Katsuo
 */
public enum TypeContrat {
    CDD ("CDD"),
    interim ("interim"),
    CDI ("CDI");
    
    private String libelle = "";

    private TypeContrat(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
}
