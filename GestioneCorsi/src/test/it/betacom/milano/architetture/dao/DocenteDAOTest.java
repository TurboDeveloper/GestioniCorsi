package test.it.betacom.milano.architetture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.architetture.dao.DBAccess;
import it.betacom.milano.architetture.dao.DocenteDAO;
import it.betacom.milano.businesscomponent.model.Docente;

class DocenteDAOTest {
	private static Connection conn;

	@BeforeAll
	static void setUp() throws Exception {
		conn = DBAccess.getConnection();
	}

	@Test
	void testGetAll() {
		try {
			Docente[] docenti = DocenteDAO.getFactory().getAll(conn); // ?
			assertNotNull(docenti);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Get All fallito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
