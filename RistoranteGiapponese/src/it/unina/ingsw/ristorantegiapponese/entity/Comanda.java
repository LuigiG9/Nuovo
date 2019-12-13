package it.unina.ingsw.ristorantegiapponese.entity;

import java.util.ArrayList;

public class Comanda {

	private static int comanda_counter = 0;
	private int identificativo;
	
	private ArrayList<OrdinazionePiatto> ord_piatti = new ArrayList<OrdinazionePiatto>();
	private ArrayList<OrdinazioneBevanda> ord_bevande = new ArrayList<OrdinazioneBevanda>();
	
	public Comanda(Piatto[] piatti, int [] qtaPiatti, Bevanda[] bevande, int [] qtaBevande) {

		this.identificativo = ++comanda_counter;
		
		int i;
		
		for(i=0; i<piatti.length; i++) {
			ord_piatti.add(new OrdinazionePiatto(piatti[i], qtaPiatti[i]));
		}
		
		for(i=0; i<bevande.length; i++) {
			ord_bevande.add(new OrdinazioneBevanda(bevande[i], qtaBevande[i]));
		}
	}

	public ArrayList<OrdinazionePiatto> getPiatti() {

		return ord_piatti;
		
	}

	public ArrayList<OrdinazioneBevanda> getBevande() {
		
		return ord_bevande;
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

	
	
}
