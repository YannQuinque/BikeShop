package fr.efrei.views;

import fr.efrei.domain.Bicycle;
import fr.efrei.domain.BicycleType;
import fr.efrei.factory.BicycleFactory;
import fr.efrei.repository.IBicycleRepository;

import java.util.List;
import java.util.Scanner;

public class BicycleView {
    private static IBicycleRepository bicycleRepository;

    public BicycleView() {
    }

    public BicycleView(IBicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    public static void createBicycle() {
        Scanner sc = new Scanner(System.in);
        int id, nbStock;
        String brand, model;
        float price;
        BicycleType type;

        System.out.println("Please enter the following information:");
        System.out.println("Bicycle ID:");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Bicycle brand:");
        brand = sc.nextLine();
        System.out.println("Bicycle model:");
        model = sc.nextLine();
        System.out.println("Bicycle price:");
        price = sc.nextFloat();
        System.out.println("Bicycle type (ROAD, MOUNTAIN, CITY):");
        type = BicycleType.valueOf(sc.next().toUpperCase());
        System.out.println("Number in stock:");
        nbStock = sc.nextInt();

        Bicycle bicycle = BicycleFactory.buildBicycle(id, brand, model, price, type, nbStock);

        if (bicycle != null) {
            bicycleRepository.create(bicycle);
            System.out.println("Bicycle created successfully.");
        } else {
            System.out.println("Could not create bicycle. Please check your input.");
        }
    }

    public static void showBicycles() {
        List<Bicycle> bicycleList = bicycleRepository.getall();

        System.out.println("List of Bicycles:");
        for (Bicycle b : bicycleList) {
            System.out.println(b.toString());
        }
    }

    public void bicycleMenu() {
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nBicycle Menu");
            System.out.println("1. Create a Bicycle");
            System.out.println("2. Search/Read a Bicycle");
            System.out.println("3. Update a Bicycle");
            System.out.println("4. Delete a Bicycle");
            System.out.println("5. Show/Get all Bicycles");
            System.out.println("6. Exit");
            System.out.println("Please enter your choice:");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    createBicycle();
                    break;
                case "2":
                    readBicycle();
                    break;
                case "3":
                    updateBicycle();
                    break;
                case "4":
                    deleteBicycle();
                    break;
                case "5":
                    showBicycles();
                    break;
                case "6":
                    System.out.println("Exiting Bicycle Menu.");
                    break;
                default:
                    System.out.println("Error: invalid command");
            }
        } while (!choice.equals("6"));
    }

    private void readBicycle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the bicycle to search:");
        int id = sc.nextInt();
        Bicycle bicycle = bicycleRepository.read(id);
        if (bicycle != null) {
            System.out.println(bicycle);
        } else {
            System.out.println("Bicycle not found.");
        }
    }

    private void updateBicycle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the bicycle to update:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        Bicycle existingBicycle = bicycleRepository.read(id);
        if (existingBicycle == null) {
            System.out.println("Bicycle not found.");
            return;
        }

        System.out.println("Enter new details (press enter to keep current value):");

        System.out.println("Current brand: " + existingBicycle.getBrand());
        System.out.println("New brand:");
        String brand = sc.nextLine();
        brand = brand.isEmpty() ? existingBicycle.getBrand() : brand;

        System.out.println("Current model: " + existingBicycle.getModel());
        System.out.println("New model:");
        String model = sc.nextLine();
        model = model.isEmpty() ? existingBicycle.getModel() : model;

        System.out.println("Current price: " + existingBicycle.getPrice());
        System.out.println("New price:");
        String priceStr = sc.nextLine();
        float price = priceStr.isEmpty() ? existingBicycle.getPrice() : Float.parseFloat(priceStr);

        System.out.println("Current type: " + existingBicycle.getType());
        System.out.println("New type (ROAD, MOUNTAIN, CITY):");
        String typeStr = sc.nextLine();
        BicycleType type = typeStr.isEmpty() ? existingBicycle.getType() : BicycleType.valueOf(typeStr.toUpperCase());

        System.out.println("Current stock: " + existingBicycle.getNbStock());
        System.out.println("New stock:");
        String stockStr = sc.nextLine();
        int nbStock = stockStr.isEmpty() ? existingBicycle.getNbStock() : Integer.parseInt(stockStr);

        Bicycle updatedBicycle = BicycleFactory.buildBicycle(id, brand, model, price, type, nbStock);
        if (updatedBicycle != null) {
            bicycleRepository.update(updatedBicycle);
            System.out.println("Bicycle updated successfully.");
        } else {
            System.out.println("Failed to update bicycle. Please check your input.");
        }
    }

    private void deleteBicycle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the bicycle to delete:");
        int id = sc.nextInt();
        boolean deleted = bicycleRepository.delete(id);
        if (deleted) {
            System.out.println("Bicycle deleted successfully.");
        } else {
            System.out.println("Failed to delete bicycle. ID not found.");
        }
    }
}
