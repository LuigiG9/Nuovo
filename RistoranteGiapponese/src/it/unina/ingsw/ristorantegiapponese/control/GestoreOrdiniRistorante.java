package it.unina.ingsw.ristorantegiapponese.control;

import java.util.ArrayList;
import java.util.TreeMap;

import it.unina.ingsw.ristorantegiapponese.entity.*;

public class GestoreOrdiniRistorante {

	private ArrayList<Bevanda> bevandeInMenu = new ArrayList<Bevanda>();
	private ArrayList<Piatto> piattiInMenu = new ArrayList<Piatto>();
	
	private TreeMap<Integer, Conto> conti = new TreeMap<Integer, Conto>();
			
	public GestoreOrdiniRistorante() {
		
		piattiInMenu.add( new Piatto( TipoPiatto.SUSHI, Ingrediente.TONNO, 2, 5 ) );
		piattiInMenu.add( new Piatto( TipoPiatto.SUSHI, Ingrediente.SALMONE, 2, 6 ) );
		piattiInMenu.add( new Piatto( TipoPiatto.SUSHI, Ingrediente.GRANCHIO, 2, 5 ) );
		piattiInMenu.add( new Piatto( TipoPiatto.SUSHI, Ingrediente.ANGUILLA, 2, 5 ) );
		piattiInMenu.add( new Piatto( TipoPiatto.SASHIMI, Ingrediente.TONNO, 4, 6 ) );
		piattiInMenu.add( new Piatto( TipoPiatto.SASHIMI, Ingrediente.SALMONE, 4, 7 ) );

		bevandeInMenu.add( new Bevanda( TipoBevanda.ACQUA_GASSATA, 2 ) );
		bevandeInMenu.add( new Bevanda( TipoBevanda.ACQUA_LISCIA, 2 ) );
		bevandeInMenu.add( new Bevanda( TipoBevanda.ARANCIATA, 1 ) );
		bevandeInMenu.add( new Bevanda( TipoBevanda.COLA, 1 ) );
		bevandeInMenu.add( new Bevanda( TipoBevanda.BIRRA_GIAPPONESE, 5 ) );

	}
	
	public ArrayList<Bevanda> getBevandeInMenu() {
		return bevandeInMenu;
	}


	public void setBevandeInMenu(ArrayList<Bevanda> bevandeInMenu) {
		this.bevandeInMenu = bevandeInMenu;
	}


	public ArrayList<Piatto> getPiattiInMenu() {
		return piattiInMenu;
	}


	public void setPiattiInMenu(ArrayList<Piatto> piattiInMenu) {
		this.piattiInMenu = piattiInMenu;
	}
	
	
	
	public Conto apriConto(Tavolo tavolo, Cameriere cameriere, Formula formula, int coperti) {
		
		Conto conto = new Conto(tavolo, cameriere, formula, coperti);
		
		int id_conto = conto.getIdentificativo();
		
		conti.put(id_conto, conto);
		
		return conto;
	}
	
	public void creaComanda(Conto conto, Piatto [] piatti, int [] qtaPiatti, Bevanda [] bevande, int [] qtaBevande) {
				
		Comanda comanda = new Comanda(piatti, qtaPiatti, bevande, qtaBevande);
		
		conto.creaComanda(comanda);
	}
	
	public void chiudiConto(Conto conto) {
				
		conto.setStato(StatoConto.CHIUSO);
	}
	
	public int visualizzaConto(Conto conto) {
		int prezzo = conto.calcolaPrezzo();
		System.out.println("Totale conto: " + prezzo + "€");
		return prezzo;
	}
	
	public void saldaConto(Conto conto, Pagamento pagamento) {
		// TODO
	}

}
