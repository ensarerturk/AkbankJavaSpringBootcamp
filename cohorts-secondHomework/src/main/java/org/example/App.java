package org.example;

import org.example.management.CustomerManagementSystem;
import org.example.models.Customer;
import org.example.models.Invoice;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

// Demonstrates the use of a customer management system using functions of the CustomerManagementSystem class.
public class App {
    public static void main(String[] args) {

        // The CustomerManagementSystem object is created and sample customers are added using the createCustomerManagementSystem method.
        CustomerManagementSystem managementSystem = createCustomerManagementSystem();

        // All customers are retrieved using "getAllCustomers" method and listed by "displayCustomers" method.
        System.out.println("All customers:");
        List<Customer> allCustomers = managementSystem.getAllCustomers();
        displayCustomers(allCustomers);
        System.out.println();


        // Customers whose names start with the letter "C" are retrieved using
        // the "getCustomersWithC" method and listed with the "displayCustomers" method.
        System.out.println("Customers with the letter C:");
        List<Customer> customersWithC = managementSystem.getCustomersWithC();
        displayCustomers(customersWithC);
        System.out.println();

        // The total amount of invoices in June is calculated and printed using the "getTotalAmountOfInvoicesForJune" method.
        System.out.println("Invoice totals of customers registered in June:");
        double totalAmountForJune = managementSystem.getTotalAmountOfInvoicesForJune();
        System.out.println("Total Amount: " + totalAmountForJune);
        System.out.println();

        // All invoices are received using the "getAllInvoices" method and listed with the "displayInvoices" method.
        System.out.println("All invoices in the system:");
        List<Invoice> allInvoices = managementSystem.getAllInvoices();
        displayInvoices(allInvoices);
        System.out.println();

        // Invoices over 1500TL are received using the "getHighInvoices" method and listed with the "displayInvoices" method.
        System.out.println("Invoices over 1500TL in the system:");
        List<Invoice> highAmountInvoices = managementSystem.getHighInvoices();
        displayInvoices(highAmountInvoices);
        System.out.println();

        // The average amount of invoices over 1500TL is calculated and printed using the "getAvgHighInvoices" method.
        double averageHighAmountInvoices = managementSystem.getAvgHighInvoices();
        System.out.println("Average of invoices over 1500TL: " + averageHighAmountInvoices);
        System.out.println();

        // The names of customers with invoices under 500TL are retrieved using
        // the "getCustomersWithLowInvoices" method and listed with the "displayCustomerNames" method.
        System.out.println("Names of customers with invoices under 500TL:");
        List<Customer> customersWithLowAmountInvoices = managementSystem.getCustomersWithLowInvoices();
        displayCustomerNames(customersWithLowAmountInvoices);
        System.out.println();

        // Sectors of customers whose invoices are below 750 in June are retrieved using
        // the "getUniqueSecForLowAvgInvoices" method and listed with the "displaySectors" method.
        System.out.println("Sectors of customers with an average invoice of less than 750TL in June:");
        Set<String> uniqueSectors = managementSystem.getUniqueSecForLowAvgInvoices();
        displaySectors(uniqueSectors);
    }

    // The "createCustomerManagementSystem" method returns the "CustomerManagementSystem" object,
    // creating instance Customer and Invoice objects.
    private static CustomerManagementSystem createCustomerManagementSystem() {
        CustomerManagementSystem managementSystem = new CustomerManagementSystem();

        Customer customer1 = new Customer("Netaş Telekominikasyon", "Telecommunications and Network Infrastructure");
        customer1.addInvoice(new Invoice(1000, LocalDate.of(2023, Month.JANUARY, 15)));
        customer1.addInvoice(new Invoice(1500, LocalDate.of(2023, Month.JUNE, 20)));
        managementSystem.addCustomer(customer1);

        Customer customer2 = new Customer("Akbank", "Finance");
        customer2.addInvoice(new Invoice(2000, LocalDate.of(2023, Month.FEBRUARY, 10)));
        customer2.addInvoice(new Invoice(800, LocalDate.of(2023, Month.JUNE, 25)));
        managementSystem.addCustomer(customer2);

        Customer customer3 = new Customer("SASKI", "Water and Sewerage Services");
        customer3.addInvoice(new Invoice(3000, LocalDate.of(2023, Month.MARCH, 5)));
        customer3.addInvoice(new Invoice(1200, LocalDate.of(2023, Month.JUNE, 30)));
        managementSystem.addCustomer(customer3);

        Customer customer4 = new Customer("Turkcell", "Telecommunications");
        customer4.addInvoice(new Invoice(400, LocalDate.of(2023, Month.MARCH, 1)));
        customer4.addInvoice(new Invoice(250, LocalDate.of(2023, Month.JUNE, 15)));
        managementSystem.addCustomer(customer4);

        return managementSystem;
    }

    /*
     * The methods displayCustomers, displayInvoices, displayCustomerNames and displaySectors are
     * used to print data such as customer list, invoice list, customer names and sectors.
     * */
    private static void displayCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void displayInvoices(List<Invoice> invoices) {
        for (Invoice invoice : invoices) {
            System.out.println(invoice.getAmount() + " - " + invoice.getDate());
        }
    }

    private static void displayCustomerNames(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    private static void displaySectors(Set<String> sectors) {
        for (String sector : sectors) {
            System.out.println(sector);
        }
    }
}