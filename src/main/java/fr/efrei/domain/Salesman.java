package fr.efrei.domain;

import java.util.Locale;

public class Salesman {
    private String firstName;
    private String lastName;
    private int moneyInCheckout;
    private int numberOfSales;
    private int id;

    private Salesman (){}

    private Salesman(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.moneyInCheckout = builder.moneyInCheckout;
        this.numberOfSales = builder.numberOfSales;
        this.id = builder.id;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMoneyInCheckout() {
        return moneyInCheckout;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", moneyInCheckout=" + moneyInCheckout +
                ", numberOfSales=" + numberOfSales +
                ", id=" + id +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private int moneyInCheckout;
        private int numberOfSales;
        private int id;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMoneyInCheckout(int moneyInCheckout) {
            this.moneyInCheckout = moneyInCheckout;
            return this;
        }

        public Builder setNumberOfSales(int numberOfSales) {
            this.numberOfSales = numberOfSales;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Salesman build(){return new Salesman(this);}
    }
}
