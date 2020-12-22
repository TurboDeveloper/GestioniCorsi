package it.betacom.milano.businesscomponent.model;

public class Corsista {
	private long cod_corsista;
	private String nome_corsista;
	private String cognome_corsista;
	private boolean precententi_formativi;
	
	
	
	public Corsista() {}
	
	
	public long getCod_corsista() {
		return cod_corsista;
	}
	public void setCod_corsista(long cod_corsista) {
		this.cod_corsista = cod_corsista;
	}
	public String getNome_corsista() {
		return nome_corsista;
	}
	public void setNome_corsista(String nome_corsista) {
		this.nome_corsista = nome_corsista;
	}
	public String getCognome_corsista() {
		return cognome_corsista;
	}
	public void setCognome_corsista(String cognome_corsista) {
		this.cognome_corsista = cognome_corsista;
	}
	public boolean isPrecententi_formativi() {
		return precententi_formativi;
	}
	
	public void setPrecententi_formativi(long numero) {
		if(numero==1) {
			this.precententi_formativi = true;
		}
		else {
			this.precententi_formativi = false;
		}
		
	}
	@Override
	public String toString() {
		return "Corsista [cod_corsista=" + cod_corsista + ", nome_corsista=" + nome_corsista + ", cognome_corsista="
				+ cognome_corsista + ", precententi_formativi=" + precententi_formativi + ", getCod_corsista()="
				+ getCod_corsista() + ", getNome_corsista()=" + getNome_corsista() + ", getCognome_corsista()="
				+ getCognome_corsista() + ", isPrecententi_formativi()=" + isPrecententi_formativi() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
