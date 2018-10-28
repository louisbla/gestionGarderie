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
 * @author Katsuo
 */
public class Calendrier implements Serializable{
    private int idCalendrier;
    private int anneeDebut;
    private int anneeFin;
    private ArrayList<Horaire> horaires;
    private boolean visible;

    public Calendrier() {
    }

    public Calendrier(int anneeDebut, int anneeFin) {
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
        this.horaires = new ArrayList<>();
        this.visible = true;
    }
    

    public Calendrier(int anneeDebut, int anneeFin, ArrayList<Horaire> horaires) {
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
        this.horaires = horaires;
        this.visible = true;
    }

    public int getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(int idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    public int getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(int anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public int getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(int anneeFin) {
        this.anneeFin = anneeFin;
    }

    public ArrayList<Horaire> getHoraires() {
        return horaires;
    }

    public void setHoraires(ArrayList<Horaire> horaires) {
        this.horaires = horaires;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
    
    
}
