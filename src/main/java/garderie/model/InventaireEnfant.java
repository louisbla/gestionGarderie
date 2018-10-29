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
    private ArrayList<Article> listeArticleEnfant = new ArrayList<> ();
    private boolean visible = true;

    public InventaireEnfant() {
    }

    public InventaireEnfant(ArrayList<Article> listeArticleEnfant) {
        this.listeArticleEnfant = listeArticleEnfant;
        this.visible = true;
    }

    public int getIdInventaire() {
        return this.idInventaire;
    }

    public void setIdInventaire(int idInventaire) {
        this.idInventaire = idInventaire;
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
