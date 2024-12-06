package fr.efrei.views;

import fr.efrei.domain.Bicycle;
import fr.efrei.domain.BicycleType;
import fr.efrei.domain.Customer;
import fr.efrei.factory.BicycleFactory;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.repository.CustomerRepository;
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

    private void deleteCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the customer to delete:");
        int id = sc.nextInt();
        boolean deleted = customerRepository.delete(id);
        if (deleted) {
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Failed to delete customer. ID not found.");
        }
    }
    public static void showCustomer(){
        List<Customer> customerList = customerRepository.getall();

        System.out.println("List of Salesman: ");
        for (Customer c : customerList){
            System.out.println(c.toString());
        }
    }

    private void readCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the customer to search:");
        int id = sc.nextInt();
        Customer customer = customerRepository.read(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("customer not found.");
        }
    }

    private void updateCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the customer to update:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        Customer currentCustomer = customerRepository.read(id);
        if (currentCustomer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter new details (or press enter to keep current value):");

        System.out.println("Current last name: " + currentCustomer.getLastname());
        System.out.println("New last name:");
        String LastName = sc.nextLine();
        LastName = LastName.isEmpty() ? currentCustomer.getLastname() : LastName;

        System.out.println("Current first name: " + currentCustomer.getFirstname());
        System.out.println("New first name:");
        String FirstName = sc.nextLine();
        FirstName = FirstName.isEmpty() ? currentCustomer.getFirstname() : FirstName;

        System.out.println("Current email: " + currentCustomer.getEmail());
        System.out.println("New email:");
        String email = sc.nextLine();
        email = email.isEmpty() ? currentCustomer.getEmail() : email;

        Customer updatedCustomer= CustomerFactory.buildCustomer(LastName,FirstName,id);
        if (updatedCustomer != null) {
            customerRepository.update(updatedCustomer);
            System.out.println("Bicycle updated successfully.");
        } else {
            System.out.println("Failed to update customer. Please check your input.");
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
                case "2" :  readCustomer();break;
                case "3" : updateCustomer(); break;
                case "4" : deleteCustomer();break;
                case "5" : showCustomer(); break;
                default:
                    System.out.println("Error : invalid command");
            }
        }while (!choice.equals("6"));

    }
}
