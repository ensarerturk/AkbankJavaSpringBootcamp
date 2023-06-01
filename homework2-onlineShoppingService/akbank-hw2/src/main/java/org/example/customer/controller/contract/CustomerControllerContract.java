package org.example.customer.controller.contract;

import org.example.customer.dto.CustomerDTO;
import org.example.customer.dto.CustomerDeleteDTO;
import org.example.customer.dto.CustomerSaveAndUpdateDTO;

import java.util.List;

/*
 * The interface provides basic operations such as creating, listing, finding, deleting and updating customers.
 * Working with the corresponding DTO classes, it performs operations based on the incoming data and
 * returns the results with the CustomerDTO class.
 * */

public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveAndUpdateDTO customerSaveAndUpdateDTO);

    List<CustomerDTO> findAll();

    CustomerDTO findByIdCustomer(Long id);

    CustomerDTO findByName(String name);

    void deleteByName(CustomerDeleteDTO customerDeleteDTO);

    CustomerDTO update(Long id, CustomerSaveAndUpdateDTO CustomerSaveAndUpdateDTO);
}