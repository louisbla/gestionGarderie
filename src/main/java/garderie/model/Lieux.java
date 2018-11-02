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
public class Lieux implements Serializable {
    private int idLieux;
    private String libelle;
    private boolean occupe;
    private boolean visible;

    public Lieux() {
    }

    public Lieux(String libelleSalle, boolean occupe) {
        this.libelle = libelleSalle;
        this.occupe = occupe;
        this.visible = true;
    }

    public int getIdLieux() {
        return idLieux;
    }
    
    public void setIdLieux(int idLieux) {
        this.idLieux = idLieux;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
