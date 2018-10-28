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
public enum NomGroupe {
    Trotteur ("Trotteur"),
    Bebe ("Bebe"),
    Moyen ("Moyen");
    
    private String libelle = "";

    NomGroupe(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
    
}
