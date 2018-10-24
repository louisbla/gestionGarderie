/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import java.util.*;
/**
 *
 * @author Maryline
 */
public class Conge {
    
    private int idConge;
    private int dureeCongeJour;
    private Date dateretour;
    private TypeConge typeConge;

    public Conge(int dureeCongeJour, Date dateretour, TypeConge typeConge) {
        this.dureeCongeJour = dureeCongeJour;
        this.dateretour = dateretour;
        this.typeConge = typeConge;
    }

    public int getIdConge() {
        return this.idConge;
    }

    public int getDureeCongeJour() {
        return this.dureeCongeJour;
    }

    public void setDureeCongeJour(int dureeCongeJour) {
        this.dureeCongeJour = dureeCongeJour;
    }

    public Date getDateretour() {
        return this.dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public TypeConge getTypeConge() {
        return this.typeConge;
    }

    public void setTypeConge(TypeConge typeConge) {
        this.typeConge = typeConge;
    }
    
    
    
    
}
