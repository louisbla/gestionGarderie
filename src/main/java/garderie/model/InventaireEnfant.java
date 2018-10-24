/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.model;
import java.util.*;
/**
 *
 * @author Maryline
 */
public class InventaireEnfant {
    private int idInventaire;
    private int stockMax;
    private int stockActuel;
    private ArrayList<Article> listeArticleEnfant;

    public InventaireEnfant(int stockMax, int stockActuel, ArrayList<Article> listeArticleEnfant) {
        this.stockMax = stockMax;
        this.stockActuel = stockActuel;
        this.listeArticleEnfant = listeArticleEnfant;
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
    
    public void ajoutArticle(Article a){
        Article art = new Article(a);
        this.listeArticleEnfant.add(art);
    }
    
    public void ajoutArticle(String nom, int quantite, String photo, String descrip, CategorieArticle c){
        Article art = new Article(nom,quantite,photo,descrip, c);
        this.listeArticleEnfant.add(art);
    
    }
    public void supprimerArtcile(Article a){
        a.setVisible(false);
    }
   
    public void modifierArticle(Article a){
    }
    
    
}
