package Galley;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import DesignPattern.Observable;

public class BufferFIFO extends Observable{
	
	private static final ArrayList<Order> orderList = new ArrayList<> ();
	private static final Semaphore mutex = new Semaphore(1);
	private static final Semaphore piene = new Semaphore(0);


	/*
	 * push(Order o)
	 * inserice un elemento Ordine in coda al buffer
	 */
	static void push (Order o) throws InterruptedException {
		mutex.acquire();
		orderList.add(o);
		piene.release();
		mutex.release();
	}

	/*
	 * pop()
	 * restituisce il primo Ordine dell'array
	 */
	static Order pop () throws InterruptedException {
		Order ret;
		mutex.acquire();
		piene.acquire();
		ret = orderList.remove(0);
		mutex.release();
		return ret;
	}
	
}
