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
    private boolean visible = true;
    private String description;
    private Inventaire inventaire;
    private CategorieArticle categorie;

    public Article() {
    }

    public Article(String nom, int quantite, String photo, String description, CategorieArticle c ) {
        this.nom = nom;
        this.quantite = quantite;
        this.photo = photo;
        this.description = description;
        this.categorie = c; 
        this.categorie.getListeArticle().add(this);
    }
    
    public int getIdArticle() {
        return this.idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }
    
    
    public CategorieArticle getCategorie() {
        return this.categorie;
    }

    public void setCategorie(CategorieArticle categorie) {
        this.categorie.getListeArticle().remove(this);
        this.categorie = categorie;
        this.categorie.getListeArticle().add(this);
    }
    
}
