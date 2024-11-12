package fr.efrei.domain;

public class Bicycle {
    private int id;
    private String brand;
    private String model;
    private float price;
    private BicycleType type;

    public Bicycle(int id, String brand, String model, float price, BicycleType type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BicycleType getType() {
        return type;
    }

    public void setType(BicycleType type) {
        this.type = type;
    }
}
