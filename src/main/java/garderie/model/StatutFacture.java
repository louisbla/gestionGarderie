/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maryline
 */
public enum StatutFacture{
    Payée (1, "payee"),
    EnAttenteDePaiement (2, "en attente de paiement"),
    EnRetard (3, "en retard");
    
    private int id;
    private String libelle = "";
    private static Map map = new HashMap<>();

    private StatutFacture(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    static {
        for (StatutFacture statutFacture : StatutFacture.values()) {
            map.put(statutFacture.id, statutFacture);
        }
    }
    
    public static StatutFacture valueOf(int statutFacture) {
        return (StatutFacture) map.get(statutFacture);
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    public int getId() {
        return id;
    }
    
    
}
