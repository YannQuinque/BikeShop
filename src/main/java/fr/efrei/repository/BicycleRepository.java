package fr.efrei.repository;

import fr.efrei.domain.Bicycle;
import java.util.ArrayList;
import java.util.List;

public class BicycleRepository implements IBicycleRepository {
    private static IBicycleRepository repository = null;
    private List<Bicycle> bicycleList;

    private BicycleRepository() {
        bicycleList = new ArrayList<Bicycle>();
    }

    public static IBicycleRepository getRepository() {
        if(repository == null) {
            repository = new BicycleRepository();
        }
        return repository;
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        boolean success = bicycleList.add(bicycle);
        if(success) {
            return bicycle;
        }
        return null;
    }

    @Override
    public Bicycle read(Integer id) {
        for(Bicycle b : bicycleList) {
            if(b.getId() == id)
                return b;
        }
        return null;
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        int id = bicycle.getId();
        Bicycle bicycleOld = read(id);
        if(bicycleOld == null)
            return null;
        boolean success = delete(id);
        if(success) {
            if(bicycleList.add(bicycle))
                return bicycle;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Bicycle bicycleToDelete = read(id);
        if(bicycleToDelete == null)
            return false;
        return(bicycleList.remove(bicycleToDelete));
    }

    @Override
    public List<Bicycle> getall() {
        return bicycleList;
    }
}
