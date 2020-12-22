package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.milano.businesscomponent.model.Docente;

public class DocenteDAO implements GenericDAO<Docente>,DAOConstants {
	

	private CachedRowSet rowSet;
	
	
	public static DocenteDAO geFactory() throws SQLException {
		return new DocenteDAO();
	}

	private DocenteDAO() throws SQLException {
		
		this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Docente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Docente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente getById(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
