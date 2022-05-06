package Galley;

import java.util.ArrayList;

import DesignPattern.Observable;

public class BufferFIFO extends Observable{
	
	private static ArrayList<Order> ordini = new ArrayList<> ();
	
	/*
	 * push(Ordine) inserice un elemento Ordine in coda al buffer;
	 */
	static void push (Order o) {
		ordini.add(o);
	}

	/*
	 * pop() restituisce il primo Ordine dell'array
	 */
	static Order pop () {
		return ordini.remove(0);
	}
	
}
