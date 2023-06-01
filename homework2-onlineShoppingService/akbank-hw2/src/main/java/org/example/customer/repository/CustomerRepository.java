package org.example.customer.repository;

import org.example.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Represents a data access interface that performs database operations of the Customer class.

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // It is used to find the customer whose name is specified in the database.
    Customer findCustomerByName(String name);
}