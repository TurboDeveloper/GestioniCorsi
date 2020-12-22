package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.milano.businesscomponent.model.Corsista;

public class CorsistaDAO implements GenericDAO<Corsista>,DAOConstants {
	

	private CachedRowSet rowSet;
	
	
	public static CorsistaDAO createCorsistaDAO(CachedRowSet rowSet) throws SQLException {
		return new CorsistaDAO(rowSet);
	}

	private CorsistaDAO(CachedRowSet rowSet) throws SQLException {
		this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Corsista entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Corsista entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corsista getById(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corsista[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
