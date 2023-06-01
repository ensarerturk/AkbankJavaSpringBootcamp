package org.example.product.controller.contract.impl;

import lombok.RequiredArgsConstructor;
import org.example.general.exception.ProductNotFoundException;
import org.example.product.Product;
import org.example.product.controller.contract.IProductControllerContract;
import org.example.product.dto.ProductDTO;
import org.example.product.dto.ProductSaveDTO;
import org.example.product.dto.ProductUpdateDTO;
import org.example.product.mapper.ProductMapper;
import org.example.product.service.ProductEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * It is a service class that implements the IProductControllerContract interface and performs product operations.
 * It performs the related operations using the ProductEntityService class and converts the data into the appropriate
 * DTO (Data Transfer Object) format using the ProductMapper class.
 * */

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements IProductControllerContract {

    private final ProductEntityService productEntityService;

    @Override
    public ProductDTO save(ProductSaveDTO productSaveDTO) {
        Product entity = ProductMapper.INSTANCE.toEntity(productSaveDTO);
        entity = productEntityService.save(entity);
        return ProductMapper.INSTANCE.toDTO(entity);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productEntityService.findAll();
        return ProductMapper.INSTANCE.toDTOList(productList);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product productById = productEntityService.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.INSTANCE.toDTO(productById);
    }

    @Override
    public void delete(Long id) {
        productEntityService.delete(id);
    }

    @Override
    public ProductDTO update(Long id, ProductUpdateDTO productUpdateDTO) {
        Product updateProduct = productEntityService.update(id, productUpdateDTO);
        return ProductMapper.INSTANCE.toDTO(updateProduct);
    }
}
