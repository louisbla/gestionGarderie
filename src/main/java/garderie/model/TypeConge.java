/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;

/**
 *
 * @author Maryline
 */
public class TypeConge implements Serializable {
    
    private int idTypeConge;
    private String descriptif;

    public TypeConge() {
    }

    public TypeConge(String descriptif) {
        this.descriptif = descriptif;
    }

    public int getIdTypeConge() {
        return this.idTypeConge;
    }

    public String getDescriptif() {
        return this.descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
    
    
    
}
