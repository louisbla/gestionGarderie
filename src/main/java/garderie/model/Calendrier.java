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
    private int dateDebut;
    private int dateFin;
    private ArrayList<Horaire> horaires;
    private boolean visible;

    public Calendrier() {
    }

    public Calendrier(int debut, int fin) {
        this.dateDebut = debut;
        this.dateFin = fin;
        this.horaires = new ArrayList<>();
        this.visible = true;
    }
    

    public Calendrier(int debut, int fin, ArrayList<Horaire> horaires) {
        this.dateDebut = debut;
        this.dateFin = fin;
        this.horaires = horaires;
        this.visible = true;
    }

    public int getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(int idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    public int getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(int Debut) {
        this.dateDebut = Debut;
    }

    public int getDateFin() {
        return dateFin;
    }

    public void setDateFin(int dateFin) {
        this.dateFin = dateFin;
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
    
    public void ajouterHoraire(Horaire h){
        this.horaires.add(h);
    }
    
    public void supprimerHoraire(Horaire h){
        this.horaires.remove(h);
    }
    
}
