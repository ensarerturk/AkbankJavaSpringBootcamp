package org.example.models;

import java.time.LocalDate;

// Represents the invoice and includes the invoice amount and date.
public class Invoice {
    // A double property that represents the invoice amount.
    private double amount;
    // A LocalDate property that represents the invoice date.
    private LocalDate date;

    public Invoice(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
