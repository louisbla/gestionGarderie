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
    TempsComplet ("Temps complet"),
    TempsPartiel ("Temps partiel");
    
    private String libelle = "";

    private TypeContrat(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
}
