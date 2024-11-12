package fr.efrei.domain;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int id;
    private Date date;
    private float totalAmount;

    // List of bicycles in the order
    private ArrayList<Bicycle> bicycles;

    // Constructor
    public Order(int id, Date date) {
        this.id = id;
        this.date = date;
        this.bicycles = new ArrayList<>();
    }

    // Method to add a bicycle to the order
    public void addBicycle(Bicycle bicycle) {
        bicycles.add(bicycle);
    }

    // Method to calculate the total amount of the order
    public float calculateTotal() {
        totalAmount = 0f;
        for (Bicycle bicycle : bicycles) {
            totalAmount += bicycle.getPrice();
        }
        return totalAmount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalAmount() {
        return totalAmount;
    }
}
