package it.betacom.milano.businesscomponent.model;

public class Amministratore {

	private long cod_admin;
	private String nome_admin;
	private String cognome_admin;
	private String password_admin;
	
	
	
	public Amministratore() {}



	public long getCod_admin() {
		return cod_admin;
	}



	public void setCod_admin(long cod_admin) {
		this.cod_admin = cod_admin;
	}



	public String getNome_admin() {
		return nome_admin;
	}



	public void setNome_admin(String nome_admin) {
		this.nome_admin = nome_admin;
	}



	public String getCognome_admin() {
		return cognome_admin;
	}



	public void setCognome_admin(String cognome_admin) {
		this.cognome_admin = cognome_admin;
	}



	public String getPassword_admin() {
		return password_admin;
	}



	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}



	@Override
	public String toString() {
		return "Amministratore [cod_admin=" + cod_admin + ", nome_admin=" + nome_admin + ", cognome_admin="
				+ cognome_admin + ", password_admin=" + password_admin + "]";
	}
	
	
	
	
	
}
