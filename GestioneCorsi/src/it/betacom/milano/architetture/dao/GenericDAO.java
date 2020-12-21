package it.betacom.milano.architetture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {
	
	void create(Connection conn,T entity);
	void update(Connection conn,T entity);
	void delete(Connection conn,long id);
	T getById(Connection conn,long id);
	T[] getAll(Connection conn);
	

}
