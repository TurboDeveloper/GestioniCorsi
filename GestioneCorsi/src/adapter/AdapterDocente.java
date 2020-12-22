package adapter;

import java.sql.Connection;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.GenericDAO;
import it.betacom.milano.businesscomponent.model.Docente;

public abstract class AdapterDocente implements GenericDAO<Docente> {

	@Override
	public void create(Connection conn, Docente entity) {
		
		
	}

	@Override
	public void update(Connection conn, Docente entity) {
		
		
	}

	@Override
	public void delete(Connection conn, long id) {
	
		
	}

	@Override
	public Docente getById(Connection conn, long id) throws DAOException {
		
		return null;
	}

	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		
		return null;
	}
	
}