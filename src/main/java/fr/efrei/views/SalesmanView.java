package fr.efrei.views;

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
        int moneyInCheckout, numberOfSales, id;

        System.out.println("Please enter the following  information : ");
        System.out.println("Salesman first name : ");
        firstName = sc.nextLine();
        System.out.println("Salesman last name : ");
        lastName = sc.nextLine();
        System.out.println("Salesman money in checkout : ");
        moneyInCheckout = sc.nextInt();
        System.out.println("Salesman number of sales : ");
        numberOfSales = sc.nextInt();
        System.out.println("Salesman id : ");
        id = sc.nextInt();



        Salesman salesman = SalesmanFactory.buildSalesman(firstName, lastName, moneyInCheckout, numberOfSales, id);

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
                case "2" : break;
                case "3" : break;
                case "4" : break;
                case "5" : showSalesman(); break;
                default:
                    System.out.println("Error : invalid command");
            }
        }while (!choice.equals("6"));
    }
}