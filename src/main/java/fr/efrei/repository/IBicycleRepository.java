package fr.efrei.repository;

import fr.efrei.domain.Bicycle;
import java.util.List;

public interface IBicycleRepository extends IRepository<Bicycle,Integer> {
    List<Bicycle> getall();
}
