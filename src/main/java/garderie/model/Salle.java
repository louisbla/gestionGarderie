/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;

/**
 *
 * @author Katsuo
 */
public class Salle implements Serializable {
    private int idSalle;
    private String libelleSalle;
    private int capaciteMax;
    private boolean occupe;

    public Salle() {
    }

    public Salle(String libelleSalle, int capaciteMax, boolean occupe) {
        this.libelleSalle = libelleSalle;
        this.capaciteMax = capaciteMax;
        this.occupe = occupe;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getLibelleSalle() {
        return libelleSalle;
    }

    public void setLibelleSalle(String libelleSalle) {
        this.libelleSalle = libelleSalle;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }
    
    
    
    
    
}
