package it.betacom.milano.businesscomponent.model;

public class Docente {
	private long cod_docente;
	private String nome_docente;
	private String cognome_docente;
	private String cv_docente;
	
	
	
	
	public Docente() {}
	
	public long getCod_docente() {
		return cod_docente;
	}
	public void setCod_docente(long cod_docente) {
		this.cod_docente = cod_docente;
	}
	public String getNome_docente() {
		return nome_docente;
	}
	public void setNome_docente(String nome_docente) {
		this.nome_docente = nome_docente;
	}
	public String getCognome_docente() {
		return cognome_docente;
	}
	public void setCognome_docente(String cognome_docente) {
		this.cognome_docente = cognome_docente;
	}
	public String getCv_docente() {
		return cv_docente;
	}
	public void setCv_docente(String cv_docente) {
		this.cv_docente = cv_docente;
	}
	@Override
	public String toString() {
		return "Docente [cod_docente=" + cod_docente + ", nome_docente=" + nome_docente + ", cognome_docente="
				+ cognome_docente + ", cv_docente=" + cv_docente + "]";
	}
	
	

}
