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
public class Maladie {
    private int idMaladie;
    private String nom;
    private String descriptif;

    public Maladie(String nom, String descriptif) {
        this.nom = nom;
        this.descriptif = descriptif;
    }

    public int getIdMaladie() {
        return idMaladie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
    
    
}
