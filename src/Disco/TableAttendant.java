package Disco;


import java.util.Map;

public class TableAttendant {

    private static Map <String, Integer> reservations;


    public TableAttendant(Map<String, Integer> res) {
        Disco.TableAttendant.reservations.putAll(res);
    }


    /*
     * setTavolo(String, int, boolean)
     * inizializza il tavolo con il nome e i primi pax
     * prende in ingresso anche un booleano che mi dice se i tavolo � al completo oppure no.
     * nel caso sia al completo cambia lo stato del tavolo in ATTESA_CLIENTI
     */
    public void setTable (String tableName, int pax, boolean complete) {
        Integer num = reservations.get(tableName);

        if (num != null && Room.getTable(num).getState()!=Table.WAITING_FOR_CLIENTS){
            Table t = Room.getTable(num);
            t.addPax(pax);
            t.setTableName(tableName);

            if (complete /*&& t.getState()!=Tavolo.ATTESA_CLIENTI*/ )
                t.setComplete();
        }
        else
            System.out.println("Il nome del tavolo non e' presente nella lista delle prenotazioni "
                    + "oppure e' gia' al completo");
    }


    /*
     * setCompleto (String, int)
     * cambia lo stato del tavolo in ATTESA_CLIENTI e aggiunge gli ultimi pax
     * pu� anche essere chiamto per inizializzare un tavolo da principio. Praticamente � simile al metodo
     * setTavolo con l'attributo boolen completo = true.
     */

    public void setComplete(String tableName, int pax) {
        Integer numero = reservations.get(tableName);

        if (Room.getTable(numero).getTableName() == null)
            Room.getTable(numero).setTableName(tableName);
        if (numero != null && Room.getTable(numero).getState()!=Table.WAITING_FOR_CLIENTS) {
            Table t = Room.getTable(numero);
            t.addPax(pax);
            t.setComplete();
        }
        else
            System.out.println("Il nome del tavolo non � presente nella lista delle prenotazioni"
                    + "oppure � gi� al completo");
    }
}

