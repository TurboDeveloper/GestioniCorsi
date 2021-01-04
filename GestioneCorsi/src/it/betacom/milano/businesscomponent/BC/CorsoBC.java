package it.betacom.milano.businesscomponent.BC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.milano.architetture.dao.CorsistaDAO;
import it.betacom.milano.architetture.dao.CorsoCorsistaDAO;
import it.betacom.milano.architetture.dao.CorsoDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.idgenerator.CorsoIdGenerator;
import it.betacom.milano.businesscomponent.model.Corsista;
import it.betacom.milano.businesscomponent.model.Corso;

public class CorsoBC {
	//REGOLA SONO I BUSINNES COMPONENT CHE CREA LA CONNESSIONE
	private Connection conn;
	private CorsoIdGenerator idGen;
	
	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corso c) throws DAOException, ClassNotFoundException, IOException {
		try {
			idGen=CorsoIdGenerator.getInstace();
			c.setCod_corso(idGen.nextId());
			CorsoDAO.getFactory().create(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void update(Corso c) throws DAOException {
		try {
			CorsoDAO.getFactory().update(conn, c);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public Corso getById(long id) throws DAOException {
		try {
			return CorsoDAO.getFactory().getById(conn, id);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corso getDataUltimoCorso() throws DAOException {
		try {
			return CorsoDAO.getFactory().getDataUltimoCorso(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corso[] getCorsiAttivi() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAllCorsiAttivi(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corso[] getCorsiNonAttivi() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAllCorsiNonAttivi(conn);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corso[] getCorsiAttiviAttualmente() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAllCorsiAttiviAttualmente(conn);
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
	
	public Corsista[] getCorsistiIscrittiAlCorso(long cod_corso) throws DAOException {
		long[] cod_iscritti = null;
		Corsista[] corsisti_iscritti = null;
		try {
			cod_iscritti = CorsoCorsistaDAO.getFactory().getCodIscrittiPerCorso(conn, cod_corso);
			corsisti_iscritti = new Corsista[cod_iscritti.length];
			for(int i = 0; i < cod_iscritti.length; i++) {
				corsisti_iscritti[i] = CorsistaDAO.getFactory().getById(conn, cod_iscritti[i]);
			}
		}catch (SQLException e) {
			throw new DAOException(e);
		}
		return corsisti_iscritti;
	}
	
	public Corso[] getCorsoPerCorsista(long cod_corsista) throws DAOException {
		Corso[] corsi = null;
		try {
			return corsi = CorsoDAO.getFactory().getCorsoPerCorsista(conn, cod_corsista);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}

