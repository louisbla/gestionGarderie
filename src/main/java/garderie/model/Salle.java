/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.ArrayList;

/**
 *
 * @author Katsuo
 */
public class Salle {
    private int idSalle;
    private String libelleSalle;
    private int capaciteMax;
    private boolean occupe;

    public Salle(String libelleSalle, int capaciteMax, boolean occupe, ArrayList<Activite> activites) {
        this.libelleSalle = libelleSalle;
        this.capaciteMax = capaciteMax;
        this.occupe = occupe;
    }
    
    
    
}
