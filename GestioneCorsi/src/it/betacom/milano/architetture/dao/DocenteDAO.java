package it.betacom.milano.architetture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import adapter.AdapterAmministratore;
import adapter.AdapterDocente;
import it.betacom.milano.businesscomponent.model.Docente;

public class DocenteDAO extends AdapterDocente implements GenericDAO<Docente>, DAOConstants {

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
	public Docente getById(Connection conn, long id) throws DAOException {
		Docente d = new Docente();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_DOCENTE_BYID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				d.setCod_docente(rs.getLong(1));
				d.setNome_docente(rs.getString(2));
				d.setCognome_docente(rs.getString(3));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return d;
	}

	@Override
	public Docente[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
