package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import adapter.AdapterAmministratore;
import it.betacom.milano.businesscomponent.model.Amministratore;

public class AmministratoreDAO extends AdapterAmministratore implements DAOConstants {
	private CachedRowSet rowSet;	
	
	public static AmministratoreDAO createAmministratoreDAO(CachedRowSet rowSet) throws SQLException {
		return new AmministratoreDAO(rowSet);
	}

	private AmministratoreDAO(CachedRowSet rowSet) throws SQLException {	
		this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	
	@Override
	public void create(Connection conn, Amministratore entity) throws DAOException {
		rowSet.setCommand(SELECT_AMMINISTRATORE);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateLong(1, entity.getCod_admin());
		rowSet.updateString(2, entity.getNome_admin());
		rowSet.updateString(3, entity.getCognome_admin());
		rowSet.updateString(4, entity.getPassword_admin());
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
		
	}

	@Override
	public void update(Connection conn, Amministratore entity) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_AMMINISTRATORE);
		ps.setString(1, entity.getNome_admin());
		ps.setString(2, entity.getCognome_admin());
		ps.setString(3, entity.getPassword_admin());
		ps.setLong(4, entity.getCod_admin());
		ps.execute();
		conn.commit();
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_AMMINISTRATORE);
		ps.setLong(1, id);
		ps.execute();
		conn.commit();
	}

	@Override
	public Amministratore getById(Connection conn, long id) {
		Amministratore a = new Amministratore();	
		PreparedStatement ps = conn.prepareStatement(SELECT_AMMINISTRATORE_BYID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			a.setCod_admin(rs.getLong(1));
			a.setNome_admin(rs.getString(2));
			a.setCognome_admin(rs.getString(3));
			a.setPassword_admin(rs.getString(4));
		}
		
		return a;
	}

	

}
