package adapter;

import java.sql.Connection;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.GenericDAO;
import it.betacom.milano.businesscomponent.model.CorsoCorsista;

public class AdapterCorsoCorsista implements GenericDAO<CorsoCorsista>{

	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, CorsoCorsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
