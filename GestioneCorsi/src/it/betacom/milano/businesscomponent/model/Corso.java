package it.betacom.milano.businesscomponent.model;

import java.util.Date;

public class Corso {
	
	private int cod_corso;
	private String nome_corso;
	private Date data_iniziocorso;
	private Date data_finecorso;
	private int costo_corso;
	private String commenti_corso;
	private char aula_corso;
	private int cod_docente;
	
	
	
	public Corso() {}
	
	public int getCod_corso() {
		return cod_corso;
	}
	public void setCod_corso(int cod_corso) {
		this.cod_corso = cod_corso;
	}
	public String getNome_corso() {
		return nome_corso;
	}
	public void setNome_corso(String nome_corso) {
		this.nome_corso = nome_corso;
	}
	public Date getData_iniziocorso() {
		return data_iniziocorso;
	}
	public void setData_iniziocorso(Date data_iniziocorso) {
		this.data_iniziocorso = data_iniziocorso;
	}
	public Date getData_finecorso() {
		return data_finecorso;
	}
	public void setData_finecorso(Date data_finecorso) {
		this.data_finecorso = data_finecorso;
	}
	public int getCosto_corso() {
		return costo_corso;
	}
	public void setCosto_corso(int costo_corso) {
		this.costo_corso = costo_corso;
	}
	public String getCommenti_corso() {
		return commenti_corso;
	}
	public void setCommenti_corso(String commenti_corso) {
		this.commenti_corso = commenti_corso;
	}
	public char getAula_corso() {
		return aula_corso;
	}
	public void setAula_corso(char aula_corso) {
		this.aula_corso = aula_corso;
	}
	public int getCod_docente() {
		return cod_docente;
	}
	public void setCod_docente(int cod_docente) {
		this.cod_docente = cod_docente;
	}
	@Override
	public String toString() {
		return "Dati_corsi [cod_corso=" + cod_corso + ", nome_corso=" + nome_corso + ", data_iniziocorso="
				+ data_iniziocorso + ", data_finecorso=" + data_finecorso + ", costo_corso=" + costo_corso
				+ ", commenti_corso=" + commenti_corso + ", aula_corso=" + aula_corso + ", cod_docente=" + cod_docente
				+ "]";
	}
	
	
	

}
