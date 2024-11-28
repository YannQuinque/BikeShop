package fr.efrei.repository;

import fr.efrei.domain.Bicycle;
import java.util.ArrayList;
import java.util.List;

public class BicycleRepository implements IBicycleRepository {
    private static BicycleRepository repository = null; 
    private List<Bicycle> bicycleList;

    private BicycleRepository() {
        bicycleList = new ArrayList<>(); 
    }

    public static BicycleRepository getRepository() { 
        if (repository == null) {
            repository = new BicycleRepository();
        }
        return repository;
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        if (bicycle == null) {
            return null;
        }
        if (read(bicycle.getId()) != null) {
            return null; 
        }
        bicycleList.add(bicycle);
        return bicycle;
    }

    @Override
    public Bicycle read(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return bicycleList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        if (bicycle == null) {
            return null;
        }
        Bicycle existingBicycle = read(bicycle.getId());
        if (existingBicycle == null) {
            return null;
        }
        delete(bicycle.getId());
        bicycleList.add(bicycle);
        return bicycle;
    }

    @Override
    public boolean delete(Integer id) {
        if (id == null || id <= 0) {
            return false;
        }
        Bicycle bicycleToDelete = read(id);
        if (bicycleToDelete == null) {
            return false;
        }
        return bicycleList.remove(bicycleToDelete);
    }

    @Override
    public List<Bicycle> getall() {
        return new ArrayList<>(bicycleList);
    }
}
