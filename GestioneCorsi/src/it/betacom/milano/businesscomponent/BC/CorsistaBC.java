package it.betacom.milano.businesscomponent.BC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.milano.architetture.dao.CorsistaDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.milano.businesscomponent.model.Corsista;

public class CorsistaBC {
	
	private Connection conn;
	private  CorsistaIdGenerator idGen;
	
	public CorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	
	public void create(Corsista c) throws DAOException, ClassNotFoundException, IOException {
		try {
			idGen=CorsistaIdGenerator.getInstace();
			c.setCod_corsista(idGen.nextId());
			CorsistaDAO.getFactory().create(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	public void update(Corsista c) throws DAOException {
		try {
			CorsistaDAO.getFactory().update(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	public Corsista getById(long id) throws DAOException {
		try {
			return CorsistaDAO.getFactory().getById(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corsista[] getCorsisti() throws DAOException {
		try {
			return CorsistaDAO.getFactory().getAll(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void delete(long id) throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public int countCorsisti() throws DAOException{
		try {
			return CorsistaDAO.getFactory().countCorsisti(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
}
