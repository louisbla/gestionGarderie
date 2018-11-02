/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.FactureDAO;
import garderie.dao.ParentFactureDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Facture;
import garderie.model.Parent;
import garderie.model.ParentFacture;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Katsuo
 */
public class ShowFactureAction extends ActionSupport {
    private ArrayList<Facture> factures;
    private ArrayList<Parent> parents;

    public ArrayList<Facture> getFactures() {
        return factures;
    }

    public void setFactures(ArrayList<Facture> factures) {
        this.factures = factures;
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public String execute() throws Exception {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        factures = new ArrayList<>();
        FactureDAO factureDAO = new FactureDAO(connection);
        factures = factureDAO.findAll();
        
        parents = new ArrayList<>();
        ParentFactureDAO parentFactureDAO = new ParentFactureDAO(connection);
        parents = parentFactureDAO.getAllParentByIdFacture(factures.get(0).getIdFacture());
        System.out.println(parents.get(0).getNom());
        return SUCCESS;
    }
    
    
    
}
