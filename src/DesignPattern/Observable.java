package DesignPattern;

import java.util.ArrayList;

import Galley.Order;

public abstract class Observable {
	private static ArrayList<Observer> observer = new ArrayList <> ();

	protected synchronized void notify (Order ord) {
		System.out.println("Sto facendo il notify.");
		for (Observer i : observer) {
			i.update(ord);
		}
	};
	
	public synchronized static void attach (Observer obs) {
		observer.add(obs);
	};
	
	public synchronized static void detach (Observer obs) {
		observer.remove(obs);
	};
	
}
