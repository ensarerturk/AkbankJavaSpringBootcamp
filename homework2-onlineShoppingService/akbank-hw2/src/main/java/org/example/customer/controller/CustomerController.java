package org.example.customer.controller;

import lombok.RequiredArgsConstructor;
import org.example.customer.controller.contract.CustomerControllerContract;
import org.example.customer.dto.CustomerDTO;
import org.example.customer.dto.CustomerDeleteDTO;
import org.example.customer.dto.CustomerSaveAndUpdateDTO;
import org.example.general.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Represents a Controller class that handles HTTP requests about clients.
 * Controller, list all customers,
 * find a particular customer,
 * creating a new customer record,
 * supports operations such as deleting the customer and updating the customer information.
 * These operations are handled by a class that implements the "CustomerControllerContract" interface.
 * The results are returned as an HTTP response, packaged with the "RestResponse" class.
 * */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerControllerContract controllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        List<CustomerDTO> customerList = controllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id) {
        CustomerDTO CustomerById = controllerContract.findByIdCustomer(id);
        return ResponseEntity.ok(RestResponse.of(CustomerById));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RestResponse<CustomerDTO>> findByName(@PathVariable String name) {
        CustomerDTO customerByName = controllerContract.findByName(name);
        return ResponseEntity.ok(RestResponse.of(customerByName));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveAndUpdateDTO saveAndUpdateDTO) {
        CustomerDTO saveCustomer = controllerContract.save(saveAndUpdateDTO);
        return ResponseEntity.ok(RestResponse.of(saveCustomer));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody CustomerDeleteDTO deleteDTO) {
        controllerContract.deleteByName(deleteDTO);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> update(@PathVariable Long id, @RequestBody CustomerSaveAndUpdateDTO saveAndUpdateDTO) {
        CustomerDTO updateCustomer = controllerContract.update(id, saveAndUpdateDTO);
        return ResponseEntity.ok(RestResponse.of(updateCustomer));
    }
}