package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.domain.Salesman;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer,Integer> {
    List<Customer> getall();
}