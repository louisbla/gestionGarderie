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
public enum TypeConge {
    Individuel_de_formation (1, "Individuel de formation"),
    Paye (2, "Paye"),
    Maternite (3, "Maternite"),
    Paternite (4, "Paternite"),
    Sabbatique (5, "Sabbatique"),
    Raison_familiale (6, "Raison familiale"),
    Parental_education (7, "Parental education"),
    Reclassement (8, "Reclassement"),
    Adoption (9, "Adoption"),
    Longue_Maladie (10, "Longue Maladie"),
    Engagement_associatif (11, "Engagement associatif");
    
    private int id;
    private String libelle = "";

    private TypeConge(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }

    public int getId(){
        return id;
    }
    
    public static TypeConge findById(int id){
        for(TypeConge type : TypeConge.values()){
            if(type.getId() == id){
                return type;
            }
        }
        return null; 
    }
}
