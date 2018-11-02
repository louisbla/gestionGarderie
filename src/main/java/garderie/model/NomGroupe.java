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
public enum NomGroupe {
    Trotteur (1, "Trotteur"),
    Bebe (2, "Bebe"),
    Moyen (3, "Moyen");
    
    private int id;
    private String libelle = "";
    private static Map map = new HashMap<>();

    private NomGroupe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    static {
        for (NomGroupe nomGroupe : NomGroupe.values()) {
            map.put(nomGroupe.id, nomGroupe);
        }
    }
    
    public static NomGroupe valueOf(int nomGroupe) {
        return (NomGroupe) map.get(nomGroupe);
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    public int getId() {
        return id;
    }
    
    
    
    
    
}
