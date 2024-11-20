package fr.efrei.repository;

import fr.efrei.domain.Salesman;

import java.util.List;

public interface ISalesmanRepository extends IRepository<Salesman,Integer> {
    List<Salesman> getall();
}