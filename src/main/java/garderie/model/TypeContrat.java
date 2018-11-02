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
 * @author Katsuo
 */
public enum TypeContrat {
    CDD (1, "CDD"),
    Interim (2, "CDI"),
    CDI (3, "Interim");
    
    private int id;
    private String libelle = "";
    private static Map map = new HashMap<>();

    private TypeContrat(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    static {
        for (TypeContrat typeContrat : TypeContrat.values()) {
            map.put(typeContrat.id, typeContrat);
        }
    }
    
    public static TypeContrat valueOf(int typeContrat) {
        return (TypeContrat) map.get(typeContrat);
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    public int getId() {
        return id;
    }
    
    
}
