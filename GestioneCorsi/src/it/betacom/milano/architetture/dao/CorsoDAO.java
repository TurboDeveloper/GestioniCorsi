package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.milano.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>,DAOConstants {
	

	private CachedRowSet rowSet;
	
	
	public static CorsoDAO createCorsoDAO(CachedRowSet rowSet) throws SQLException {
		return new CorsoDAO(rowSet);
	}
	
	

	private CorsoDAO(CachedRowSet rowSet) throws SQLException {
		
		this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Corso entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Corso entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso getById(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corso[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
