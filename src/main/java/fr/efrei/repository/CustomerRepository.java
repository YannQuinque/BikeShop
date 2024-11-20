package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Salesman;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static ICustomerRepository repository = null;
    private List<Customer> CuList;

    private CustomerRepository(){
        CuList = new ArrayList<Customer>();
    }

    public static ICustomerRepository getRepository(){
        if(repository == null){
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer){
        boolean success = CuList.add(customer);
        if(success){
            return customer;
        }
        return null;
    }

    @Override
    public Customer read(Integer id){
        for(Customer e : CuList) {
            if (e.getID() == id)
                return e;
        }
        return null;

        //Hmk: Lambda expressions
    }

    @Override
    public Customer update(Customer customer){
        int id = customer.getID();
        Customer customerold = read(id);
        if(customerold == null)
            return null;
        boolean success = delete(id);
        if(success){
            if(CuList.add(customer))
                return customer;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id){
        Customer customertodelete = read(id);
        if(customertodelete == null)
            return false;
        return(CuList.remove(customertodelete));
    }

    @Override
    public List<Customer> getall() {
        return CuList;
    }

}
