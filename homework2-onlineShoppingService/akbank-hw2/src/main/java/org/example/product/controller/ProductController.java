package org.example.product.controller;

import lombok.RequiredArgsConstructor;
import org.example.general.response.RestResponse;
import org.example.product.controller.contract.IProductControllerContract;
import org.example.product.dto.ProductDTO;
import org.example.product.dto.ProductSaveDTO;
import org.example.product.dto.ProductUpdateDTO;
import org.example.product.mapper.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Defines a REST controller class named "ProductController".
* This controller class is used to handle product-related HTTP requests and invokes the relevant business logic.
* */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    // It uses the "IProductControllerContract" interface, which is responsible for the relevant business logic.
    private final IProductControllerContract productControllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll(){
        List<ProductDTO> allProduct = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(allProduct));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO productById = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(productById));
    }

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveDTO productSaveDTO){
        ProductDTO saveProduct = productControllerContract.save(productSaveDTO);
        return ResponseEntity.ok(RestResponse.of(saveProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> update(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        ProductDTO updateProduct = productControllerContract.update(id, productUpdateDTO);
        return ResponseEntity.ok(RestResponse.of(updateProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
