package it.betacom.milano.businesscomponent.BC;

import java.io.IOException;

import it.betacom.milano.architetture.dao.DAOException;
import it.betacom.milano.businesscomponent.model.Amministratore;
import it.betacom.milano.businesscomponent.model.Corsista;
import it.betacom.milano.businesscomponent.model.Corso;
import it.betacom.milano.businesscomponent.model.CorsoCorsista;
import it.betacom.milano.businesscomponent.model.Docente;

public class ClientFacade {
	private static ClientFacade istance;
	
	private  AmministratoreBC amministratoreBC;;
	private  CorsistaBC corsistaBC;
	private  CorsoBC corsoBC;
	private  CorsoCorsistaBC corsoCorsistaBC;
	private  DocenteBC docenteBC; 
	
	
	
	private ClientFacade() throws DAOException, ClassNotFoundException, IOException {
		
		amministratoreBC =  new AmministratoreBC();
		corsistaBC = new CorsistaBC();
		corsoBC = new CorsoBC();
		corsoCorsistaBC = new CorsoCorsistaBC();
		docenteBC = new DocenteBC();
	}



	public static ClientFacade getInstance() throws DAOException, ClassNotFoundException, IOException {
		if(istance==null)
			istance=new ClientFacade();
		
		return istance;
	}
	
	//Amministratore
	public Amministratore amministratoregetByIdPass(long id,String pass) throws DAOException {
		return amministratoreBC.getByIdPass(id,pass);
	}
	
	//Corsista
	
	public void corsistaCreate(Corsista corsista) throws DAOException {
		 corsistaBC.create(corsista);
	}
	
	public void corsistaUpdate(Corsista corsista) throws DAOException {
		corsistaBC.update(corsista);
	}
	
	public void corsistaDelete(long id) throws DAOException {
		corsistaBC.delete(id);
	}
	
	public Corsista corsistaGetById(long id) throws DAOException {
		return corsistaBC.getById(id);
	}
	
	public Corsista[] corsistaGetAll() throws DAOException{
		return corsistaBC.getCorsisti();
	}
	
	//Corso
	
	public void corsoCreate(Corso corso) throws DAOException {
		corsoBC.create(corso);
	}
	
	public void corsoUpdate(Corso corso) throws DAOException {
		corsoBC.update(corso);
	}

	public void corsoDelete(long id) throws DAOException {
		corsoBC.delete(id);
	}
	
	public Corso corsoGetById(long id) throws DAOException {
		return corsoBC.getById(id);
	}
	
	public Corso[] corsoGetCorsiAttivi() throws DAOException {
		return corsoBC.getCorsiAttivi();
	}
	
	public Corso[] corsoGetCorsiAttiviAttualmente() throws DAOException {
		return corsoBC.getCorsiAttiviAttualmente();
	}
	
	public Corsista[] corsoGetCorsistiIscrittiCorso(long cod_corso) throws DAOException {
		return corsoBC.getCorsistiIscrittiAlCorso(cod_corso);		
	}
	
	//CorsoCorsista
	
	public void corsoCorsistaCreate (CorsoCorsista corsoCorsista) throws DAOException {
		corsoCorsistaBC.create(corsoCorsista);
	}
	
	public long[] corsoCorsistaGetCorsistiPerCorso(long id) throws DAOException {
		return corsoCorsistaBC.getPerCorso(id);
	}
	
	//Docente
	
	public Docente docenteGetDocenteById(long id) throws DAOException {
		return docenteBC.getById(id);
	}
	
	public Docente[] docenteGetAll() throws DAOException {
		return docenteBC.getDocenti();
	}
}