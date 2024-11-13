package fr.efrei.factory;

import fr.efrei.domain.Salesman;
import fr.efrei.util.Helper;

public class SalesmanFactory {
    public static Salesman buildSalesman(String firstName, String lastName, int moneyInCheckout, int numberOfSales){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
            return null;

        if(moneyInCheckout <= 0){
            return null;
        }

        if(numberOfSales <= 0.0){
            return null;
        }

            return new Salesman.Builder().setFirstName(firstName)
                    .setLastName(lastName)
                    .setMoneyInCheckout(moneyInCheckout)
                    .setNumberOfSales(numberOfSales)
                    .build();
    }
}
