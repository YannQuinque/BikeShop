package fr.efrei.domain;

import java.util.Date;

public class Sales {
    private int id;
    private Date date;
    private float totalAmount;

    public Sales(int id, Date date, float totalAmount) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
    }

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

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
