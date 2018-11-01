/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.LigneFactureDAO;
import garderie.dao.ObjetFacturableDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.LigneFacture;
import garderie.model.ObjetFacturable;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Katsuo
 */
public class ShowLignesFactureAction extends ActionSupport {
    private ArrayList<LigneFacture> lignesFacture;
    private ObjetFacturable objetFacturable;
    int idFacture;

    public ArrayList<LigneFacture> getLignesFacture() {
        return lignesFacture;
    }

    public void setLignesFacture(ArrayList<LigneFacture> lignesFacture) {
        this.lignesFacture = lignesFacture;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public ObjetFacturable getObjetFacturable() {
        return objetFacturable;
    }

    public void setObjetFacturable(ObjetFacturable objetFacturable) {
        this.objetFacturable = objetFacturable;
    }

    @Override
    public String execute() throws Exception {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        lignesFacture = new ArrayList<>();
        LigneFactureDAO ligneFactureDAO = new LigneFactureDAO(connection);
        lignesFacture = ligneFactureDAO.findAllLignesForFacture(idFacture);
        return SUCCESS;
    }
    
    
}
