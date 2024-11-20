package fr.efrei.repository;

import fr.efrei.domain.Sales;
import java.util.List;

public interface ISalesRepository extends IRepository<Sales,Integer> {
    List<Sales> getall();
}
