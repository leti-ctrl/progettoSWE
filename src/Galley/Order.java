package Galley;


import java.util.Hashtable;
import java.util.Map;

import DesignPattern.Observable;



public class Order extends Observable {
	
	private final Map<String, Integer> thingsToDrink = new Hashtable<> ();
	private int pax = 0;
	private int money = 0;
	private final int tableNumber;
	
	
	private Order(int numeroTavolo) {
		this.tableNumber = numeroTavolo;
	}
	
	/*
	 * addElement (String name, int tot)
	 * aggiunge un elemento alla lista dell'ordine
	 */
	void addElement (String name, int tot) {
		thingsToDrink.put(name, tot);
	}
	
	/*
	 * removeElement(String name)
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
	 * notify(Order o)
	 * chiama il notify della classe Observer
	 */
	public void notif(Order o) throws InterruptedException {
		super.notif(o);
	}

	/*
	 * valueOf(int a)
	 * è l'unico che può creare un oggetto di tipo Order
	 */
	public static Order valueOf(int a) {
		return (new Order(a));
	}

}
