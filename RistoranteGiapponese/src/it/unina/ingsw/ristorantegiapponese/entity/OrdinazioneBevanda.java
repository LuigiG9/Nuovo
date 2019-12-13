package it.unina.ingsw.ristorantegiapponese.entity;

public class OrdinazioneBevanda {

	private int quantita;
	private Bevanda bevanda;
	
	public OrdinazioneBevanda(Bevanda bevanda, int quantita) {
		this.quantita = quantita;
		this.setBevanda(bevanda);
	}
	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Bevanda getBevanda() {
		return bevanda;
	}

	public void setBevanda(Bevanda bevanda) {
		this.bevanda = bevanda;
	}

}
