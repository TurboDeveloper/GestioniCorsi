insert into AMMINISTRATORE values(amministratore_sequence.nextval, 'Massimo','Rossi','pass' );
insert into AMMINISTRATORE values(amministratore_sequence.nextval, 'Gennaro','Esposito', 'pass');

insert into DATI_DOCENTI values(docente_sequence.nextval,'Francesco','Fumagalli','CvFumagalli.txt');
insert into DATI_DOCENTI values(docente_sequence.nextval, 'Ambrogio', 'Brambilla', 'CvBrambilla.txt');
insert into DATI_DOCENTI values(docente_sequence.nextval, 'Giuseppe', 'Verdi', 'CvVerdi.txt');
insert into DATI_DOCENTI values(docente_sequence.nextval, 'Armando', 'Diaz', 'CvDiaz.txt');
insert into DATI_DOCENTI values(docente_sequence.nextval, 'Antonio', 'Lo Cascio', 'CvLoCascio.txt');

insert into DATI_CORSI values(corsi_sequence.nextval,'Architettura degli elaboratori',
	TO_DATE('9/10/2020', 'dd/MM/yyyy'), TO_DATE('9/12/2021', 'dd/MM/yyyy'),
	1800, 'Ottimo','A31',3);
	
insert into DATI_CORSI values(corsi_sequence.nextval,'Analisi 1',
	TO_DATE('2/01/2021', 'dd/MM/yyyy'), TO_DATE('9/12/2021', 'dd/MM/yyyy'),
	2000, 'Difficile','A45',1);
	
insert into DATI_CORSI values(corsi_sequence.nextval,'Reti e sistemi operativi',
	TO_DATE('9/9/2020', 'dd/MM/yyyy'), TO_DATE('9/12/2021', 'dd/MM/yyyy'),
	1800, 'Utile','A31',2);
	
insert into DATI_CORSI values(corsi_sequence.nextval,'Sistemi distribuiti',
	TO_DATE('9/3/2021', 'dd/MM/yyyy'), TO_DATE('9/12/2021', 'dd/MM/yyyy'),
	3000, 'Facile','B34',4);
	
insert into DATI_CORSI values(corsi_sequence.nextval,'Sicurezza e affidabilità',
	TO_DATE('9/7/2020', 'dd/MM/yyyy'), TO_DATE('9/12/2021', 'dd/MM/yyyy'),
	4000, 'Na merda','C87',5);
	insert into DATI_CORSI values(corsi_sequence.nextval,'Sicurezza e affidabilità',
	TO_DATE('9/7/2020', 'dd/MM/yyyy'), TO_DATE('9/12/2020', 'dd/MM/yyyy'),
	4000, 'Na merda','C87',5);
	insert into DATI_CORSI values(corsi_sequence.nextval,'Sicurezza e affidabilità',
	TO_DATE('9/7/2020', 'dd/MM/yyyy'), TO_DATE('9/10/2020', 'dd/MM/yyyy'),
	4000, 'Na merda','C87',5);


insert into DATI_CORSISTI values(corsista_sequence.nextval,'Mimmo','Fumagalli',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Ciccio','Bianchi',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Jack','Menalli',0);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Luisa','Clementi',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Riccardo','Verdi',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Lorenzo','Rossi',0);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Giorgio','Roncallo',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Roberto','Fumagalli',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Claudio','Ciaparat',0);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Ivan','Federico',1);
insert into DATI_CORSISTI values(corsista_sequence.nextval,'Rebecca','Russo',0);


insert into corso_corsista values(1,1);
insert into corso_corsista values(1,2);
insert into corso_corsista values(1,3);
insert into corso_corsista values(2,4);
insert into corso_corsista values(2,5);
insert into corso_corsista values(3,6);
insert into corso_corsista values(4,7);
insert into corso_corsista values(4,8);
insert into corso_corsista values(4,9);
insert into corso_corsista values(5,10);
insert into corso_corsista values(5,11);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	