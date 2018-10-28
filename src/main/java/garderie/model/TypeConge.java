/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maryline
 */
public class TypeConge implements Serializable {
    
    private int idTypeConge;
    private String descriptif;
    private boolean visible;
    private ArrayList<Conge> conges;

    public TypeConge() {
    }

    public TypeConge(String descriptif) {
        this.descriptif = descriptif;
        this.visible = true;
    }

    public int getIdTypeConge() {
        return this.idTypeConge;
    }

    public void setIdTypeConge(int idTypeConge) {
        this.idTypeConge = idTypeConge;
    }

    public String getDescriptif() {
        return this.descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
     

    public ArrayList<Conge> getConges() {
        return conges;
    }

    public void setConges(ArrayList<Conge> conges) {
        this.conges = conges;
    }
}
