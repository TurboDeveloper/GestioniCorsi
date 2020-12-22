package it.betacom.milano.architetture.dao;

public interface DAOConstants {

	String AMMINISTRATORE_SEQUENCE="select amministratore_sequence.nextval from dual";
	String DOCENTE_SEQUENCE="select docente_sequence.nextval from dual";
	String CORSISTA_SEQUENCE="select corsista_sequence.nextval from dual";
	String CORSI_SEQUENCE="select corsi_sequence.nextval from dual";
	String INSERT_CORSISTA="insert into dati_corsisti values(?,?,?,?)";
	String SELECT_CORSI="Select * from dati_corsi ";
	String SELECT_COUNTCOMMENTI="Select count(commenti_corso) from dati_corsi";
/*???*/	String SELECT_CORSOXNMAGGCORSISTI="select cod_corso, count(cod_corsista) from corso_corsista group by cod_corso fetch 1 rows";
	String SELECT_DATAINIZIOULTIMOCORSO=" Select nome_corso,data_iniziocorso from dati_corsi where data_iniziocorso=(select MAX(data_iniziocorso) from dati_corsi)";
	String SELECT_AVGDURATACORSI="select nome_corso, data_finecorso, data_iniziocorso SELECT OrderNumber, InstallDate, CompleteDate,\r\n"
			+ "  (TRUNC(data_finecorso) - TRUNC(data_iniziocorso) ) +1 - \r\n"
			+ "  ((((TRUNC(data_finecorso,'D'))-(TRUNC(data_iniziocorso,'D')))/7)*2) -\r\n"
			+ "  (CASE WHEN TO_CHAR(InstallDate,'DY','nls_date_language=english')='SUN' THEN 1 ELSE 0 END) -\r\n"
			+ "  (CASE WHEN TO_CHAR(CompleteDate,'DY','nls_date_language=english')='SAT' THEN 1 ELSE 0 END) as BusinessDays\r\n"
			+ "FROM Orders\r\n"
			+ "ORDER BY OrderNumber;";
	String UPDATE_CORSISTA="update dati_corsisti set nome_corsista=?,cognome_corsista=?,precedenti_formativi=?,where cod_corsista=?";
	String SELECT_CORSISTA_BYPK="select * from dati_corsisti where cod_corsista=?";
	String SELECT_CORSISTI="Select * from dati_corsisti ";
	String SELECT_CORSIDISPONIBILI="Select * from dati_corsi where posti_disponibili>0 oder by posti_disponibili"; //(posti_totali-prenotati)as posti_disponibili>0
	String DELETE_CORSI="Delete from dati_corsi where cod_corso=?";
	String DELETE_CORSO_CORSISTA="Delete from corso_corsista where cod_corso=?";
	String SELECT_AMMINISTRATORE="Select * from amministratore";
	String UPDATE_AMMINISTRATORE="Update amministratore set nome_admin=? cognome_admin=? password_admin where cod_amin=? ";
	String DELETE_AMMINISTRATORE="Delete from amministratore where cod_admin=?";
	String SELECT_AMMINISTRATORE_BYID="Select * from amministratore where cod_admin=?";
}



/*SELECT DISTINCT CognomeStudente, NomeStudente, Classe
FROM (Studente INNER JOIN Voti ON Studente.CodiceStudente=Voti.CodiceStudente) INNER JOIN Materia ON Materia.CodiceMateria=Voti.CodiceMateria
WHERE Voto < 5 AND Materia = [quale materia?];*/

/*select nome_corso, avg(data_finecorso - data_iniziocorso)
from dati_corsi
group by nome_corso*/
/*select cod_corso, count(cod_corsista) from corso_corsista group by cod_corso*/