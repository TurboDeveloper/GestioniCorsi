package it.betacom.milano.businnesscomponent.idgenerator;

import java.io.IOException;

import it.betacom.milano.architetture.dao.DAOException;

public interface IdGeneratorInterface {
	long nextId() throws ClassNotFoundException, IOException,DAOException;
}
