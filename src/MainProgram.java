import Disco.Room;
import Disco.Table;
import Disco.TableAttendant;

import Galley.ChiefGalley;
import Galley.Fridge;
import Galley.Order;
import Galley.Runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainProgram {

    public static void main (String[] args)  {

        Room room = new Room(10); //sala con 10 tavoli
        System.out.println("Sala Creata");

        Fridge.addElement("Mare", 10);
        Fridge.addElement("Hendrick's", 10);
        Fridge.addElement("Bombay", 10);
        Fridge.addElement("Tanqueray", 10);
        System.out.println("Frigo riempito");

        Map<String, Integer> res = new HashMap<>();
        res.put("Mario Rossi", 1);
        res.put("Carla Verdi", 5);
        res.put("Giuseppe Bianchi", 7);
        res.put("Chiara Neri", 8);
        System.out.println("lista delle prenotazioni creata");

        TableAttendant tableAttendant = new TableAttendant(res);
        System.out.println("Acoompagnatore creato");

        int run = 2;
        ArrayList<Runner> runner = new ArrayList<Runner>(run);
        for (int i = 0; i < run; i++)
            runner.add(new Runner(i));
        System.out.println("camerieri creati");

        tableAttendant.setTable("Mario Rossi", 4, false);
        System.out.println("setTable di Mario Rossi");

        tableAttendant.setComplete("Carla Verdi", 20);
        System.out.println("setComplete di Carla Verdi");

        ArrayList<Table> table = Room.getWaitChiefTableList();
        System.out.println("Ho creato la lista dei tavoli che aspettano il capocambusa");

        if (!table.isEmpty()) {
            System.out.println("OK");
        }


        tableAttendant.setComplete("Mario Rossi", 12);
        tableAttendant.setComplete("Giuseppe Bianchi", 23);
        tableAttendant.setComplete("Chiara Neri", 30);

        ChiefGalley chiefGalley = new ChiefGalley();
        Order ordTav5 = chiefGalley.takeOrder(Room.getTable(5));

        chiefGalley.addElement(ordTav5, "Bombay", 2);
        chiefGalley.addElement(ordTav5, "Mare", 2);
        chiefGalley.removeElement(ordTav5, "Bombay");
        chiefGalley.orderDone(ordTav5);

    }
}
