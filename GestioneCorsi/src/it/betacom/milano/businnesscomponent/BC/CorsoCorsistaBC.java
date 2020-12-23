package it.betacom.milano.businnesscomponent.BC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.milano.architetture.dao.CorsoCorsistaDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
private Connection conn;
	
	public CorsoCorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	public void create(CorsoCorsista c) throws DAOException {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	public long[] getPerCorso(long id) throws DAOException{
		try {
			return CorsoCorsistaDAO.getFactory().getCodIscrittiPerCorso(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}