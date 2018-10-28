
package garderie.model;
import java.io.Serializable;

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
    private ObjetFacturable objetFacturable;
    private boolean visible;

    public LigneFacture() {
    }

    public LigneFacture( int quantite,
            Facture facture, ObjetFacturable obj) {
        this.quantite = quantite;
        this.facture = facture;
        this.objetFacturable = obj;
        this.visible = true;
        this.totalHT = this.objetFacturable.getPrixHT() * this.quantite;
        this.totalTTC = this.totalHT * this.objetFacturable.getTva().getMontant();
    }

    public int getIdLigneFacture() {
        return idLigneFacture;
    }

    public void setIdLigneFacture(int idLigneFacture) {
        this.idLigneFacture = idLigneFacture;
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
        return objetFacturable;
    }

    public void setObjetsFacturable(ObjetFacturable objetFacturable) {
        this.objetFacturable = objetFacturable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public double calculTotalTTC(){
        return this.totalTTC = this.totalHT * this.objetFacturable.getTva().getMontant();      
    }
}