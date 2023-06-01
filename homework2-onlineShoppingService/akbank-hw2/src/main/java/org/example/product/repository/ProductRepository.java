package org.example.product.repository;

import org.example.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* It is an interface designed to perform database operations for the "Product" entity class.
* */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
