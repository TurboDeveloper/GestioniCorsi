package it.betacom.milano.businesscomponent.model;

public class Amministratore {

	private int cod_admin;
	private String nome_admin;
	private String cognome_admin;
	
	
	
	public Amministratore() {}
	
	public int getCod_admin() {
		return cod_admin;
	}
	public void setCod_admin(int cod_admin) {
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
	@Override
	public String toString() {
		return "Amministratore [cod_admin=" + cod_admin + ", nome_admin=" + nome_admin + ", cognome_admin="
				+ cognome_admin + "]";
	}
	
	
}
