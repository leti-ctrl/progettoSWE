package Galley;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import DesignPattern.Observer;



public class Fridge implements Observer {
	
	private static Map<String, Integer> fridgeMap = new Hashtable <> ();
	
	
	/*
	 * check (String, int)
	 * controlla se un elemento c'� nel frigo prima di aggiungere nell'ordine
	 */
	static boolean check (String name, int tot) {
		Integer value = fridgeMap.get(name);
		if (value != null && value >= tot)
			return true;
		return false;
	}
	
	/*
	 * removeElement(String, int)
	 * metodo utilizzato dal runner per togliere le cose dal frigo e servirle al tavolo
	 */
	static void removeElement (String element, int tot) {
		Integer oldValue = fridgeMap.get(element);
		fridgeMap.replace(element, oldValue-tot);
	}

	public static void addElement (String element, int value) {
		if (fridgeMap.containsKey(element))
			fridgeMap.replace(element, fridgeMap.get(element) + value);
		else
			fridgeMap.put(element, value);

	}

	@Override
	public void update(Order ord) {
		
		Map<String,Integer> o = ord.getThingsToDrink();
		Set<String> element = o.keySet();
		
		for (String i : element) {
			int newValue = fridgeMap.get(i) - o.get(i);
			fridgeMap.replace(i, newValue);
		}
		
		
	}

	
}
