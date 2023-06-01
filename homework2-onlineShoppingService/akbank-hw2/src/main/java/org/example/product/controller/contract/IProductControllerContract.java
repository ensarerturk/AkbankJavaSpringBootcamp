package org.example.product.controller.contract;

import org.example.product.dto.ProductDTO;
import org.example.product.dto.ProductSaveDTO;
import org.example.product.dto.ProductUpdateDTO;

import java.util.List;

/*
 * It is used to communicate with a controller class that handles product-related HTTP requests. It contains methods for performing operations.
 * These methods work with the corresponding DTO (Data Transfer Object) classes to retrieve and return the required data.
 * */

public interface IProductControllerContract {

    ProductDTO save(ProductSaveDTO productSaveDTO);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void delete(Long id);

    ProductDTO update(Long id, ProductUpdateDTO productUpdateDTO);
}