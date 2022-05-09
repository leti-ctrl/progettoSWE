package Galley;

import Disco.Room;
import Disco.Table;

import java.util.Map;
import java.util.Scanner;

public class ChiefGalley {
	 
	
	/*
	 * creaOrdine(Tavolo)
	 * crea l'oggetto ordine e lo setta al tavolo corrispondente; 
	 * ritorna l'oggetto creato per fare le operazioni di aggiunta/rimozione di elementi
	 */
	public Order takeOrder(Table t) {
		Order ord = generateOrder(t.getTableNumber());
		t.setAnOrder(ord);
				
		return ord;
	}
	
	/*
	 * addElement (String , int) 
	 * aggiunge un elemento all'ordine utilizzando l'omonima funzione presente in ordine, 
	 * prima per� controlla che sia presente tale elemento (o tale quantit�) nel frigo
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
	 * removeElement(Ordine, String)
	 * rimuove un elemento dall'ordine utilizzando l'omonima funzione presente nella classe ordine.
	 */
	public void removeElement (Order ord, String element) {
		ord.removeElement(element);
	}

	public void orderDone (Order ord) {
		System.out.println("ORDINE TAVOLO: "+ord.getTableNumber());
		for (Map.Entry<String, Integer> o : ord.getThingsToDrink().entrySet())
			System.out.println("- "+ o.getKey()+ " qtà: "+ o.getValue());

		calculateThePax(ord);
		calculateTheBill(ord);
		sendOrder(ord);
	}

	private void calculateThePax(Order ord) {
		Scanner input = new Scanner(System.in);
		System.out.println("Conto: ");
		int pax =  input.nextInt();
		ord.setPax(pax);
	}


	private void calculateTheBill (Order ord) {
		Scanner input = new Scanner(System.in);
		System.out.println("Conto: ");
		int money =  input.nextInt();
		ord.setMoney(money);
	}
	
	/*
	 * inviaOrdine (Ordine)
	 * cambia lo stato del tavolo in ATTESA_RUNNER, inserisce l'ordine nel buffer e chiama il notify perch� l'oridne � pronto
	 */
	private void sendOrder(Order ord) {
		Room.getTable(ord.getTableNumber()).setStateOrdered();
		BufferFIFO.push(ord);
		ord.notify();
	}
	
	
	private Order generateOrder (int a) {
		Order O = Order.valueOf(a);
		return O;
	}
	

}
