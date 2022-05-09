package Disco;

import Galley.Order;

public class Table {

        //stato in cui si pu� trovare un tavolo
        static final String WAITING_FOR_CLIENTS = "GRAY";
        static final String WAITING_FOR_CHIEFGALLEY = "RED";
        static final String WAITING_FOR_RUNNER = "BLUE";
        static final String DONE = "GREEN";

        private final int tableNumber;
        private String tableName = "";
        private int pax = 0;
        private Order anOrder = null;
        private String state = WAITING_FOR_CLIENTS;


        Table(int tableNumber) {
            this.tableNumber = tableNumber;
        }

        void setTableName(String tableName) throws NullPointerException {
            this.tableName = tableName;
        }

        void addPax (int n) throws NullPointerException {
            setPax(getPax() + n);
        }

        private void setPax(int i) {
            pax = i;

        }

        public int getPax() {
            return pax;
        }

        public int getTableNumber() {
            return tableNumber;
        }

        public String getTableName() throws NullPointerException {
            return tableName;
        }

        public String getState() throws NullPointerException {
            try {
                return state;
            } catch (NullPointerException n) {
                System.out.print("STATO NON DEFINITO");
            }
            return " ";
        }

        void setComplete() {
            state = WAITING_FOR_CHIEFGALLEY;
        }

        public void setStateOrdered() {
            state = WAITING_FOR_RUNNER;
        }

        public void setDone() {
            state = DONE;
        }
        public void setAnOrder(Order ord) {
            this.anOrder = ord;
        }

}
