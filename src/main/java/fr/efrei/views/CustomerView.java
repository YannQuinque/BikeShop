package fr.efrei.views;

import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.repository.ICustomerRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerView {


    private static ICustomerRepository customerRepository;

    public CustomerView() {
    }

    public CustomerView(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void createCustomer() {
        Scanner sc = new Scanner(System.in);
        String firstName, lastName, email;
        int id;

        System.out.println("Please enter the following  information : ");
        System.out.println("customer first name : ");
        firstName = sc.nextLine();
        System.out.println("customer last name : ");
        lastName = sc.nextLine();
        System.out.println("customer email : ");
        email = sc.nextLine();
        System.out.println("customer id : ");
        id = sc.nextInt();



        Customer customer= CustomerFactory.buildCustomer(lastName,firstName,id,email);

        if (customer != null) {
            customerRepository.create(customer);
        } else {
            System.out.println("Could not create customer");
        }
    }

    public static void showCustomer(){
        List<Customer> customerList = customerRepository.getall();

        System.out.println("List of Salesman: ");
        for (Customer c : customerList){
            System.out.println(c.toString());
        }
    }

    public void customerMenu(){
        String choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("customer Menu");
            System.out.println("1. Create a customer");
            System.out.println("2. Search/Read a customer");
            System.out.println("3. Update a customer");
            System.out.println("4. Delete a customer");
            System.out.println("5. Show/Get all customer");
            System.out.println("6. Exit");
            System.out.println("Please enter your choice : ");
            choice = sc.nextLine();

            switch(choice){
                case "1" : createCustomer(); break;
                case "2" : break;
                case "3" : break;
                case "4" : break;
                case "5" : showCustomer(); break;
                default:
                    System.out.println("Error : invalid command");
            }
        }while (!choice.equals("6"));
    }
}
