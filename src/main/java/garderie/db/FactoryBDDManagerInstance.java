/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.db;

/**
 *
 * @author dendaneys
 */
public class FactoryBDDManagerInstance {

    private static FactoryBDDManager factory = null;

    public static FactoryBDDManager getInstance(Manager manager) {
        if (factory == null) {
            factory = new FactoryBDDManager(manager);
        }

        return factory;
    }
}
