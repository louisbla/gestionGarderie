package garderie.model;
import java.util.*;
import garderie.model.*;
import java.io.Serializable;
/**
 *
 * @author Maryline
 */
public class Inventaire implements Serializable {
    private int idInventaire;
    private int stockMax;
    private int stockActuel = 0;
    private ArrayList<Article> listeArticles = new ArrayList<>();
    private boolean visible = true;

    public Inventaire() {
    }

    public Inventaire(int stockMax) {
        this.stockMax = stockMax;
    }
    
      public Inventaire(int stockMax, ArrayList<Article> listeArticle) {
        this.stockMax = stockMax;
        this.listeArticles = listeArticle;
        this.stockActuel = this.listeArticles.size();
    }
    
    public int getIdInventaire() {
        return this.idInventaire;
    }

    public void setIdInventaire(int idInventaire) {
        this.idInventaire = idInventaire;
    }

    public int getStockMax() {
        return this.stockMax;
    }

    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }

    public int getStockActuel() {
        return this.stockActuel;
    }

    public void setStockActuel(int stockActuel) {
        this.stockActuel = stockActuel;
    }


    public ArrayList<Article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(ArrayList<Article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
   
    
    public void ajoutArticle(Article art){
        this.listeArticles.add(art);
    }
    
    public void supprimerArtcile(Article a){
        this.listeArticles.remove(a);
    }
}
