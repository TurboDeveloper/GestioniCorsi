package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.milano.businesscomponent.model.Corsista;

public class CorsistaDAO implements GenericDAO<Corsista>,DAOConstants {
	

	private CachedRowSet rowSet;
	
	
	public static CorsistaDAO createCorsistaDAO(CachedRowSet rowSet) throws DAOException {
		return new CorsistaDAO(rowSet);
	}

	private CorsistaDAO(CachedRowSet rowSet) throws DAOException {
		try {
			this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql){
			throw new DAOException(sql);			
		}
	}

	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			int x=0;
			if(entity.isPrecententi_formativi()==true) {
				x=1;
			}else {
				x=0;
			};
		rowSet.setCommand(SELECT_CORSISTI);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateLong(1, entity.getCod_corsista());
		rowSet.updateString(2, entity.getNome_corsista());
		rowSet.updateString(3, entity.getCognome_corsista());
		rowSet.updateInt(4,x);
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();	
		}catch(NullPointerException exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		try {
			int x=0;
			if(entity.isPrecententi_formativi()==true) {
				x=1;
			}else {
				x=0;
			};
			PreparedStatement ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNome_corsista());
			ps.setString(2, entity.getCognome_corsista());
			ps.setInt(3, x);
			ps.setLong(4,entity.getCod_corsista());
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
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

	@Override
	public Corsista getById(Connection conn, long id) throws DAOException {
		Corsista c=null;
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CORSISTA_BYPK);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setCod_corsista(rs.getLong(1));
				c.setNome_corsista(rs.getString(2));
				c.setCognome_corsista(rs.getString(3));
				c.setPrecententi_formativi(rs.getInt(4));
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return c;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsisti=null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
												  ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i=0;rs.next();i++) {
				Corsista c= new Corsista();
				c.setCod_corsista(rs.getLong(1));
				c.setNome_corsista(rs.getString(2));
				c.setCognome_corsista(rs.getString(3));
				c.setPrecententi_formativi(rs.getInt(4));
				corsisti[i]=c;
			}
			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsisti;
	}

}
