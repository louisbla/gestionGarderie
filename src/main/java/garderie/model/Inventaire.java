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
    private int stockActuel;
    private ArrayList<Article> listeArticle;

    public Inventaire() {
    }

    public Inventaire(int stockMax, int stockActuel) {
        this.stockMax = stockMax;
        this.stockActuel = 0;
        this.listeArticle = new ArrayList<Article>();
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
        a.setVisible(false);
    }
   
    public void modifierArticle(Article a){
    }
    
}
