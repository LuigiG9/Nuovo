package it.unina.ingsw;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unina.ingsw.ristorantegiapponese.*;
import it.unina.ingsw.ristorantegiapponese.boundary.*;
import it.unina.ingsw.ristorantegiapponese.control.*;
import it.unina.ingsw.ristorantegiapponese.entity.*;



public class TestCase {
	GestoreOrdiniRistorante gestore_ord = new GestoreOrdiniRistorante();
	ArrayList<Piatto> piattiInMenu = gestore_ord.getPiattiInMenu();
	ArrayList<Bevanda> bevandeInMenu = gestore_ord.getBevandeInMenu();
	
	@Test
	public void test01FormulaAllConBevandeCoperto() {
	int prezzoTotale;
	Conto conto = gestore_ord.apriConto(new Tavolo(),new Cameriere(),Formula.ALL_YOU_CAN_EAT,1);
	Piatto [] piatti = new Piatto[1];
	piatti[0]= piattiInMenu.get(0); //SUSHI TONNO
	int[] qtaPiatti= { 1 };
	Bevanda[] bevande = new Bevanda[1];
	bevande[0]= bevandeInMenu.get(0); //ACQUA
	int[] qtaBevande= {1 };
	gestore_ord.creaComanda(conto,piatti,qtaPiatti,bevande,qtaBevande);
	gestore_ord.chiudiConto(conto);
	prezzoTotale= gestore_ord.visualizzaConto(conto);
	assertEquals(24, prezzoTotale);
	}
	
