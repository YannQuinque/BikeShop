package fr.efrei.views;

import fr.efrei.domain.Bicycle;
import fr.efrei.factory.BicycleFactory;
import fr.efrei.views.BicycleView;

import fr.efrei.domain.Sales;
import fr.efrei.repository.ISalesRepository;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static fr.efrei.views.BicycleView.bicycleRepository;

public class SalesView {
    private static ISalesRepository salesRepository;

    public SalesView() {}

    public SalesView(ISalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public static void createSale() {
        Scanner sc = new Scanner(System.in);
        int id, idCustomer;
        float totalAmount;
        System.out.println("Please enter the following information:");

        System.out.println("Sale ID:");
        id = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Customer ID:");
        idCustomer = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Total Amount:");
        totalAmount = sc.nextFloat();
        sc.nextLine(); 

        System.out.println("Date (YYYY-MM-DD):");
        String dateStr = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return; 
        }

        HashMap<Integer, Integer> bicycleHashMap = new HashMap<>();

        while (true) {
            System.out.println("Add a bicycle to the sale? (yes/no)");
            String response = sc.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.println("Enter Bicycle ID:");
            int bicycleId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            sc.nextLine(); 

            Bicycle bicycle = bicycleRepository.read(bicycleId);

            if (bicycle != null && bicycle.getNbStock() >= quantity) {
                Bicycle updatedBicycle = new Bicycle.Builder()
                        .setId(bicycle.getId())
                        .setBrand(bicycle.getBrand())
                        .setModel(bicycle.getModel())
                        .setPrice(bicycle.getPrice())
                        .setType(bicycle.getType())
                        .setNbStock(bicycle.getNbStock() - quantity) 
                        .build();

                bicycleRepository.update(updatedBicycle);
                bicycleHashMap.put(bicycleId, quantity);
            } else {
                System.out.println("Not enough stock for Bicycle ID: " + bicycleId);
                return; 
            }
        }

        Sales sale = new Sales.Builder()
                .setId(id)
                .setIdCustomer(idCustomer)
                .setTotalAmount(totalAmount)
                .setDate(date)
                .setBicycleHashMap(bicycleHashMap)
                .build();

        if (sale != null) {
            salesRepository.create(sale);
            System.out.println("Sale created successfully.");
        } else {
            System.out.println("Could not create sale. Please check your input.");
        }
    }
    public static void showSales() {
        List<Sales> salesList = salesRepository.getall();
        System.out.println("List of Sales:");
        for (Sales s : salesList) {
            System.out.println(s.toString());
        }
    }

    public static void salesMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nSales Menu");
            System.out.println("1. Create a Sale");
            System.out.println("2. Search/Read a Sale");
            System.out.println("3. Update a Sale");
            System.out.println("4. Delete a Sale");
            System.out.println("5. Show/Get all Sales");
            System.out.println("6. Exit");
            System.out.println("Please enter your choice:");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    createSale();
                    break;
                case "2":
                    readSale();
                    break;
                case "3":
                    updateSale();
                    break;
                case "4":
                    deleteSale();
                    break;
                case "5":
                    showSales();
                    break;
                case "6":
                    System.out.println("Exiting Sales Menu.");
                    break;
                default:
                    System.out.println("Error: invalid command");
            }
        } while (!choice.equals("6"));
    }

    private static void readSale() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the sale to search:");
        int id = sc.nextInt();
        Sales sale = salesRepository.read(id);

        if (sale != null) {
            System.out.println(sale);
        } else {
            System.out.println("Sale not found.");
        }
    }

    private static void updateSale() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the sale to update:");
        int id = sc.nextInt();
        sc.nextLine();

        Sales existingSale = salesRepository.read(id);

        if (existingSale == null) {
            System.out.println("Sale not found.");
            return;
        }

        System.out.println("Enter new details (press enter to keep current value):");

        System.out.println("Current date: " + existingSale.getDate());
        System.out.println("New date (YYYY-MM-DD):");
        String dateStr = sc.nextLine();

        Date date = existingSale.getDate(); 
        if (!dateStr.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                return;
            }
        }

        System.out.println("Current total amount: " + existingSale.getTotalAmount());
        System.out.println("New total amount:");
        String totalAmountStr = sc.nextLine();
        float totalAmount = totalAmountStr.isEmpty() ? existingSale.getTotalAmount() : Float.parseFloat(totalAmountStr);

        System.out.println("Current customer ID: " + existingSale.getIdCustomer());
        System.out.println("New customer ID:");
        String idCustomerStr = sc.nextLine();
        int idCustomer = idCustomerStr.isEmpty() ? existingSale.getIdCustomer() : Integer.parseInt(idCustomerStr);

        HashMap<Integer, Integer> bicycleHashMap = new HashMap<>(existingSale.getBicycleHashMap());

        while (true) {
            System.out.println("Add or update a bicycle in the sale? (yes/no)");
            String response = sc.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.println("Enter Bicycle ID:");
            int bicycleId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            sc.nextLine(); 

            bicycleHashMap.put(bicycleId, quantity);
        }

        Sales updatedSale = new Sales.Builder()
                .setId(id)
                .setDate(date)
                .setTotalAmount(totalAmount)
                .setIdCustomer(idCustomer)
                .setBicycleHashMap(bicycleHashMap)
                .build();

        if (updatedSale != null) {
            salesRepository.update(updatedSale);
            System.out.println("Sale updated successfully.");
        } else {
            System.out.println("Failed to update sale. Please check your input.");
        }
    }

    private static void deleteSale() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the sale to delete:");
        int id = sc.nextInt();

        boolean deleted = salesRepository.delete(id);

        if (deleted) {
            System.out.println("Sale deleted successfully.");
        } else {
            System.out.println("Failed to delete sale. ID not found.");
        }
    }
}
