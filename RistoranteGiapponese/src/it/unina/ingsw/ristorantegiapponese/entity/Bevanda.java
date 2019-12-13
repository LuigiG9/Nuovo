package it.unina.ingsw.ristorantegiapponese.entity;

public class Bevanda {
	
	private TipoBevanda tipo;
	private int prezzo;
	private int id_bevanda;

	
	public Bevanda(int id_bevanda, TipoBevanda tipo, int prezzo) {
		this.id_bevanda = id_bevanda;
		this.prezzo = prezzo;
		this.tipo = tipo;
	}
	
	public Bevanda(TipoBevanda tipo, int prezzo) {
		this.id_bevanda = -1;
		this.prezzo = prezzo;
		this.tipo = tipo;
	}
	
	public String toString() {
		return this.tipo + ", prezzo: " + this.prezzo + "€";
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public TipoBevanda getTipo() {
		return tipo;
	}

	public void setTipo(TipoBevanda piatto) {
		this.tipo = piatto;
	}

	public void setId(int id_bevanda) {
		this.id_bevanda = id_bevanda;
	}

	public int getId() {
		return this.id_bevanda;
	}
}
