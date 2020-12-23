package it.betacom.milano.businesscomponent.BC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.architetture.dao.DocenteDAO;
import it.betacom.milano.businesscomponent.model.Docente;

public class DocenteBC {
private Connection conn;
	
	public DocenteBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	public Docente getById(long id) throws DAOException {
		try {
			return DocenteDAO.getFactory().getById(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	public Docente[] getDocenti() throws DAOException {
		try {
			return DocenteDAO.getFactory().getAll(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
