package it.betacom.milano.businnesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.milano.architetture.dao.DAOConstants;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;

public class CorsistaIdGenerator implements IdGeneratorInterface, DAOConstants{
	private static CorsistaIdGenerator idGenerator;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaIdGenerator() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsistaIdGenerator getInstace() throws DAOException, ClassNotFoundException, IOException {
		if(idGenerator == null) 
			idGenerator = new CorsistaIdGenerator();
		return idGenerator;
	}
	
	@Override
	public long nextId() throws DAOException{
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTASEQ);
			rs.next();
			id = rs.getLong(1);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return id;
	}

}
