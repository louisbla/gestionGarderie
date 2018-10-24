/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.*;

/**
 *
 * @author Katsuo
 */
public class Horaire {
    private int idHoraire;
    private Date date;
    private double heureDebut;
    private double heureFin;

    public Horaire(Date date, double heureDebut, double heureFin) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdHoraire() {
        return idHoraire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(double heureDebut) {
        this.heureDebut = heureDebut;
    }

    public double getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(double heureFin) {
        this.heureFin = heureFin;
    }
    
    
}
