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
public enum StatutFacture{
    Payee ("payee"),
    EnAttenteDePaiement ("attente"),
    EnRetard ("retard");
    
    private String libelle = "";

    private StatutFacture(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
    
    
}
