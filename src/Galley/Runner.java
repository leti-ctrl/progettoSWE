package Galley;

import DesignPattern.Observable;
import DesignPattern.Observer;
import Disco.Room;

public class Runner implements Observer {

	private final int id;

	public Runner (int id) {
		this.id = id;
		Observable.attach(this);
	}

	/*
	 * update(Order o)
	 * stampa solo un messaggio a video per il cameriere dicendogli che è arrivato un ordine
	 */
	@Override
	public void update(Order o) {
		System.out.println(id+" - E' arrivato l'ordine del tavolo "+o.getTableNumber());
	}

	public int getId() {
		return id;
	}

	/*
	 * getOrder()
	 * fa pop() da BufferFIFO
	 */
	public Order getOrder() throws InterruptedException {
		return BufferFIFO.pop();
	}

	
	/*
	 * setDone(Order ord)
	 * setta lo stato del tavolo a SERVITO
	 */
	public void setDone(Order ord){
		Room.getTable(ord.getTableNumber()).setDone();
	}
}
