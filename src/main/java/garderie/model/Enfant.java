/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.ArrayList;
import java.util.Date;


public class Enfant extends Personne{
    private boolean visible;
    private String photo;   //url

    
    //Constructeur
    public Enfant(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<Adresse> adresses, String photo) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses);
        this.visible = true;
        this.photo = photo;
    }
        
    public boolean isVisible() {
        return visible;
    }

    public String getPhoto() {
        return photo;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
}
