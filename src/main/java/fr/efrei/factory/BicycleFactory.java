package fr.efrei.factory;

import fr.efrei.domain.Bicycle;
import fr.efrei.domain.BicycleType;
import fr.efrei.util.Helper;

public class BicycleFactory {

    public static Bicycle buildBicycle(int id, String brand, String model, float price, BicycleType type) {
        if (id <= 0) {
            return null;
        }

        if (Helper.isNullOrEmpty(brand) || Helper.isNullOrEmpty(model)) {
            return null;
        }

        if (price <= 0.0f) {
            return null;
        }

        if (type == null) {
            return null;
        }

        return new Bicycle(id, brand, model, price, type);
    }
}
