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
public class ShowEmployeAction extends ActionSupport {
    private ArrayList<Employe> employes;

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }

    @Override
    public String execute() throws Exception {
        Connection connection = FactoryBDDManagerInstance.getInstance(new BDDManagerMySQL()).connect();
        employes = new ArrayList<>();
        EmployeDAO employeDAO = new EmployeDAO(connection);
        employes = employeDAO.findAll();
        
        return SUCCESS;
    }
    
}
