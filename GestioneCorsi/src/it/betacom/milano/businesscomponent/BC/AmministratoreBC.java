package it.betacom.milano.businesscomponent.BC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.milano.architetture.dao.AmministratoreDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.model.Amministratore;

public class AmministratoreBC {
private Connection conn;
	
	public AmministratoreBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	public Amministratore getById(long id) throws DAOException {
		try {
			return AmministratoreDAO.getFactory().getById(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	public Amministratore getByIdPass(long id,String pass) throws DAOException {
		try {
			return AmministratoreDAO.getFactory().getByIdPass(conn, id,pass);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
