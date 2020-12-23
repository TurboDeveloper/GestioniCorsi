package test.it.betacom.milano.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void test() {
		try {
			CorsistaIdGenerator idGen = CorsistaIdGenerator.getInstace();
			assertNotNull(idGen, "Istanza createa correttamente");
			long valore = idGen.nextId();
			assertEquals(valore, idGen.nextId() - 1, "Test sequenza");
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Fallito");
		}
	}

}
