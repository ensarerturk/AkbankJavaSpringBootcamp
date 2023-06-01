package org.example.management;

import org.example.models.Customer;
import org.example.models.Invoice;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// This class represents a customer management system and includes various functions.
public class CustomerManagementSystem {

    // customers: A List<Customer> property that represents a list of Customer objects.
    private List<Customer> customers;

    // Initializes the customers list with an empty ArrayList when the CustomerManagementSystem object is created.
    public CustomerManagementSystem() {
        this.customers = new ArrayList<>();
    }

    // Adds a customer object to the customers list.
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Returns a list of customers containing all customers.
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Returns a list of customers whose names begin with the letter "C".
    public List<Customer> getCustomersWithC() {
        return customers.stream()
                .filter(c -> c.getName().contains("C"))
                .collect(Collectors.toList());
    }

    // Returns the total amount of invoices for the month of June.
    public double getTotalAmountOfInvoicesForJune() {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .filter(i -> i.getDate().getMonth() == Month.JUNE)
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    // Returns a list of all invoices.
    public List<Invoice> getAllInvoices() {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .collect(Collectors.toList());
    }

    // Returns a list of invoices with an amount greater than 1500.
    public List<Invoice> getHighInvoices() {
        return getAllInvoices().stream()
                .filter(i -> i.getAmount() > 1500)
                .collect(Collectors.toList());
    }


    // Returns the average amount of invoices with an amount greater than 1500.
    public double getAvgHighInvoices() {
        return getHighInvoices().stream()
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    // Returns a list of customers with invoices less than 500.
    public List<Customer> getCustomersWithLowInvoices() {
        return customers.stream()
                .filter(c -> c.getInvoices().stream().anyMatch(i -> i.getAmount() < 500))
                .collect(Collectors.toList());
    }

    // Returns a unique set of sectors for customers with invoices less than 750 on average in June.
    public Set<String> getUniqueSecForLowAvgInvoices() {
        return customers.stream()
                .filter(c -> c.getInvoices().stream().anyMatch(i -> i.getDate().getMonth() == Month.JUNE))
                .filter(c -> {
                    double average = c.getInvoices().stream()
                            .filter(i -> i.getDate().getMonth() == Month.JUNE)
                            .mapToDouble(Invoice::getAmount)
                            .average()
                            .orElse(0);
                    return average < 750;
                })
                .map(Customer::getSector)
                .collect(Collectors.toSet());
    }
}
