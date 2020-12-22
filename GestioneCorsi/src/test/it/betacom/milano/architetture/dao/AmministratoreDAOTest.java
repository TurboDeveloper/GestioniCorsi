package test.it.betacom.milano.architetture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.milano.architetture.dao.AmministratoreDAO;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.businesscomponent.model.Amministratore;

class AmministratoreDAOTest {

	private static Connection conn;
	private static Amministratore a;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn=DBAccess.getConnection();
		a.setNome_admin("nome");
		a.setCognome_admin("cognome");
		a.setPassword_admin("pass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		AmministratoreDAO.getFactory().delete(conn, a.getCod_admin());
		a=null;
		System.out.println("delete fatto");
	}

	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
