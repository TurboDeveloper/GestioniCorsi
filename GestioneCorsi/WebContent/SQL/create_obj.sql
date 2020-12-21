create table amministratore(
cod_admin int,
nome_admin varchar2(30) NOT NULL,
cognome_admin varchar2(30) NOT NULL,
constraint p_adm primary key(cod_admin));

create table dati_docenti(
cod_docente int,
nome_docente varchar2(30) NOT NULL,
cognome_docente varchar2(30)NOT NULL,
cv_docente varchar2(30),
constraint p_doc primary key(cod_docente));

create table dati_corsisti(
cod_corsista int,
nome_corsista varchar2(30) NOT NULL,
cognome_corsista varchar2(30) NOT NULL,
precedenti_formativi number(1),
constraint p_corsisti primary key(cod_corsista));


create table dati_corsi(
cod_corso int,
nome_corso varchar2(30) NOT NULL,
data_iniziocorso date,
data_finecorso date,
costo_corso number(7,2),
commenti_corso varchar2(200),
aula_corso char(3),
cod_docente int,
constraint p_ccorso primary key(cod_corso),
constraint f_cdocente foreign key(cod_docente) references  dati_docenti (cod_docente)); 

create table corso_corsista(
cod_corso int,
cod_corsista int,
constraint f_ccorso foreign key(cod_corso) references dati_corsi (cod_corso),
constraint f_ccorsista foreign key(cod_corsista) references dati_corsisti (cod_corsista));


create sequence amministratore_sequence;
create sequence docente_sequence;
create sequence corsista_sequence;
create sequence corsi_sequence;
