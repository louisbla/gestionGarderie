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
    Individuel_de_formation ("Individuel de formation"),
    Paye ("Paye"),
    Maternite ("Maternite"),
    Paternite ("Paternite"),
    Sabbatique ("Sabbatique"),
    Raison_familiale ("Raison familiale"),
    Parental_education ("Parental education"),
    Reclassement ("Reclassement"),
    Adoption ("Adoption"),
    Longue_Maladie ("Longue Maladie"),
    Engagement_associatif ("Engagement associatif");
    
    private String libelle = "";

    private TypeConge(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
