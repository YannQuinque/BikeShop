package fr.efrei.repository;

import fr.efrei.domain.Sales;
import java.util.ArrayList;
import java.util.List;

public class SalesRepository implements ISalesRepository {
    private static ISalesRepository repository = null;
    private List<Sales> salesList;

    private SalesRepository() {
        salesList = new ArrayList<Sales>();
    }

    public static ISalesRepository getRepository() {
        if(repository == null) {
            repository = new SalesRepository();
        }
        return repository;
    }

    @Override
    public Sales create(Sales sales) {
        boolean success = salesList.add(sales);
        if(success) {
            return sales;
        }
        return null;
    }

    @Override
    public Sales read(Integer id) {
        for(Sales s : salesList) {
            if(s.getId() == id)
                return s;
        }
        return null;
    }

    @Override
    public Sales update(Sales sales) {
        int id = sales.getId();
        Sales salesOld = read(id);
        if(salesOld == null)
            return null;
        boolean success = delete(id);
        if(success) {
            if(salesList.add(sales))
                return sales;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Sales salesToDelete = read(id);
        if(salesToDelete == null)
            return false;
        return(salesList.remove(salesToDelete));
    }

    @Override
    public List<Sales> getall() {
        return salesList;
    }
}
