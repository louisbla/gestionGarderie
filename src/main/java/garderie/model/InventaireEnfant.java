/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Maryline
 */
public class InventaireEnfant implements Serializable {
    private int idInventaire;
    private int stockMax;
    private int stockActuel;
    private ArrayList<Article> listeArticleEnfant;
    private boolean visible;

    public InventaireEnfant() {
    }

    public InventaireEnfant(int stockMax) {
        this.stockMax = stockMax;
        this.stockActuel = 0;
        this.listeArticleEnfant = new ArrayList<Article>();
        this.visible = true;
    }

    public InventaireEnfant(int stockMax, ArrayList<Article> listeArticleEnfant) {
        this.stockMax = stockMax;
        this.listeArticleEnfant = listeArticleEnfant;
        this.stockActuel = this.listeArticleEnfant.size();
        this.visible = true;
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

    public ArrayList<Article> getListeArticleEnfant() {
        return this.listeArticleEnfant;
    }

    public void setListeArticleEnfant(ArrayList<Article> listeArticleEnfant) {
        this.listeArticleEnfant = listeArticleEnfant;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    public void ajoutArticle(Article a){
        this.listeArticleEnfant.add(a);
    }
    

    public void supprimerArtcile(Article a){
        this.listeArticleEnfant.remove(a);
    }
   
 
    
}
