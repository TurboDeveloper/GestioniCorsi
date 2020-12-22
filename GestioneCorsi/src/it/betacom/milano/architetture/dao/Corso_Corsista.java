package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class Corso_Corsista implements GenericDAO<Corso_Corsista>,DAOConstants {
	

	private CachedRowSet rowSet;
	
	public static Corso_Corsista getFactory() throws SQLException {
		return new Corso_Corsista();
	}
	

	private Corso_Corsista() throws SQLException {
		
		this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Corso_Corsista entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Corso_Corsista entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso_Corsista getById(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corso_Corsista[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
