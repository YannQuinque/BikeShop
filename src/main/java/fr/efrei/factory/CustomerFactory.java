package fr.efrei.factory;
import fr.efrei.util.Helper;
import fr.efrei.domain.Customer;

public class CustomerFactory {
    public static Customer buildCustomer(String lastname, String firstname,int ID, String email){

        if(Helper.isNullOrEmpty(firstname) || Helper.isNullOrEmpty(lastname)||Helper.isNullOrEmpty(email)){
            return null;
        }

        if(ID <= 0){
            return null;
        }



        return new Customer.Builder().setFirstname(firstname)
                .setLastname(lastname)
                .setID(ID)
                .setEmail(email)
                .build();

    }
}
