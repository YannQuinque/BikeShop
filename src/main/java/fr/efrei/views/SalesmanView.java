package fr.efrei.views;

//Salesman View
import fr.efrei.domain.Salesman;
import fr.efrei.factory.SalesmanFactory;
import fr.efrei.repository.ISalesmanRepository;

import java.util.List;
import java.util.Scanner;

public class SalesmanView {
    private static ISalesmanRepository salesmanRepository;

    public SalesmanView() {
    }

    public SalesmanView(ISalesmanRepository salesmanRepository) {
        this.salesmanRepository = salesmanRepository;
    }

    public static void createSalesman() {
        Scanner sc = new Scanner(System.in);
        String firstName, lastName;
        int id;

        System.out.println("Please enter the following  information : ");
        System.out.println("Salesman first name : ");
        firstName = sc.nextLine();
        System.out.println("Salesman last name : ");
        lastName = sc.nextLine();
        System.out.println("Salesman id : ");
        id = sc.nextInt();

        Salesman salesman = SalesmanFactory.buildSalesman(id, firstName, lastName);

        if (salesman != null) {
            salesmanRepository.create(salesman);
        } else {
            System.out.println("Could not create salesman");
        }
    }

    public static void showSalesman(){
        List<Salesman> salesmanList = salesmanRepository.getall();

        System.out.println("List of Salesman: ");
        for (Salesman s : salesmanList){
            System.out.println(s.toString());
        }
    }

    public static void readSalesman(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the Salesman to search:");
        int id = sc.nextInt();
        Salesman salesman = salesmanRepository.read(id);
        if (salesman != null) {
            System.out.println(salesman);
        } else {
            System.out.println("Bicycle not found.");
        }

    }

    public static void updateSalesman(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the salesman to update:");
        int id = sc.nextInt();
        sc.nextLine();

        Salesman salesmanOld = salesmanRepository.read(id);
        if (salesmanOld == null) {
            System.out.println("Salesman not found.");
            return;
        }

        System.out.println("Enter new details (press enter to keep current value):");

        System.out.println("Current first name: " + salesmanOld.getFirstName());
        System.out.println("New first name:");
        String firstName = sc.nextLine();
        firstName = firstName.isEmpty() ? salesmanOld.getFirstName() : firstName;

        System.out.println("Current last name: " + salesmanOld.getLastName());
        System.out.println("New last name:");
        String lastName = sc.nextLine();
        lastName = lastName.isEmpty() ? salesmanOld.getLastName() : lastName;

        Salesman updatedSalesman = SalesmanFactory.buildSalesman(id, firstName, lastName);
        if (updatedSalesman != null) {
            salesmanRepository.update(updatedSalesman);
            System.out.println("Salesman updated successfully.");
        } else {
            System.out.println("Failed to update salesman. Please check your input.");
        }
    }

    public void deleteSalesman() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the salesman to delete:");
        int id = sc.nextInt();
        boolean deleted = salesmanRepository.delete(id);
        if (deleted) {
            System.out.println("Salesman deleted successfully.");
        } else {
            System.out.println("Failed to delete salesman. ID not found.");
        }

    }

    public void salesmanMenu(){
        String choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Salesman Menu");
            System.out.println("1. Create a Salesman");
            System.out.println("2. Search/Read a Salesman");
            System.out.println("3. Update a Salesman");
            System.out.println("4. Delete a Salesman");
            System.out.println("5. Show/Get all Salesmen");
            System.out.println("6. Exit");
            System.out.println("Please enter your choice : ");
            choice = sc.nextLine();

            switch(choice){
                case "1" : createSalesman(); break;
                case "2" : readSalesman(); break;
                case "3" : updateSalesman(); break;
                case "4" : deleteSalesman(); break;
                case "5" : showSalesman(); break;
                case "6": System.out.println("Exiting Salesman Menu.");break;
                default:
                    System.out.println("Error : invalid command");
            }
        }while (!choice.equals("6"));
    }
}