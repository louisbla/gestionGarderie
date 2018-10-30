/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

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
        private double tauxHoraireBrut;
        private boolean visible = true;
        private ArrayList<Conge> listeConge = new ArrayList();
        private ArrayList<FichePaye> listeFichePaye = new ArrayList();
                
    public DossierEmploye(){
        
    }

    public DossierEmploye(Employe em, Date dateEntree, double nbMoisAnciennete,
            TypeContrat typeContrat,double tauxHoraireBrut) {
        this.employe = em;
        this.dateEntree = dateEntree;
        this.nbMoisAnciennete = nbMoisAnciennete;
        this.typeContrat = typeContrat;
        this.tauxHoraireBrut = tauxHoraireBrut;
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

     
    public double getTauxHoraireBrut() {
        return tauxHoraireBrut;
    }

    public void setTauxHoraireBrut(double tauxHoraireBrut) {
        this.tauxHoraireBrut = tauxHoraireBrut;
    }
    

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public ArrayList<FichePaye> getListeFichePaye() {
        return listeFichePaye;
    }

    public void setListeFichePaye(ArrayList<FichePaye> listeFichePaye) {
        this.listeFichePaye = listeFichePaye;
    }

}
