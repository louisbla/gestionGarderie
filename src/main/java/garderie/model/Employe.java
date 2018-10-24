/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.util.ArrayList;
import java.util.Date;


public class Employe extends Personne {
        private int idEmploye;
        private String numTel;
        private double salaireNet;
        private double nbHeuresPrevues;
        private double tauxHoraireBrut;
        private String poste;
        private double tauxHoraireNet;
        private boolean externe;
        private Date dateEntree; 
        private double nbMoisAnciennete; 
        private double nbHeuresReel;

    public Employe(String Nom, String Prenom, String Sexe, Date DateNaissance, String numSecu, ArrayList<Adresse> adresses, CompteUser compteUser, String numTel, double salaireNet, double nbHeuresPrevues, double tauxHoraireBrut, String poste, double tauxHoraireNet, boolean externe, Date dateEntree, double nbMoisAnciennete) {
        super(Nom, Prenom, Sexe, DateNaissance, numSecu, adresses, compteUser);
        this.numTel = numTel;
        this.salaireNet = salaireNet;
        this.nbHeuresPrevues = nbHeuresPrevues;
        this.tauxHoraireBrut = tauxHoraireBrut;
        this.poste = poste;
        this.tauxHoraireNet = tauxHoraireNet;
        this.externe = externe;
        this.dateEntree = dateEntree;
        this.nbMoisAnciennete = nbMoisAnciennete;
        this.nbHeuresReel = 0;
    }
        
        
}
