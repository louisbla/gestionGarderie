/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Maryline
 */
public class Conge implements Serializable {
    
    private int idConge;
    private int dureeCongeJour;
    private Date debutConge;
    private TypeConge typeConge;
    private Employe employe;
    private boolean visible = true;

    public Conge() {
    }

    public Conge(int dureeCongeJour, Date dateDebut, TypeConge typeConge, Employe employe) {
        this.dureeCongeJour = dureeCongeJour;
        this.debutConge = dateDebut;
        this.typeConge = typeConge;
        this.employe = employe;
    }

    public int getIdConge() {
        return this.idConge;
    }
    
    public int getIdEmploye(){
        return this.employe.getIdPersonne();
    }

    public void setIdConge(int idConge) {
        this.idConge = idConge;
    }

    public int getDureeCongeJour() {
        return this.dureeCongeJour;
    }

    public void setDureeCongeJour(int dureeCongeJour) {
        this.dureeCongeJour = dureeCongeJour;
    }

    public Date getDebutConge() {
        return debutConge;
    }

    public void setDebutConge(Date debutConge) {
        this.debutConge = debutConge;
    }

    public TypeConge getTypeConge() {
        return this.typeConge;
    }

    public void setTypeConge(TypeConge typeConge) {
        this.typeConge = typeConge;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
 
}
