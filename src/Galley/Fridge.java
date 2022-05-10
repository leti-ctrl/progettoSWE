package Galley;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import DesignPattern.Observable;
import DesignPattern.Observer;



public class Fridge implements Observer {
	
	private static final Map<String, Integer> fridgeMap = new Hashtable <> ();

	public Fridge () {
		Observable.attach(this);
	}
	
	
	/*
	 * check (String name, int tot)
	 * controlla se un elemento c'� nel frigo prima di aggiungere nell'ordine
	 */
	static boolean check (String name, int tot) {
		Integer value = fridgeMap.get(name);
		return (value != null && value >= tot);
	}
	
	/*
	 * removeElement(String element, int tot)
	 * metodo utilizzato dal runner per togliere le cose dal frigo e servirle al tavolo
	 */
	static void removeElement (String element, int tot) {
		Integer oldValue = fridgeMap.get(element);
		fridgeMap.replace(element, oldValue-tot);
	}

	/*
	 * addElement (String element, int tot)
	 * aggiunge un elemento nel frigo incrementandone il valore se è già presente oppure inserendolo
	 */
	public static void addElement (String element, int value) {
		if (fridgeMap.containsKey(element))
			fridgeMap.replace(element, fridgeMap.get(element) + value);
		else
			fridgeMap.put(element, value);

	}

	/*
	 * update (Order ord)
	 * decrementa gli elementi dal frigo
	 */
	@Override
	public synchronized void update(Order ord) { //TODO
		
		Map<String,Integer> o = ord.getThingsToDrink();
		Set<String> element = o.keySet();
		
		for (String i : element) {
			int newValue = fridgeMap.get(i) - o.get(i);
			fridgeMap.replace(i, newValue);
		}
	}

	
}
