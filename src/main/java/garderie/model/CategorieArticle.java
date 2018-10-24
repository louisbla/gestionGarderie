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
public class CategorieArticle {
    
    public int idCategorie;
    public ArrayList<Article> listeArticle;
    public String nom;

    public CategorieArticle(ArrayList<Article> listeArticle, String nom) {
        this.listeArticle = listeArticle;
        this.nom = nom;
    }

    public int getIdCategorie() {
        return idCategorie;
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
    
    
    
    
}
