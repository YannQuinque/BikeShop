package fr.efrei.domain;

import java.util.Date;

public class Sales {
    private int id;
    private Date date; 
    private float totalAmount;
    private Customer customer;

    private Sales() {}

    private Sales(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.totalAmount = builder.totalAmount;
        this.customer = builder.customer;
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

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                '}';
    }

    public static class Builder {
        private int id;
        private Date date;
        private float totalAmount;
        private Customer customer;

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

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Sales build() {
            return new Sales(this);
        }
    }
}
