package fr.efrei.domain;

import java.util.Date;

public class Sales {
    private int id;
    private Date date;
    private float totalAmount;
    private int idCustomer;
    private HashMap<Integer, Integer> bicycleHashMap;

    private Sales() {}

    private Sales(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.totalAmount = builder.totalAmount;
        this.customer = builder.customer;
        this.bicycleHashMap = builder.bicycleHashMap;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public HashMap<Integer, Integer> getBicycleHashMap() {
        return bicycleHashMap;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", idCustomer=" + idCustomer +
                ", bicycleHashMap=" + bicycleHashMap +
                '}';
    }

    public static class Builder {
        private int id;
        private Date date;
        private float totalAmount;
        private int idCustomer;
        private HashMap<Integer, Integer> bicycleHashMap;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setTotalAmount(float totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setIdCustomer(int idCustomer) {
            this.idCustomer = idCustomer;
            return this;
        }

        public Builder setBicycleHashMap(HashMap<Integer, Integer> bicycleHashMap) {
            this.bicycleHashMap = bicycleHashMap;
            return this;
        }

        public Sales build() {
            return new Sales(this);
        }
    }
}
