package test.it.betacom.milano.architetture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.milano.architetture.dao.CorsistaDAO;
import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.model.Corsista;

class CorsistaDAOTest {
	
	private static Connection conn;
	private static Corsista c;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Corsista();
		conn = DBAccess.getConnection();
		c.setCod_corsista(1);
		c.setNome_corsista("nome");
		c.setCognome_corsista("cognome");
		c.setPrecententi_formativi(1);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		CorsistaDAO.getFactory().delete(conn, 1);
		c= null;
		System.out.println("delete effettuato");
	}

	@Test
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(conn, c);
			System.out.println("corsista creato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("creazione corsista fallita");
		}
	}

	@Test
	void testUpdate() {
		try {
			c = new Corsista();
			c.setCod_corsista(1);
			c.setNome_corsista("nome2");
			c.setCognome_corsista("cognome2");
			c.setPrecententi_formativi(0);
			CorsistaDAO.getFactory().update(conn, c);
			System.out.println("update fatto");
			
			Corsista cor=CorsistaDAO.getFactory().getById(conn, 1);
			System.out.println(cor.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("creazione corsista fallita");
		}
	}

	

	@Test
	void testGetAll() {
		try {
			Corsista[] corsisti =CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail();
		}
		
	}

}
