/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Employe extends Personne implements Serializable {
        private int idEmploye;
        private String numTel;
        private double nbHeuresPrevues;
        private String poste;
        private boolean externe;
        private double nbHeuresReel;
        private ArrayList<Conge> listeConge;
        private boolean visible;
        private DossierEmploye dossier;

    public Employe() {
    }

    public Employe(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<Adresse> adresses, CompteUser compteUser, String numTel, double nbHeuresPrevues,  String poste,  boolean externe, DossierEmploye dossier) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses, compteUser);
        this.numTel = numTel;
        this.nbHeuresPrevues = nbHeuresPrevues;
        this.poste = poste;
        this.externe = externe;
        this.nbHeuresReel = 0;
        this.listeConge = new ArrayList();
        this.dossier = dossier;
        this.visible = true;
    }

    public int getIdEmploye() {
        return idEmploye;
    }


    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }



    public double getNbHeuresPrevues() {
        return nbHeuresPrevues;
    }

    public void setNbHeuresPrevues(double nbHeuresPrevues) {
        this.nbHeuresPrevues = nbHeuresPrevues;
    }


    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public boolean isExterne() {
        return externe;
    }

    public void setExterne(boolean externe) {
        this.externe = externe;
    }


    public double getNbHeuresReel() {
        return nbHeuresReel;
    }

    public void setNbHeuresReel(double nbHeuresReel) {
        this.nbHeuresReel = nbHeuresReel;
    }

    public ArrayList<Conge> getListeConge() {
        return listeConge;
    }

    public void setListeConge(ArrayList<Conge> listeConge) {
        this.listeConge = listeConge;
    }
        
    public void ajouterConge(Date dateDebut, int duree, TypeConge typeConge){
        Conge c = new Conge(duree,dateDebut,typeConge);
        this.listeConge.add(c);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public DossierEmploye getDossier() {
        return dossier;
    }

    public void setDossier(DossierEmploye dossier) {
        this.dossier = dossier;
    }
 
    
    
}
