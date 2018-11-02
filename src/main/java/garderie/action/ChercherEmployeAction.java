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
    private ArrayList<Employe> employesTrouves;
    private String motCle;

    public ArrayList<Employe> getEmployesTrouves() {
        return employesTrouves;
    }

    public void setEmployesTrouves(ArrayList<Employe> employesTrouves) {
        this.employesTrouves = employesTrouves;
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
        employesTrouves = new ArrayList<>();
        
        EmployeDAO employeDAO = new EmployeDAO(connection);
        employesTrouves = employeDAO.findByName(motCle);
        System.out.println(employesTrouves.size());
        
        return SUCCESS;
    }
    
    
    
}
