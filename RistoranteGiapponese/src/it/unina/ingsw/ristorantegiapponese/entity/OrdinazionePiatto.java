package it.unina.ingsw.ristorantegiapponese.entity;

public class OrdinazionePiatto {

	private int quantita;
	private Piatto piatto;
	
	public OrdinazionePiatto(Piatto piatto, int quantita) {
		this.quantita = quantita;
		this.piatto = piatto;
	}
	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Piatto getPiatto() {
		return piatto;
	}

	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}

}
