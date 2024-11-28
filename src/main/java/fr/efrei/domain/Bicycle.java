package fr.efrei.domain;

public class Bicycle {
    private int id;
    private String brand;
    private String model;
    private float price;
    private BicycleType type;

    private Bicycle() {}

    private Bicycle(Builder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.price = builder.price;
        this.type = builder.type;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }

    public BicycleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }

    public static class Builder {
        private int id;
        private String brand;
        private String model;
        private float price;
        private BicycleType type;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder setType(BicycleType type) {
            this.type = type;
            return this;
        }

        public Bicycle build() {
            return new Bicycle(this);
        }
    }
}
