package garderie.model;
import java.util.*;
import garderie.model.*;
/**
 *
 * @author Maryline
 */
public class Inventaire {
    private int idInventaire;
    private int stockMax;
    private int stockActuel;
    private ArrayList<Article> listeArticle;

    public Inventaire(int stockMax, int stockActuel) {
        this.stockMax = stockMax;
        this.stockActuel = stockActuel;
    }

    public int getIdInventaire() {
        return this.idInventaire;
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
    
    public void ajoutArticle(Article a){
        Article art = new Article(a);
        this.listeArticle.add(art);
    }
    
    public void ajoutArticle(String nom, int quantite, String photo, String descrip, CategorieArticle c){
        Article art = new Article(nom,quantite,photo,descrip, c);
        this.listeArticle.add(art);
    
    }
    public void supprimerArtcile(Article a){
        this.listeArticle.remove(a); 
    }
   
}
