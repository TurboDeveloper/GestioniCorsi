package it.betacom.milano.architetture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException{
	private static final long serialVersionUID = 7380379586860278147L;
	
	private static final int ORA1017 = 1017; //USERNAME-PASSWORD ERRATI
	private static final int ORA17002 = 17002; // MANCA CONNESSIONE - LISTENER NON FUNZIONA
	private static final int ORA00001 = 0; //VIOLAZIONE DI VINCOLO
	
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public DAOException(SQLException e) {
		String chiave = "";
		if(e != null) {
			switch (e.getErrorCode()) {
			case ORA1017: 
				chiave = "Username/Password errati";
				log(e);
				break;
			case ORA17002: 
				chiave = "IOexception di OracleDB. Impossibile connettersi";
				log(e);
				break;	
			case ORA00001: 
				chiave = "Violazione di vincolo";
				log(e);
				break;		
			default:
				chiave = "Eccezione sql non prevista";
				log(e);
			}
		}
		message = chiave;
	}
	
	private void log(SQLException e) {
		e.printStackTrace();
		System.err.println("Motivo: " + e.getMessage());
		System.err.println("Stato app: " + e.getSQLState());
		System.err.println("Codice errore: " + e.getErrorCode());
		System.err.println("Causa: " + e.getCause());
	}
}









