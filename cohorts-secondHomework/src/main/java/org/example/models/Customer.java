package org.example.models;

import java.util.ArrayList;
import java.util.List;

// Representing the customer and includes customer information and invoices.
public class Customer {
    // A String property representing the customer's name.
    private String name;
    // A String property that represents the customer's industry.
    private String sector;
    // A List<Invoice> property that holds the customer's invoices.
    private List<Invoice> invoices;

    // Creates a Customer object, taking the customer name and sector as parameters.
    // It also initializes the invoices list with an empty ArrayList.
    public Customer(String name, String sector) {
        this.name = name;
        this.sector = sector;
        this.invoices = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Sector: " + sector;
    }
}
