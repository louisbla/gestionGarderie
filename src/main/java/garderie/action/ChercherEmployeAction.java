/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.action;

import com.opensymphony.xwork2.ActionSupport;
import garderie.dao.EmployeDAO;
import garderie.db.BDDManagerMySQL;
import garderie.db.FactoryBDDManagerInstance;
import garderie.model.Employe;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Katsuo
 */
public class ChercherEmployeAction extends ActionSupport {
    private ArrayList<Employe> employes;
    private String motCle;

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }
    
    @Override
    public String execute() throws Exception {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        employes = new ArrayList<>();
        
        EmployeDAO employeDAO = new EmployeDAO(connection);
        employes = employeDAO.findByName(motCle);
        
        return SUCCESS;
    }
    
    
    
}
