package fr.efrei.repository;

import fr.efrei.domain.Sales;
import java.util.ArrayList;
import java.util.List;

public class SalesRepository implements ISalesRepository {
    private static SalesRepository repository = null;
    private List<Sales> salesList;

    private SalesRepository() {
        salesList = new ArrayList<>();
    }

    public static SalesRepository getRepository() {
        if (repository == null) {
            repository = new SalesRepository();
        }
        return repository;
    }

    @Override
    public Sales create(Sales sales) {
        if (sales == null) {
            return null;
        }
        if (read(sales.getId()) != null) {
            return null;
        }
        salesList.add(sales);
        return sales;
    }

    @Override
    public Sales read(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return salesList.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Sales update(Sales sales) {
        if (sales == null) {
            return null;
        }
        Sales existingSales = read(sales.getId());
        if (existingSales == null) {
            return null;
        }
        delete(sales.getId());
        salesList.add(sales);
        return sales;
    }

    @Override
    public boolean delete(Integer id) {
        if (id == null || id <= 0) {
            return false;
        }
        Sales salesToDelete = read(id);
        if (salesToDelete == null) {
            return false;
        }
        return salesList.remove(salesToDelete);
    }

    @Override
    public List<Sales> getall() {
        return new ArrayList<>(salesList);
    }
}
