package garderie.model;

import java.io.Serializable;

/**
 *
 * @author Maryline
 */
public class Article implements Serializable{
    
    private int idArticle;
    private String nom;
    private int quantite;
    private String  photo;
    private boolean visible;
    private String description;
    private CategorieArticle categorie;

    public Article() {
    }

    public Article(String nom, int quantite, String photo, String description, CategorieArticle c ) {
        this.nom = nom;
        this.quantite = quantite;
        this.photo = photo;
        this.visible = true;
        this.description = description;
        this.categorie = c; 
    }

    public Article(Article a){
        this.idArticle = a.getIdArticle();
        this.nom = a.getNom();
        this.quantite = a.getQuantite();
        this.photo = a.getPhoto();
        this.visible = true;
        this.description = a.getDescription();
        this.categorie = a.getCategorie();
    }
    
    public int getIdArticle() {
        return this.idArticle;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public CategorieArticle getCategorie() {
        return this.categorie;
    }

    public void setCategorie(CategorieArticle categorie) {
        this.categorie = categorie;
    }
    
}
