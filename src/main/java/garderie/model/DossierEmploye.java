/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maryline
 */
public class DossierEmploye implements Serializable{
        private int idDossierEmploye;
        private Employe employe;
        private Date dateEntree; 
        private double nbMoisAnciennete;
        private TypeContrat typeContrat;
        private double salaireNet;
        private double tauxHoraireBrut;
        private double tauxHoraireNet;
        private boolean visible;
                
    public DossierEmploye(){
        
    }

    public DossierEmploye(Employe em, Date dateEntree, double nbMoisAnciennete,
            TypeContrat typeContrat, double salaireNet, double tauxHoraireBrut,
            double tauxHoraireNet) {
        this.employe = em;
        this.dateEntree = dateEntree;
        this.nbMoisAnciennete = nbMoisAnciennete;
        this.typeContrat = typeContrat;
        this.salaireNet = salaireNet;
        this.tauxHoraireBrut = tauxHoraireBrut;
        this.tauxHoraireNet = tauxHoraireNet;
        this.visible = true;
    }

    public int getIdDossierEmploye() {
        return idDossierEmploye;
    }

    public void setIdDossierEmploye(int idDossierEmploye) {
        this.idDossierEmploye = idDossierEmploye;
    }
    
    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
        
    
    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public double getNbMoisAnciennete() {
        return nbMoisAnciennete;
    }

    public void setNbMoisAnciennete(double nbMoisAnciennete) {
        this.nbMoisAnciennete = nbMoisAnciennete;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }
    
    public double getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(double salaireNet) {
        this.salaireNet = salaireNet;
    }
     
    public double getTauxHoraireBrut() {
        return tauxHoraireBrut;
    }

    public void setTauxHoraireBrut(double tauxHoraireBrut) {
        this.tauxHoraireBrut = tauxHoraireBrut;
    }
    
    public double getTauxHoraireNet() {
        return tauxHoraireNet;
    }

    public void setTauxHoraireNet(double tauxHoraireNet) {
        this.tauxHoraireNet = tauxHoraireNet;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
   
    
}
