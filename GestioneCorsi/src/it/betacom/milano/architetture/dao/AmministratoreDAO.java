package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import adapter.AdapterAmministratore;
import it.betacom.milano.businesscomponent.model.Amministratore;

public class AmministratoreDAO extends AdapterAmministratore implements DAOConstants {
	private CachedRowSet rowSet;	
	
	public static AmministratoreDAO getFactory() throws DAOException {
		return new AmministratoreDAO();
	}

	private AmministratoreDAO() throws DAOException {	
		try {
			this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql){
			throw new DAOException(sql);			
		}
			
	}

	
	@Override
	public void create(Connection conn, Amministratore entity) throws DAOException {
		try {
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
		}catch(NullPointerException exc) {
			System.out.println(exc.getMessage());
			System.out.println(entity.toString());
		
		}catch(SQLException sql){
			throw new DAOException(sql);			
		}
		
	}

	@Override
	public void update(Connection conn, Amministratore entity) throws DAOException{
	try {
		PreparedStatement ps = conn.prepareStatement(UPDATE_AMMINISTRATORE);
		ps.setString(1, entity.getNome_admin());
		ps.setString(2, entity.getCognome_admin());
		ps.setString(3, entity.getPassword_admin());
		ps.setLong(4, entity.getCod_admin());
		ps.execute();
		conn.commit();
	}catch(SQLException sql){	
		throw new DAOException(sql);			
	}
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		try {
		PreparedStatement ps = conn.prepareStatement(DELETE_AMMINISTRATORE);
		ps.setLong(1, id);
		ps.execute();
		conn.commit();
		}catch(SQLException sql){
			throw new DAOException(sql);			
		}
	}

	
	public Amministratore getByIdPass(Connection conn, long id,String pass) throws DAOException {
		Amministratore a = null;
		try {
		PreparedStatement ps = conn.prepareStatement(SELECT_AMMINISTRATORE_BYIDPASS);
		ps.setLong(1, id);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			a= new  Amministratore();
			a.setCod_admin(rs.getLong(1));
			a.setNome_admin(rs.getString(2));
			a.setCognome_admin(rs.getString(3));
			a.setPassword_admin(rs.getString(4));
		}
		}catch(SQLException sql){
			throw new DAOException(sql);			
		}
		
		return a;
	}

	

}
