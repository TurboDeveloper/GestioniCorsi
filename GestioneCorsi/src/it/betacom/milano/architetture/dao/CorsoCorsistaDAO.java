package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements GenericDAO<CorsoCorsista>,DAOConstants {
	private CachedRowSet rowSet;
	
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	

	private CorsoCorsistaDAO() throws DAOException {
		try {
			this.rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodice_corso());
			rowSet.updateLong(2, entity.getCodice_corsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public void update(Connection conn, CorsoCorsista entity) {
	}

	@Override
	public void delete(Connection conn, long id) {
	}

	@Override
	public CorsoCorsista getById(Connection conn, long id) {
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) {
		return null;
	}
	
	public long[] getCodIscrittiPerCorso(Connection conn, long cod_corso) throws DAOException {
		long[] cod_iscritti = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(
					SELECT_CODISCRITTI_PERCORSO, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1, cod_corso);
			ResultSet rs = ps.executeQuery();
			rs.last();
			cod_iscritti = new long[rs.getRow()];
			
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				cod_iscritti[i] = rs.getLong(1);
			}
			rs.close();
		}catch (SQLException e) {
			throw new DAOException(e);
		}
		return cod_iscritti;
	}
}
