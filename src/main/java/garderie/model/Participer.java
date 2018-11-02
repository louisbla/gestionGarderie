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
public class Participer implements Serializable {
    private Groupe groupe;
    private Lieux salle;
    private Activite activite;
    private Date date;
    private boolean visible;

    public Participer() {
    }

    public Participer(Groupe groupe, Lieux salle, Activite activite, Date date) {
        this.groupe = groupe;
        this.salle = salle;
        this.activite = activite;
        this.date = date;
        this.visible = true;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Lieux getSalle() {
        return salle;
    }

    public void setSalle(Lieux salle) {
        this.salle = salle;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
 
}
