package fr.efrei;

import fr.efrei.repository.ISalesmanRepository;
import fr.efrei.repository.SalesmanRepository;
import fr.efrei.views.SalesmanView;

import fr.efrei.repository.IBicycleRepository;
import fr.efrei.repository.BicycleRepository;
import fr.efrei.views.BicycleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ISalesmanRepository salesmanRepository = SalesmanRepository.getRepository();
        SalesmanView salesmanView = new SalesmanView(salesmanRepository);

        IBicycleRepository bicycleRepository = BicycleRepository.getRepository();
        BicycleView bicycleView = new BicycleView(bicycleRepository);

        String choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Main Menu");
            System.out.println("1. Salesman Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Sales Menu");
            System.out.println("4. Bicycle Menu");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice : \n");
            choice = sc.nextLine();

            switch (choice){
                case "1" : salesmanView.salesmanMenu();
                case "2" : break;
                case "3" : break;
                case "4" : bicycleView.bicycleMenu();
                case "5" : break;
                default:
                    System.out.println("Error : invalid choice");
            }
        }while (!choice.equals("5"));
    }
}