	@Test
	public void test02FormulaAllConBevandePiùCoperti1Comanda() {
		int prezzoTotale;
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
		Piatto[] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(0);//SUSHI TONNO
		int [] qtaPiatti= { 1 };
		Bevanda[] bevande = new Bevanda[1];
		bevande[0]= bevandeInMenu.get(0); //ACQUA
		int[] qtaBevande= { 1 };
		gestore_ord.creaComanda(conto,piatti,qtaPiatti,bevande,qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(46, prezzoTotale);	
		
	}
	
	@Test
	public void test03FormulaAllConBevandeUnCopertoPiùComande() {
		int prezzoTotale;
		Conto conto = gestore_ord.apriConto(new Tavolo(),new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
		Piatto[] piatti  = new Piatto[1];
		piatti[0]=piattiInMenu.get(3); // SUSHI ANGUILLA
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(2);//ARANCIATA
		int [] qtaBevande = { 1 };
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		Piatto [] piatto2= new Piatto[1];
		piatto2[0] = piattiInMenu.get(4); //SASHIMI TONNO
		int [] qtapiatti2= {1};
		Bevanda [] bevanda2 = new Bevanda[1];
		bevanda2[0]= bevandeInMenu.get(3);//COLA
		int [] qtaBevande2 = {1};
		gestore_ord.creaComanda(conto, piatto2, qtapiatti2, bevanda2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(24, prezzoTotale);
	}
	@Test
	public void test04FormulaAllConBevandePiùCopertiPiùComande() {
		int prezzoTotale;
		Conto conto = gestore_ord.apriConto(new Tavolo(),new Cameriere(), Formula.ALL_YOU_CAN_EAT, 2);
		Piatto[] piatti  = new Piatto[1];
		piatti[0]=piattiInMenu.get(3); // SUSHI ANGUILLA
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(2);//ARANCIATA
		int [] qtaBevande = { 1 };
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		Piatto [] piatto2= new Piatto[1];
		piatto2[0] = piattiInMenu.get(4); //SASHIMI TONNO
		int [] qtapiatti2= {1};
		Bevanda [] bevanda2 = new Bevanda[1];
		bevanda2[0]= bevandeInMenu.get(3);//COLA
		int [] qtaBevande2 = {1};
		gestore_ord.creaComanda(conto, piatto2, qtapiatti2, bevanda2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(46, prezzoTotale);
	}
	@Test
	public void test05FormulaAllNoBevandePiùCopertiPiùComande() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 3);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(2);//SUSHI GRANCHIO
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[0];
		int [] qtaBevande = null;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		Piatto [] piatto2= new Piatto[1];
		piatto2[0] = piattiInMenu.get(4); //SASHIMI TONNO
		int [] qtapiatti2= {1};
		Bevanda [] bevanda2 = new Bevanda[0];
		int [] qtaBevande2 = null;
		gestore_ord.creaComanda(conto, piatto2, qtapiatti2, bevanda2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(66, prezzoTotale);
		}
	@Test
	public void test06FormulaAllZeroCoperti() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 0);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(0, prezzoTotale);
	}
	@Test
	public void test07FormulaAll1Coperto0Comande() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 1);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(0, prezzoTotale);
	}
	@Test
	public void test08FormulaCartaUnCopertoUnaComanda() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(2);//SUSHI GRANCHIO
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(4);//BIRRA GIAPPONESE
		int [] qtaBevande = {1}
		;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(12, prezzoTotale);
		
	}
	@Test
	public void  test09FormulaCartaPiùCopertiUnaComanda() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 4);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(4);//SASHIMI TONNO
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(2);//ARANCIATA
		int [] qtaBevande = {1}
		;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(15, prezzoTotale);
		
			}
	@Test
	public void test10FormulaCartaUnCopertoPiùComande() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(2);//SUSHI GRANCHIO
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(4);//BIRRA GIAPPONESE
		int [] qtaBevande = {1};
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		Piatto [] piatti2 = new Piatto[1];
		piatti2[0]=piattiInMenu.get(3);//SUSHI ANGUILLA
		int [] qtaPiatti2={ 1 };
		Bevanda [] bevande2 = new Bevanda[1];
		bevande2[0]=bevandeInMenu.get(4);//BIRRA GIAPPONESE
		int [] qtaBevande2 = {1};
		gestore_ord.creaComanda(conto, piatti2, qtaPiatti2, bevande2, qtaBevande2);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(22, prezzoTotale);
		
	}
	@Test
	public void test11FormulaCartaPiùComandePiùCoperti() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 3);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(4);//SASHIMI TONNO
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(1);//ACQUA LISCIA
		int [] qtaBevande = {1}
		;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(22, prezzoTotale);
	}
	@Test
	public void test12FormulaCartaUnCopertoUnaComanda() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(5);//SASHIMI SALMONE 
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]=bevandeInMenu.get(1);//ACQUA LISCIA
		int [] qtaBevande = {1}
		;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(11, prezzoTotale);
	}
	@Test
	public void test13FormulaCartaUnCopertoUnaComandaNoBevande() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		Piatto [] piatti = new Piatto[1];
		piatti[0]=piattiInMenu.get(2);//SUSHI GRANCHIO
		int [] qtaPiatti={ 1 };
		Bevanda [] bevande = new Bevanda[0];
		int [] qtaBevande = null;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(7, prezzoTotale);
	}
	@Test
	public void test14FormulaCartaUnCopertoUnaComandaSoloBevande() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 1);
		Piatto [] piatti = new Piatto[0];
		int [] qtaPiatti= null;
		Bevanda [] bevande = new Bevanda[1];
		bevande[0]= bevandeInMenu.get(2);
		int [] qtaBevande = {1};
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(3, prezzoTotale);
	}
	@Test
	public void test15FormulaCartaUnaComandaNoPiattoNoBevanda() {
		int prezzoTotale;
		Conto conto=gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 3);
		Piatto [] piatti = new Piatto[0];
		int [] qtaPiatti= null;
		Bevanda [] bevande = new Bevanda[0];
		int [] qtaBevande = null;
		gestore_ord.creaComanda(conto, piatti, qtaPiatti, bevande, qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(0, prezzoTotale);
		
	}
	@Test
	public void test16() {
		int prezzoTotale;
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALL_YOU_CAN_EAT, 3);
		Piatto[] piatti = new Piatto[2];
		piatti[0]=piattiInMenu.get(0);//SUSHI TONNO
		piatti[1]=piattiInMenu.get(2);//SUSHI GRANCHIO
		int [] qtaPiatti= { 1,1 };
		Bevanda[] bevande = new Bevanda[2];
		bevande[0]= bevandeInMenu.get(0); //ACQUA
		bevande[1]= bevandeInMenu.get(2); //ARANCIATA
		int[] qtaBevande= { 1 ,1};
		gestore_ord.creaComanda(conto,piatti,qtaPiatti,bevande,qtaBevande);
		gestore_ord.creaComanda(conto,piatti,qtaPiatti,bevande,qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(72, prezzoTotale);	
		
	}
	@Test
	public void test17() {
		int prezzoTotale;
		Conto conto = gestore_ord.apriConto(new Tavolo(), new Cameriere(), Formula.ALLA_CARTA, 3);
		Piatto[] piatti = new Piatto[2];
		piatti[0]=piattiInMenu.get(0);//SUSHI TONNO
		piatti[1]=piattiInMenu.get(2);//SUSHI GRANCHIO
		int [] qtaPiatti= { 1,1 };
		Bevanda[] bevande = new Bevanda[2];
		bevande[0]= bevandeInMenu.get(0); //ACQUA
		bevande[1]= bevandeInMenu.get(2); //ARANCIATA
		int[] qtaBevande= { 1 ,1};
		gestore_ord.creaComanda(conto,piatti,qtaPiatti,bevande,qtaBevande);
		gestore_ord.creaComanda(conto,piatti,qtaPiatti,bevande,qtaBevande);
		gestore_ord.chiudiConto(conto);
		prezzoTotale= gestore_ord.visualizzaConto(conto);
		assertEquals(32, prezzoTotale);	
		
		
	}
	}


