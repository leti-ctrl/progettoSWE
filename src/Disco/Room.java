package Disco;

import java.util.ArrayList;

public class Room {
	
	private static int MAX;
	private static ArrayList<Table> tavoli;
	
	
	
	public Room(int max) {
		Room.MAX = max;
		tavoli = new ArrayList<> (MAX);
		for (int i = 1 ; i <= tavoli.size(); i++)
			tavoli.add(new Table(i));
	}
	
	
	/*
	 *getTavolo(int i) ritorna il riferimento al tavolo
	 *prende in ingresso il numero del Tavolo
	 */
	public static Table getTavolo (int numeroTavolo) {
		if ( (numeroTavolo <= MAX) && (tavoli.get(numeroTavolo) != null) )
			return tavoli.get(numeroTavolo);
		else {
			System.out.println("TAVOLO " + numeroTavolo +" NON ESISTE");
			return null;
		}		
	}
	
	
	/*
	 * getTavoloAttesaCambusa () 
	 * ritorna una lista di tavoli che hanno state = ATTESA_CAPOCAMBUSA
	 */
	public static ArrayList<Table> getTavoloAttesaCapoCambusa () {
		ArrayList<Table> ret = new ArrayList <> ();
		
		for (int i = 0; i < MAX; i++) {
			if (tavoli.get(i).getState() == Table.ATTESA_CAPOCAMBUSA)
				ret.add(tavoli.get(i));
		}
		return ret;
	}
	
}
