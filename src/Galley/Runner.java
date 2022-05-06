package Galley;

import DesignPattern.Observer;
import Disco.Room;

public class Runner implements Observer{
	
	private int id;
	
	public Runner (int id) {
		this.id = id;
	}

	@Override
	public void update(Order o) {
		// � arrivato l'ordine del tavolo x!!
		System.out.println("E' arrivato l'ordine del tavolo "+o.getTableNumber());
	}
	
	
	/*
	 * getOrdine()
	 * fa pop() da BufferFIFO
	 */
	public Order getOrder() {
		return BufferFIFO.pop();
	}

	/*
	 * prendiRobaDalFRigo(String, int)
	 * utilizza il metodo removeElement(String, int) per decrementare gli elementi presenti nel frigo
	 */
	public void takeThingsToDrink (String element, int number) {
		Fridge.removeElement(element, number);
	}
	
	
	/*
	 * setServito(Ordine ord)
	 * setta lo stato del tavolo a SERVITO
	 */
	public void setDone(Order ord) {
		Room.getTable(ord.getTableNumber()).setDone();
	}
}
