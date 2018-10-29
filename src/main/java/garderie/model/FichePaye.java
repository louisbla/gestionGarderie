/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import java.io.Serializable;
/**
 *
 * @author Maryline
 */
public class FichePaye implements Serializable{
    private  int idFichePaye;
    private double salaireBrut;
    private double nbHeurePrevu;
    private double nbHeureReel;
    private DossierEmploye dossier;
    private boolean visible;

    public FichePaye() {
    }

    public FichePaye(double salaireB, double nbHeurePrevu, double nbHeureReel, DossierEmploye dossier) {
        this.salaireBrut = salaireB;
        this.nbHeurePrevu = nbHeurePrevu;
        this.nbHeureReel = nbHeureReel;
        this.dossier = dossier;
        this.visible = true;
    }

    public int getIdFichePaye() {
        return idFichePaye;
    }

    public void setIdFichePaye(int idFichePaye) {
        this.idFichePaye = idFichePaye;
    }

    public double getNbHeurePrevu() {
        return nbHeurePrevu;
    }

    public void setNbHeurePrevu(double nbHeurePrevu) {
        this.nbHeurePrevu = nbHeurePrevu;
    }

    public double getNbHeureReel() {
        return nbHeureReel;
    }

    public void setNbHeureReel(double nbHeureReel) {
        this.nbHeureReel = nbHeureReel;
    }

    public DossierEmploye getDossier() {
        return dossier;
    }

    public void setDossier(DossierEmploye dossier) {
        this.dossier = dossier;
    }

    public double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void calculSalaireBrut(){
        double tauxBrut = this.dossier.getTauxHoraireBrut();
        if (this.nbHeurePrevu == this.nbHeureReel){
            this.salaireBrut = tauxBrut * this.nbHeurePrevu;
        }else if (this.nbHeureReel > this.nbHeurePrevu){
            double difference = this.nbHeureReel - this.nbHeurePrevu;
            this.salaireBrut = (tauxBrut * this.nbHeurePrevu) + (difference * tauxBrut * 1.5);
        }else{
            this.salaireBrut =  this.nbHeureReel * tauxBrut;
        }     
    }
    
    
}
