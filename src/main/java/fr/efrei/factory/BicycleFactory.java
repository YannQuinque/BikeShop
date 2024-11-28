package fr.efrei.factory;

import fr.efrei.domain.Bicycle;
import fr.efrei.domain.BicycleType;
import fr.efrei.util.Helper;
import java.util.Arrays;

public class BicycleFactory {

    public static Bicycle buildBicycle(int id, String brand, String model, float price, BicycleType type, int nbStock) {
        if (id <= 0 || nbStock < 0) {
            return null;
        }

        if (Helper.isNullOrEmpty(brand) || Helper.isNullOrEmpty(model)) {
            return null;
        }

        if (price <= 0.0f) {
            return null;
        }

        if (type == null || !isValidBicycleType(type)) {
            return null;
        }

        return new Bicycle.Builder()
                .setId(id)
                .setBrand(brand)
                .setModel(model)
                .setPrice(price)
                .setType(type)
                .setNbStock(nbStock)
                .build();
    }

    private static boolean isValidBicycleType(BicycleType type) {
        return Arrays.asList(BicycleType.values()).contains(type);
    }
}
