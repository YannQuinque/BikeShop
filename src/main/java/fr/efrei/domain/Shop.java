package fr.efrei.domain;

import java.util.Locale;

public class Shop {
    private String name;
    private String address;

    private Shop (){}

    private Shop(Builder builder){
        this.name = builder.name;
        this.address = builder.address;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        private String name;
        private String address;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Shop build(){return new Shop(this);}
    }
}
