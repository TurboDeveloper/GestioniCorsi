package it.betacom.milano.architetture.dao;

public interface DAOConstants {

	// SEQUENZE
	String AMMINISTRATORE_SEQUENCE="select amministratore_sequence.nextval from dual";
	String DOCENTE_SEQUENCE="select docente_sequence.nextval from dual";
	String CORSISTA_SEQUENCE="select corsista_sequence.nextval from dual";
	String CORSI_SEQUENCE="select corsi_sequence.nextval from dual";
	String SELECT_CORSISTASEQ = "Select corsista_sequence.nextval from dual";
	//CORSISTA
	String INSERT_CORSISTA="insert into dati_corsisti values(?,?,?,?)";
	String DELETE_CORSISTA="delete from dati_corsisti where cod_corsista=?";
	String UPDATE_CORSISTA="update dati_corsisti set nome_corsista=?,cognome_corsista=?,precedenti_formativi=? where cod_corsista=?";
	String SELECT_CORSISTA_BYPK="select * from dati_corsisti where cod_corsista=?";
	String SELECT_CORSISTI="Select * from dati_corsisti ";
	String COUNT_CORSISTI="select count(*) from dati_corsisti";
	//AMMINISTRATORE
	String SELECT_AMMINISTRATORE="Select * from amministratore";
	String UPDATE_AMMINISTRATORE="Update amministratore set nome_admin=? cognome_admin=? password_admin where cod_amin=? ";
	String DELETE_AMMINISTRATORE="Delete from amministratore where cod_admin=?";
	String SELECT_AMMINISTRATORE_BYID="Select * from amministratore where cod_admin=?";
	String SELECT_AMMINISTRATORE_BYIDPASS="Select * from amministratore where cod_admin=? and password_admin=?";
	//CORSI
	String SELECT_CORSI="Select * from dati_corsi ";
	String SELECT_COUNTCOMMENTI="Select count(commenti_corso) from dati_corsi";
	String SELECT_DATAINIZIOULTIMOCORSO=" select * from dati_corsi where cod_corso=(select max(cod_corso) from dati_corsi)";
										//Select nome_corso,data_iniziocorso from dati_corsi where data_iniziocorso=(select MAX(data_iniziocorso) from dati_corsi)
	String SELECT_CORSIDISPONIBILI="Select * from dati_corsi where posti_disponibili>0 oder by posti_disponibili"; //(posti_totali-prenotati)as posti_disponibili>0
	String DELETE_CORSO="Delete from dati_corsi where cod_corso=?";
	String SELECT_CORSI_ATTIVI= "Select * from dati_corsi where ( ? - data_iniziocorso ) > 0 ";
	String SELECT_CORSI_NON_ATTIVI= "Select * from dati_corsi where (data_finecorso - ? ) < 0 ";
	String SELECT_CORSO_BY_COD = "Select * from dati_corsi where cod_corso = ?";
	String SELECT_CORSI_ATTIVI_ATTUALMENTE = "Select * from dati_corsi where (data_finecorso - ?) > 0";
	//DOCENTE
	String SELECT_DOCENTE="Select * from dati_docenti";
	String SELECT_DOCENTE_BYID="Select * from dati_docenti where cod_docente=?";
	//String SELECT_DOCENTEFORCORSO="Select * from dati_docenti inner join dati_corsi on dati_docenti.cod_docente=dati_corsi.cod_docente";

	//CORSO_CORSISTA
	String DELETE_CORSO_CORSISTA="Delete from corso_corsista where cod_corso=?";
	String SELECT_CODISCRITTI_PERCORSO = "Select cod_corsista from corso_corsista where cod_corso = ?";
	String SELECT_CORSO_CORSISTA = "Select * from corso_corsista";
	String DELETE_CORSISTA_CORSO="Delete from corso_corsista where cod_corso=? and cod_corsista=?";
	
	String CORSO_PER_CORSISTA="select * from dati_corsi where cod_corso in(select cod_corso from corso_corsista where cod_corsista=?)";

	String SELECT_CORSOPERNMAGGCORSISTI="select cod_corso, count(cod_corsista) as n_iscritti from corso_corsista group by cod_corso fetch first row only";
	//???
	String SELECT_AVGDURATACORSI="select nome_corso, data_finecorso, data_iniziocorso SELECT OrderNumber, InstallDate, CompleteDate,\r\n"
			+ "  (TRUNC(data_finecorso) - TRUNC(data_iniziocorso) ) +1 - \r\n"
			+ "  ((((TRUNC(data_finecorso,'D'))-(TRUNC(data_iniziocorso,'D')))/7)*2) -\r\n"
			+ "  (CASE WHEN TO_CHAR(InstallDate,'DY','nls_date_language=english')='SUN' THEN 1 ELSE 0 END) -\r\n"
			+ "  (CASE WHEN TO_CHAR(CompleteDate,'DY','nls_date_language=english')='SAT' THEN 1 ELSE 0 END) as BusinessDays\r\n"
			+ "FROM Orders\r\n"
			+ "ORDER BY OrderNumber;";
	
	
	




}



/*SELECT DISTINCT CognomeStudente, NomeStudente, Classe
FROM (Studente INNER JOIN Voti ON Studente.CodiceStudente=Voti.CodiceStudente) INNER JOIN Materia ON Materia.CodiceMateria=Voti.CodiceMateria
WHERE Voto < 5 AND Materia = [quale materia?];*/

/*select nome_corso, avg(data_finecorso - data_iniziocorso)
from dati_corsi
group by nome_corso*/
/*select cod_corso, count(cod_corsista) from corso_corsista group by cod_corso*/