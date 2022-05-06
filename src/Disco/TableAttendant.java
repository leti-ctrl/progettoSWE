package Disco;


import java.util.Map;

public class TableAttendant {

    private static Map <String, Integer> prenotazioni;


    public TableAttendant(Map<String, Integer> prenotazioni) {
        Disco.TableAttendant.prenotazioni.putAll(prenotazioni);
    }


    /*
     * setTavolo(String, int, boolean)
     * inizializza il tavolo con il nome e i primi pax
     * prende in ingresso anche un booleano che mi dice se i tavolo � al completo oppure no.
     * nel caso sia al completo cambia lo stato del tavolo in ATTESA_CLIENTI
     */
    public void setTavolo (String nomeTavolo, int pax, boolean completo) {
        Integer numero = prenotazioni.get(nomeTavolo);

        if (numero != null && Room.getTavolo(numero).getState()!=Table.ATTESA_CLIENTI){
            Table t = Room.getTavolo(numero);
            t.addPax(pax);
            t.setNomeTavolo(nomeTavolo);

            if (completo /*&& t.getState()!=Tavolo.ATTESA_CLIENTI*/ )
                t.setCompleto();
        }
        else
            System.out.println("Il nome del tavolo non � presente nella lista delle prenotazioni "
                    + "oppure � gi� al completo");
    }


    /*
     * setCompleto (String, int)
     * cambia lo stato del tavolo in ATTESA_CLIENTI e aggiunge gli ultimi pax
     * pu� anche essere chiamto per inizializzare un tavolo da principio. Praticamente � simile al metodo
     * setTavolo con l'attributo boolen completo = true.
     */

    public void setCompleto (String nomeTavolo, int pax) {
        Integer numero = prenotazioni.get(nomeTavolo);

        if (Room.getTavolo(numero).getNomeTavolo() == null)
            Room.getTavolo(numero).setNomeTavolo(nomeTavolo);
        if (numero != null && Room.getTavolo(numero).getState()!=Table.ATTESA_CLIENTI) {
            Table t = Room.getTavolo(numero);
            t.addPax(pax);
            t.setCompleto();
        }
        else
            System.out.println("Il nome del tavolo non � presente nella lista delle prenotazioni"
                    + "oppure � gi� al completo");
    }
}

