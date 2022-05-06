package Galley;

import Disco.Room;
import Disco.Table;

public class ChiefGalley {
	 
	
	/*
	 * creaOrdine(Tavolo)
	 * crea l'oggetto ordine e lo setta al tavolo corrispondente; 
	 * ritorna l'oggetto creato per fare le operazioni di aggiunta/rimozione di elementi
	 */
	public Order creaOrdine (Table t) {
		Order ord = generaOrdine(t.getNumeroTavolo());
		t.setOrdine(ord);
				
		return ord;
	}
	
	/*
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * UNA CLASSE MENU PER GESTIRE I PAX. E SOPRATUTTO SOMMA E SOTTRAZIONE DEI PAX DOVREBBE STARE QUI E NON NELLA CLASSE ORDINE 
	 * addElement (String , int) 
	 * aggiunge un elemento all'ordine utilizzando l'omonima funzione presente in ordine, 
	 * prima per� controlla che sia presente tale elemento (o tale quantit�) nel frigo
	 */
	public void addElement (Order ord, String element, int number) {
		if(Fridge.check(element, number)) {
			int pax = 0;
			//TODO serve qualcosa che calcoli il numero di pax per ogni elemento dell'ordine
			ord.addElement(element, number, pax);
		}
		else {
			System.out.println("ERRORE, "+ element +" NON PRESENTE/NON SUFFICIENTE IN FRIGO");
		}
			
	}
	
	/*
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * UNA CLASSE MENU PER GESTIRE I PAX. E SOPRATUTTO SOMMA E SOTTRAZIONE DEI PAX DOVREBBE STARE QUI E NON NELLA CLASSE ORDINE 
	 * removeElement(Ordine, String)
	 * rimuove un elemento dall'ordine utilizzando l'omonima funzione presente nella classe ordine.
	 */
	public void removeElement (Order ord, String element) {
		int pax = 0;
		//TODO serve qualcosa che calcoli il numero di pax per ogni elemento dell'ordine
		ord.removeElement(element, pax);
	}
	
	
	/*
	 * inviaOrdine (Ordine)
	 * cambia lo stato del tavolo in ATTESA_RUNNER, inserisce l'ordine nel buffer e chiama il notify perch� l'oridne � pronto
	 */
	public void inviaOrdine(Order ord) {
		Room.getTavolo(ord.getNumeroTavolo()).setOrdinato();
		BufferFIFO.push(ord);
		ord.notify();
	}
	
	
	public Order generaOrdine(int a) {
		Order O = Order.valueOf(a);
		return O;
	}
	

}
