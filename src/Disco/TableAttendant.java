package Disco;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TableAttendant {

    private static final Map <String, Integer> reservations = new HashMap<>();
    private int countPax = 0;


    public TableAttendant(Map<String, Integer> res) {
        Disco.TableAttendant.reservations.putAll(res);
    }


    /*
     * setTavolo(String tableName, int pax, boolean complete)
     * inizializza il tavolo con il nome e i primi pax
     * prende in ingresso anche un booleano che mi dice se i tavolo � al completo oppure no.
     * nel caso sia al completo cambia lo stato del tavolo in ATTESA_CLIENTI
     */
    public void setTable (String tableName, int pax, boolean complete) {
        Integer num = reservations.get(tableName);

        if (num != null){
            System.out.println ("tavolo: "+ num);
            if (!Objects.equals(Room.getTable(num).getState(), Table.WAITING_FOR_CLIENTS)){
                Table t = Room.getTable(num);
                t.addPax(pax);
                countPax += pax;
                t.setTableName(tableName);

                if (complete /*&& t.getState()!=Tavolo.ATTESA_CLIENTI*/)
                    t.setComplete();
            }
        }
        else
            System.out.println("Il nome del tavolo non e' presente nella lista delle prenotazioni "
                    + "oppure è già al completo");
    }


    /*
     * setComplete (String tableName, int pax)
     * cambia lo stato del tavolo in WAITING_FOR_CLIENTS e aggiunge gli ultimi pax
     * può anche essere chiamto per inizializzare un tavolo da principio.
     * Praticamente è simile al metodo setTable con l'attributo boolen complete = true.
     */
    public void setComplete(String tableName, int pax) {
        Integer number = null;

        if (reservations.containsKey(tableName))
            number = reservations.get(tableName);
        //TODO:
        // else
        //      se ci sono tavoli liberi assegna questo nome al tavolo libero

        if (number != null) {
            if (!Objects.equals(Room.getTable(number).getState(), Table.WAITING_FOR_CLIENTS)) {
                Table t = Room.getTable(number);
                t.addPax(pax);
                countPax += pax;
                t.setComplete();
            }
        }
        else
            System.out.println("Il nome del tavolo non è presente nella lista delle prenotazioni"
                    + "oppure è già al completo");
    }
}

