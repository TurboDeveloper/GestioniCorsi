package adapter;

import java.sql.Connection;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.GenericDAO;
import it.betacom.milano.businesscomponent.model.Amministratore;

public abstract class AdapterAmministratore implements GenericDAO<Amministratore> {

	@Override
	public void create(Connection conn, Amministratore entity) throws DAOException {
		
		
	}

	@Override
	public void update(Connection conn, Amministratore entity) throws DAOException {
		
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
	
		
	}

	@Override
	public Amministratore getById(Connection conn, long id) throws DAOException {
		
		return null;
	}

	@Override
	public Amministratore[] getAll(Connection conn) {
		
		return null;
	}
	

}
