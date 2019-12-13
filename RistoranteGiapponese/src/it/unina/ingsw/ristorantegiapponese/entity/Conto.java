package it.unina.ingsw.ristorantegiapponese.entity;

import java.util.ArrayList;
import java.util.Date;

public class Conto {

	private static int conto_counter = 0;
	private int identificativo;
	
	private Date dataApertura;
	private int numeroCoperti;
	private Formula formula;
	
	private ArrayList<Comanda> comande = new ArrayList<Comanda>();
	private Tavolo tavolo;
	private Cameriere cameriere;
	
	private StatoConto stato;
	
	public Conto(Tavolo tavolo, Cameriere cameriere, Formula formula, int coperti) {
		
		this.identificativo = ++conto_counter;
		
		this.dataApertura = new Date();
		
		this.tavolo = tavolo;
		this.cameriere = cameriere;
		this.formula = formula;
		this.numeroCoperti = coperti;
		
		this.setStato(StatoConto.APERTO);
	}
	
	public void creaComanda(Comanda c) {
		
		comande.add(c);
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public Date getData() {
		return dataApertura;
	}

	public int getNumeroCoperti() {
		return numeroCoperti;
	}

	public Formula getFormula() {
		return formula;
	}
	
	public StatoConto getStato() {
		return stato;
	}

	public void setStato(StatoConto stato) {
		this.stato = stato;
	}
	
	public int calcolaPrezzo() {
		
		int prezzo_totale;
		
		if (this.stato == StatoConto.APERTO) {
			return 0;
		}
		if(comande.isEmpty()==true) {
			prezzo_totale=0;
		}
		else {
		
		int costo_piatti = 0;
		
		if( this.formula == Formula.ALL_YOU_CAN_EAT )
		{
			
			costo_piatti = this.numeroCoperti * 20;
		}
		else		// Formula.ALLA_CARTA
		{
			
			for(Comanda c : comande) {
				
				for(OrdinazionePiatto ord : c.getPiatti()) {
					
					int prezzo = ord.getPiatto().getPrezzo();
				
				
					
					prezzo = prezzo * ord.getQuantita();
					
					costo_piatti += prezzo;
				}
			}
		}
		
		
		int costo_bevande = 0;
		
		for(Comanda c : comande) {
			
			for(OrdinazioneBevanda ord : c.getBevande()) {
				
				int prezzo = ord.getBevanda().getPrezzo();
				
			
				
				prezzo = prezzo * ord.getQuantita();
				
				costo_bevande += prezzo;
			}
		}
		if(costo_bevande==0 && costo_piatti==0) {
			prezzo_totale=0;
			
		}
		else {
		
		prezzo_totale = costo_piatti + costo_bevande + 2*this.numeroCoperti;
		}
		}
	   
		
		
		
		return prezzo_totale;
	}

	public String toString() {
		
		StringBuffer buf = new StringBuffer();
		
		buf.append("Conto #" + this.identificativo + "\n");
		buf.append("Ora apertura: " + this.dataApertura);
		buf.append("Formula: " + this.formula);
		buf.append("Numero coperti: " + this.numeroCoperti);
		buf.append("Tavolo: " + this.tavolo);
		buf.append("Cameriere: " + this.cameriere);
		
		for ( Comanda c : this.comande ) {
			buf.append(c);
		}
		
		return buf.toString();
	}

}
