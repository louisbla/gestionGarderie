/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import garderie.model.TypeConge;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author HP_LOUIS
 */
public class TypeCongeDAO extends CommonDAO<TypeConge>{

    public TypeCongeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public TypeConge create(TypeConge obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypeConge update(TypeConge obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TypeConge obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypeConge findById(int id) {
        for(TypeConge type : TypeConge.values()){
            if(type.getId() == id){
                return type;
            }
        }
        return null; 
    }

    @Override
    public ArrayList<TypeConge> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
