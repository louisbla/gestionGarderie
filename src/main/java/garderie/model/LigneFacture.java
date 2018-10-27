
package garderie.model;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Katsuo
 */
public class LigneFacture implements Serializable {
    private int idLigneFacture;
    private double totalTTC;
    private double totalHT;
    private int quantite;
    private Facture facture;
    private ObjetFacturable objetsFacturable;
    private boolean visible;

    public LigneFacture() {
    }

    public LigneFacture( int quantite,
            Facture facture, ObjetFacturable obj) {
        this.quantite = quantite;
        this.facture = facture;
        this.objetsFacturable = obj;
        this.visible = true;
        this.totalHT = this.objetsFacturable.getPrixHT() * this.quantite;
        this.totalTTC = calculTotalTTC();
    }

    public int getIdLigneFacture() {
        return idLigneFacture;
    }

    public double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(double totalTTC) {
        this.totalTTC = totalTTC;
    }

    public double getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(double totalHT) {
        this.totalHT = totalHT;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public ObjetFacturable getObjetsFacturable() {
        return objetsFacturable;
    }

    public void setObjetsFacturable(ObjetFacturable objetsFacturable) {
        this.objetsFacturable = objetsFacturable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public double calculTotalTTC(){
        return this.totalTTC = this.totalHT * this.objetsFacturable.getTva().getMontant();      
    }
}