package it.unina.ingsw.ristorantegiapponese.entity;

public class Piatto {

	private TipoPiatto tipo;
	private Ingrediente ingrediente;
	private int numeroPezzi;
	private int prezzo;
	private int id_piatto;

	public Piatto(TipoPiatto tipo, Ingrediente ingrediente, int numeroPezzi, int prezzo) {
		this.setId(-1);
		this.tipo = tipo;
		this.ingrediente = ingrediente;
		this.numeroPezzi = numeroPezzi;
		this.prezzo = prezzo;
	}

	public Piatto(int id_piatto, TipoPiatto tipo, Ingrediente ingrediente, int numeroPezzi, int prezzo) {
		this.setId(id_piatto);
		this.tipo = tipo;
		this.ingrediente = ingrediente;
		this.numeroPezzi = numeroPezzi;
		this.prezzo = prezzo;
	}
	
	public String toString() {
		return this.tipo + " (" + ingrediente + "), pezzi: " + this.numeroPezzi + ", prezzo: " + this.prezzo + "€";
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getNumeroPezzi() {
		return numeroPezzi;
	}

	public void setNumeroPezzi(int numeroPezzi) {
		this.numeroPezzi = numeroPezzi;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public TipoPiatto getTipo() {
		return tipo;
	}

	public void setTipo(TipoPiatto piatto) {
		this.tipo = piatto;
	}

	public int getId() {
		return id_piatto;
	}

	public void setId(int id_piatto) {
		this.id_piatto = id_piatto;
	}

}
