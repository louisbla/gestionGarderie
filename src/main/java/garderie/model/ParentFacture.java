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
public class ParentFacture {
    
    private Parent parent;
    private Facture facture;
    private boolean visible;

    public ParentFacture() {
    }

    public ParentFacture(Parent parent, Facture facture) {
        this.parent = parent;
        this.facture = facture;
        this.visible = true;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
  
    
}
