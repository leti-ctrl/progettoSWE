package DesignPattern;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import Galley.Order;

public abstract class Observable {
	private static final ArrayList<Observer> observer = new ArrayList <> ();
	private final Semaphore mutex = new Semaphore(1);

	protected void notif(Order ord) throws InterruptedException {
		System.out.println("Sto facendo il notify.");
		for (Observer i : observer) {
			mutex.acquire();
			i.update(ord);
			mutex.release();
		}
	}

	public static void attach (Observer obs) {
		observer.add(obs);
	};
	
	public static void detach (Observer obs) {
		observer.remove(obs);
	};
	
}
