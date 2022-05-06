package DesignPattern;

import java.util.ArrayList;

import Galley.Order;

public abstract class Observable {
	private ArrayList<Observer> observer = new ArrayList <> ();

	protected void notify (Order ord) {
		for (Observer i : observer) {
			i.update(ord);
		}
	};
	
	public void attach (Observer obs) {
		observer.add(obs);
	};
	
	public void detach (Observer obs) {
		observer.remove(obs);
	};
	
}
