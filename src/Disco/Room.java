package Disco;

import java.util.ArrayList;
import java.util.Objects;

public class Room {
	
	private static int MAX;
	private static ArrayList<Table> tables;
	
	
	
	public Room(int max) {
		Room.MAX = max;
		tables = new ArrayList<> (MAX);
		for (int i = 1; i <= tables.size(); i++)
			tables.add(new Table(i));
	}
	
	
	/*
	 *getTavolo(int i) ritorna il riferimento al tavolo
	 *prende in ingresso il numero del Tavolo
	 */
	public static Table getTable (int numeroTavolo) throws NullPointerException {
		if ( (numeroTavolo <= MAX) && (tables.get(numeroTavolo) != null) )
			return tables.get(numeroTavolo);
		else {
			System.out.println("TAVOLO " + numeroTavolo +" NON ESISTE");
			return null;
		}		
	}
	
	
	/*
	 * getTavoloAttesaCambusa () 
	 * ritorna una lista di tavoli che hanno state = ATTESA_CAPOCAMBUSA
	 */
	public static ArrayList<Table> getWaitChiefTableList() {
		ArrayList<Table> ret = new ArrayList <> ();
		
		for (int i = 0; i < MAX; i++) {
			if (Objects.equals(tables.get(i).getState(), Table.WAITING_FOR_CHIEFGALLEY))
				ret.add(tables.get(i));
		}
		return ret;
	}
	
}
