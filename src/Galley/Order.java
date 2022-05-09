package Galley;


import java.util.Hashtable;
import java.util.Map;

import DesignPattern.Observable;



public class Order extends Observable {
	
	private Map<String, Integer> thingsToDrink = new Hashtable<> ();
	private int pax = 0;
	private int money = 0;
	private int tableNumber;
	
	
	private Order(int numeroTavolo) {
		this.tableNumber = numeroTavolo;
	}
	
	
	
	/*
	 * addElement (String, int, int)
	 * aggiunge un elemento alla lista dell'ordine
	 */
	void addElement (String name, int tot) {
		thingsToDrink.put(name, tot);
	}
	
	/*
	 * removeElement(String, int)
	 * rimuove un elemento dall'ordinazione in modo definitivo
	 */
	void removeElement(String name) {
		thingsToDrink.remove(name);
	}
	
	
	
	public int getTableNumber() {
		return tableNumber;
	}

	public int getPax() {
		return pax;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public Map<String, Integer> getThingsToDrink() {
		return thingsToDrink;
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
