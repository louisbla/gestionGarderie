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
public class CategorieArticle implements Serializable {
    
    private int idCategorie;
    private ArrayList<Article> listeArticle;
    private String nom;
    private boolean visible;

    public CategorieArticle() {
    }    

    public CategorieArticle(ArrayList<Article> listeArticle, String nom) {
        this.listeArticle = listeArticle;
        this.nom = nom;
        this.visible = true;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public ArrayList<Article> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(ArrayList<Article> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
    
}
