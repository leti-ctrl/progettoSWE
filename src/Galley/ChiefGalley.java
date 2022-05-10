package Galley;

import Disco.Room;
import Disco.Table;

import java.util.Map;
import java.util.Scanner;

public class ChiefGalley {
	 
	
	/*
	 * takeOrder(Table t)
	 * chiama la funzione generateOrder per creare l'ordine e lo setta al tavolo corrispondente;
	 * ritorna l'oggetto creato per fare le operazioni di aggiunta/rimozione di elementi
	 */
	public Order takeOrder(Table t) {
		Order ord = generateOrder(t.getTableNumber());
		t.setAnOrder(ord);
				
		return ord;
	}
	
	/*
	 * addElement (Order ord, String element, int number)
	 * aggiunge un elemento all'ordine utilizzando l'omonima funzione presente in ordine, 
	 * prima controlla che sia presente tale elemento (o tale quantità) nel frigo
	 */
	public void addElement (Order ord, String element, int number) {
		if(Fridge.check(element, number)) {
			ord.addElement(element, number);
		}
		else {
			System.out.println("ERRORE, "+ element +" NON PRESENTE/NON SUFFICIENTE IN FRIGO");
		}
			
	}

	/*
	 * removeElement(Order ord, String element)
	 * rimuove un elemento dall'ordine utilizzando l'omonima funzione presente nella classe ordine.
	 */
	public void removeElement (Order ord, String element) {
		ord.removeElement(element);
	}

	public synchronized void orderDone (Order ord) {
		System.out.println("ORDINE TAVOLO: "+ord.getTableNumber());
		for (Map.Entry<String, Integer> o : ord.getThingsToDrink().entrySet()) {
			System.out.println("- "+ o.getKey()+ " qtà: "+ o.getValue());
			Fridge.removeElement(o.getKey(), o.getValue()); //TODO
		}

		calculateThePax(ord);
		calculateTheBill(ord);
		sendOrder(ord);
	}

	private void calculateThePax(Order ord) {
		Scanner input = new Scanner(System.in);
		System.out.println("PAX: ");
		int pax =  input.nextInt();
		ord.setPax(pax);
		Room.getTable(ord.getTableNumber()).setUsedPax(pax);
	}


	private void calculateTheBill (Order ord) {
		Scanner input = new Scanner(System.in);
		System.out.println("Conto: ");
		int money =  input.nextInt();
		ord.setMoney(money);

	}
	
	/*
	 * sendOrder(Order o)
	 * cambia lo stato del tavolo in ATTESA_RUNNER
	 * inserisce l'ordine nel buffer
	 * chiama il notify perché l'oridne è pronto
	 */
	private synchronized void sendOrder(Order ord) {
		Room.getTable(ord.getTableNumber()).setStateOrdered();
		BufferFIFO.push(ord);
		ord.notify();
	}
	
	/*
	 * generateOrder (int a)
	 * ha il solo scopo di creare l'ordine chiamando la funzione valueOf nella classe Order
	 */
	private Order generateOrder (int a) {
		return (Order.valueOf(a));
	}
	

}
