package fr.efrei.factory;

import fr.efrei.domain.Salesman;
import fr.efrei.util.Helper;

public class SalesmanFactory {
    public static Salesman buildSalesman(int id, String firstName, String lastName){
        if(id <= 0){
            return null;
        }
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
            return null;

            return new Salesman.Builder().setFirstName(firstName)
                    .setLastName(lastName)
                    .setId(id)
                    .build();
    }
}
