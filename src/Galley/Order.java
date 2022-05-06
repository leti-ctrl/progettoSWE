package Galley;


import java.util.Hashtable;
import java.util.Map;

import DesignPattern.Observable;



public class Order extends Observable {
	
	private Map<String, Integer> ordinazione = new Hashtable<> (); 
	private int pax = 0;
	private int numeroTavolo;
	
	
	private Order(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}
	
	
	
	/*
	 * addElement (String, int, int)
	 * aggiunge un elemento alla lista dell'ordine
	 */
	void addElement (String name, int tot, int p) {
		ordinazione.put(name, tot);
		pax = getPax() + p;
	}
	
	/*
	 * removeElement(String, int)
	 * rimuove un elemento dall'ordinazione in modo definitivo
	 */
	void removeElement(String name, int p) {
		ordinazione.remove(name);
		pax = getPax() - p;
	}
	
	
	
	public int getNumeroTavolo() {
		return numeroTavolo;
	}
	
	public int getPax() {
		return pax;
	}
	
	public Map<String, Integer> getOrdinazione() {
		return ordinazione;
	}

	
	
	/*
	 * notify(Ordine)
	 * chiama il notify della classe Observer
	 */
	public void notify (Order o) {
		super.notify(o);
	}

	public static Order valueOf(int a) {
		Order O = new Order(a);
		return O;
	}
	
}
