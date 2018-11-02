/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import garderie.dao.CompteUserDAO;
import garderie.dao.PersonneDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.CompteUser;
import garderie.model.Personne;
import java.sql.Connection;

/**
 *
 * @author Katsuo
 */
public class UpdateCompteUserAction extends ActionSupport {
    private CompteUser compteUser;
    private Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
    private CompteUserDAO compteUserDAO = new CompteUserDAO(connection);
    private Personne personne;
    private PersonneDAO personneDAO = new PersonneDAO(connection);
    
    private String nom, prenom, login, mdp, sexe;

    public CompteUser getCompteUser() {
        return compteUser;
    }

    public void setCompteUser(CompteUser compteUser) {
        this.compteUser = compteUser;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    

    @Override
    public String execute() throws Exception {
        compteUser = (CompteUser) ActionContext.getContext().getSession().get("user");
        compteUser.setLogin(login);
        compteUser.setMdp(mdp);
        compteUser = compteUserDAO.update(compteUser);
        personne = compteUser.getPersonne();
        personne.setPrenom(prenom);
        personne.setNom(nom);
        personne.setSexe(sexe);
        personne = personneDAO.update(personne);
        addActionMessage("Modification effectuee!");
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (nom.length() == 0) {
            addFieldError("nom", "Le nom est requis!");
        }
        if (prenom.length() == 0) {
            addFieldError("prenom", "Le prenom est requis!");
        }
        if (login.length() == 0) {
            addFieldError("login", "Le login est requis!");
        }
        if (mdp.length() == 0) {
            addFieldError("mdp", "Le mot de passe est requis!");
        }
        if (sexe.length() == 0) {
            addFieldError("sexe", "Veuillez faire un choix!");
        }
        
    }
    
    
    
    
    
}
