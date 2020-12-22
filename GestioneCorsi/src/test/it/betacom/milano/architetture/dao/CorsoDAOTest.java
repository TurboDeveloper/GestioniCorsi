package test.it.betacom.milano.architetture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.milano.architetture.dao.CorsoDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.model.Corso;

class CorsoDAOTest {
	private static Corso corso;
	private static Corso corso2;
	private static Connection conn;
	
	@BeforeAll
	static void setUp() throws Exception {
		conn = DBAccess.getConnection();
		
		corso = new Corso();
		corso.setCod_corso(1);
		corso.setNome_corso("Mimmo");
		corso.setData_iniziocorso(new GregorianCalendar(2021,2,4).getTime());
		corso.setData_finecorso(new Date());
		corso.setCosto_corso(2000);
		corso.setCommenti_corso("corso inutile");
		corso.setAula_corso("A31");
		corso.setCod_docente(2);
		
		corso2 = new Corso();
		corso2.setCod_corso(2);
		corso2.setNome_corso("Mimmo");
		corso2.setData_iniziocorso(new GregorianCalendar(2019,2,4).getTime());
		corso2.setData_finecorso(new Date());
		corso2.setCosto_corso(2000);
		corso2.setCommenti_corso("corso inutile");
		corso2.setAula_corso("A31");
		corso2.setCod_docente(3);
	}

	@Test
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			CorsoDAO.getFactory().create(conn, corso2);
			System.out.println("UTENTE CREATO:" );
			System.out.println(corso.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail();
		}
	/*	try {
			System.out.println("mimmo");
			Utente utente2 = UtenteDAO.getFactory().getByUsername(conn, "username");
			assertEquals(corso, utente2);
			System.out.println("Get utente a successo"
					+ utente2.toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Get by username fallito");
		}
	*/
	}
	
/*
	@Test
	void testUpdate() {
		try {
			corso = new Utente();
			corso.setNome("Mimmo");
			corso.setCognome("Ciccio");
			corso.setIndirizzo("Via San Martino 3");
			corso.setCap("20151");
			corso.setNascita(new GregorianCalendar(1998,2,11).getTime());
			corso.setUsername("username");
			corso.setPassword(Algoritmo.generaMD5("Pass01"));
			corso.setEmail("turbo@email.com");
			UtenteDAO.getFactory().update(conn, corso);
			System.out.println("UTENTE AGGIORNATO:");
			System.out.println(corso.toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("UPDATE UTENTE FALLITO");
		}
	}
	*/
	@Test
	void testGetById() {
		try {
			System.out.println("mimmo");
			Corso corso = CorsoDAO.getFactory().getById(conn, 1);
			System.out.println(corso.toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Get by username fallito");
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getAllCorsiAttivi(conn);
			assertEquals(1, corsi.length);
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Get All fallito");
		}
	}
	
	
	/*
	@Test
	void testDelete() throws SQLException {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from Utente where username = 'username'");
			conn.commit();
			utente = new Utente();
			utente = UtenteDAO.getFactory().getById(conn, "username");
			assertNull(utente);
		} catch (SQLException e) {
			System.out.println("UTENTE NON TROVATO");
			e.printStackTrace();
		}
	}
	*/
	@AfterAll
	static void tearDown() throws Exception {
		corso = null;
		conn = DBAccess.getConnection();// apro la connessione, così da poterlo cancellare qui dentro
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from dati_corsi where cod_corso = 1");
		stmt.executeUpdate("delete from dati_corsi where cod_corso = 2");
		//eliminiamo l'utente creato per il test
		conn.commit();
		DBAccess.closeConnection();
	}
}
