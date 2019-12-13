package it.unina.ingsw.ristorantegiapponese;

import java.util.ArrayList;

import it.unina.ingsw.ristorantegiapponese.control.GestoreOrdiniRistorante;
import it.unina.ingsw.ristorantegiapponese.entity.*;

public class Main {

	public static void main(String[] args) {

		GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
		
		
		ArrayList<Piatto> piattiInMenu = gestore_ord.getPiattiInMenu();
		ArrayList<Bevanda> bevandeInMenu = gestore_ord.getBevandeInMenu();

		
		/*
		 * Simula una ipotetica selezione di piatti dal menu
		 */
		
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 3);
		
		Piatto [] piatti = new Piatto[3];
		piatti[0] = piattiInMenu.get(1); // SUSHI SALMONE
		piatti[1] = piattiInMenu.get(3); // SUSHI ANGUILLA
		piatti[2] = piattiInMenu.get(4); // SASHIMI TONNO
		int [] qtaPiatti = { 3, 3, 2 };
		
		Bevanda [] bevande = new Bevanda[3];
		bevande[0] = bevandeInMenu.get(1); // ACQUA LISCIA
		bevande[1] = bevandeInMenu.get(0); // ACQUA GASSATA
		bevande[2] = bevandeInMenu.get(4); // BIRRA GIAPPONESE
		int [] qtaBevande = { 1, 1, 1 };
		
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		
		gestore_ord.chiudiConto(conto);
		
		gestore_ord.visualizzaConto(conto);
		System.out.println("FINE");
	}

}
