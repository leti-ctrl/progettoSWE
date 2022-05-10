package Disco;

import java.util.ArrayList;
import java.util.Objects;

public class Room {
	
	private static int MAX;
	private static final ArrayList<Table> tables = new ArrayList<>();
	
	
	
	public Room(int max) {
		Room.MAX = max;
		for (int i = 1; i <= max; i++)
			tables.add(new Table(i));
	}
	
	
	/*
	 *getTable(int tableName) ritorna il riferimento al tavolo
	 *prende in ingresso il numero del Tavolo
	 */
	public static Table getTable (int tableNumber) throws NullPointerException {
		Table t = null;
		try {
			if ( (tableNumber < MAX) && (tables.get(tableNumber) != null) )
				t = tables.get(tableNumber);
		} catch (NullPointerException e) {
			System.out.println (e.getMessage());
		}
		return t;
	}
	
	
	/*
	 * getWaitChiefTableList ()
	 * ritorna una lista di tavoli che hanno state = WAITING_FOR_CHIEFGALLEY
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
