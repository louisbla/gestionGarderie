/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.db;

import java.sql.Connection;

/**
 *
 * @author dendaneys
 */
public class FactoryBDDManager {

    private Manager manager;

    public FactoryBDDManager(Manager manager) {
        this.manager = manager;
    }

    public Connection connect() {
        return this.manager.connect();
    }
}
