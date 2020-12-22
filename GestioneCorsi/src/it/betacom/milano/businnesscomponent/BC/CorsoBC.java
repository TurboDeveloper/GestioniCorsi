package it.betacom.milano.businnesscomponent.BC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.milano.architetture.dao.CorsoDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.model.Corso;

public class CorsoBC {
	//REGOLA SONO I BUSINNES COMPONENT CHE CREA LA CONNESSIONE
	private Connection conn;
	
	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corso c) throws DAOException {
		try {
			CorsoDAO.getFactory().create(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
/*	
	public void update(Corso c) throws DAOException {
		try {
			CorsoDAO.getFactory().update(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
*/
	public Corso getById(long id) throws DAOException {
		try {
			return CorsoDAO.getFactory().getById(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corso[] getCorsiAttivi() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAll(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void delete(long id) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}

