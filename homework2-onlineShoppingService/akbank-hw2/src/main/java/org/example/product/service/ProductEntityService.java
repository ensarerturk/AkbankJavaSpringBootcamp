package org.example.product.service;

import org.example.general.service.BaseEntityService;
import org.example.product.Product;
import org.example.product.dto.ProductUpdateDTO;
import org.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

/*
 * This class extends the "BaseEntityService" class and also provides the basic entity services (save, delete, find, etc.)
 * as the "Product" entity class is derived from the "BaseEntityService" class.
 * The class performs database operations using the "ProductRepository" class.
 * */
@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {
    public ProductEntityService(ProductRepository repository) {
        super(repository);
    }

    public Product update(Long id, ProductUpdateDTO productUpdateDTO) {
        Product productById = getRepository().findById(id).orElseThrow();
        productById.setPrice(productUpdateDTO.price());
        save(productById);
        return productById;
    }
}
