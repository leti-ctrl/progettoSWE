package Galley;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import DesignPattern.Observer;



public class Fridge implements Observer {
	
	private static Map<String, Integer> frigo = new Hashtable <> ();
	
	
	/*
	 * check (String, int)
	 * controlla se un elemento c'� nel frigo prima di aggiungere nell'ordine
	 */
	static boolean check (String name, int tot) {
		Integer value = frigo.get(name);
		if (value != null && value >= tot)
			return true;
		return false;
	}
	
	/*
	 * removeElement(String, int)
	 * metodo utilizzato dal runner per togliere le cose dal frigo e servirle al tavolo
	 */
	static void removeElement (String element, int tot) {
		Integer oldValue = frigo.get(element);
		frigo.replace(element, oldValue-tot);
	}

	@Override
	public void update(Order o) {
		
		Map<String,Integer> ord = o.getOrdinazione();
		Set<String> element = ord.keySet();
		
		for (String i : element) {
			int newValue = frigo.get(i) - ord.get(i);
			frigo.replace(i, newValue);
		}
		
		
	}

	
}
