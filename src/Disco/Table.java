package Disco;

import Galley.Order;

public class Table {

        //stato in cui si pu� trovare un tavolo
        static final String ATTESA_CLIENTI = "GRAY";
        static final String ATTESA_CAPOCAMBUSA = "RED";
        static final String ATTESA_RUNNER = "BLUE";
        static final String SERVITO = "GREEN";

        private int numeroTavolo;
        private String nomeTavolo = "";
        private int pax = 0;
        private Order ordine = null;
        private String state = ATTESA_CLIENTI;


        Table(int numeroTavolo) {
            this.numeroTavolo = numeroTavolo;
        }

        void setNomeTavolo (String nomeTavolo) {
            this.nomeTavolo = nomeTavolo;
        }

        void addPax (int n) {
            setPax(getPax() + n);
        }

        private void setPax(int i) {
            pax = i;

        }

        public int getPax() {
            return pax;
        }

        public int getNumeroTavolo() {
            return numeroTavolo;
        }

        public String getNomeTavolo() {
            return nomeTavolo;
        }

        public String getState() {
            return state;
        }

        void setCompleto () {
            state = ATTESA_CAPOCAMBUSA;
        }

        public void setOrdinato () {
            state = ATTESA_RUNNER;
        }

        public void setServito () {
            state = SERVITO;
        }
        public void setOrdine(Order ordine) {
            this.ordine = ordine;
        }

}
