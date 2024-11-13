package fr.efrei.factory;

import fr.efrei.domain.Sales;
import fr.efrei.util.Helper;
import java.util.Date;

public class SalesFactory {
    public static Sales buildSales(int id, Date date, float totalAmount) {
        if (id <= 0) {
            return null;
        }

        if (date == null) {
            return null;
        }

        if (totalAmount <= 0.0f) {
            return null;
        }

        return new Sales(id, date, totalAmount);
    }
}
