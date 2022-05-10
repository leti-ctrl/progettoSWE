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
        private static int pax = 0;
        private int usedPax = 0;
        private Order anOrder = null;
        private String state = WAITING_FOR_CLIENTS;


        Table(int tableNumber) {
            this.tableNumber = tableNumber;
        }

        void setTableName(String tableName) {
            this.tableName = tableName;
        }

    public int getUsedPax() {
        return usedPax;
    }

    public void setUsedPax(int usedPax) {
        this.usedPax += usedPax;
    }

    void addPax (int p) {
            pax += p;
        }

        public int getPax() {
            return pax;
        }

        public int getTableNumber() {
            return tableNumber;
        }

        public String getTableName() {
            return tableName;
        }

        public String getState() {
            return state;
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

    public Order getAnOrder() {
        return anOrder;
    }
}
