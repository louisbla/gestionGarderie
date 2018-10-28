/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garderie.dao;

import java.sql.Connection;
import java.util.ArrayList;

import garderie.db.DBManager;

/**
 *
 * @author Katsuo
 */
public abstract class CommonDAO<T> {
        public Connection connection = DBManager.getInstance();
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
        
        /**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T findById(int id);
        
        /**
	 * Permet de récupérer un objet via son ID
	 * @return
	 */
	public abstract ArrayList<T> findAll();
    
}
