package org.example.customer.controller.contract.impl;

import lombok.RequiredArgsConstructor;
import org.example.customer.Customer;
import org.example.customer.controller.contract.CustomerControllerContract;
import org.example.customer.dto.CustomerDTO;
import org.example.customer.dto.CustomerDeleteDTO;
import org.example.customer.dto.CustomerSaveAndUpdateDTO;
import org.example.customer.mapper.CustomerMapper;
import org.example.customer.service.CustomerEntityService;
import org.example.general.exception.CustomerNotFoundException;
import org.example.general.exception.NameAndPhoneNotMatchException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/*
 * This code defines a class that implements a Controller interface for client operations.
 * It implements methods in the interface and performs operations by communicating with the corresponding class of service.
 * It performs operations based on incoming data using DTO classes and returns results with appropriate DTO classes.
 * It also handles exception cases such as no client found, no comments found, and name-phone mismatch.
 * */

@Service
@RequiredArgsConstructor
public class CustomerContractControllerImpl implements CustomerControllerContract {

    private final CustomerEntityService entityService;

    @Override
    public CustomerDTO save(CustomerSaveAndUpdateDTO customerSaveAndUpdateDTO) {
        Customer entity = CustomerMapper.INSTANCE.toEntity(customerSaveAndUpdateDTO);
        entity = entityService.save(entity);
        return CustomerMapper.INSTANCE.toDTO(entity);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = entityService.findAll();
        return CustomerMapper.INSTANCE.toDTOList(customerList);
    }

    @Override
    public CustomerDTO findByIdCustomer(Long id) {
        Customer customerById = entityService.findById(id).orElseThrow(() -> new CustomerNotFoundException(String.valueOf(id)));
        ;
        return CustomerMapper.INSTANCE.toDTO(customerById);
    }

    @Override
    public CustomerDTO findByName(String name) {
        Customer customerByName = entityService.findByName(name);
        return CustomerMapper.INSTANCE.toDTO(customerByName);
    }

    @Override
    public void deleteByName(CustomerDeleteDTO customerDeleteDTO) {
        Customer customerByName = entityService.findByName(customerDeleteDTO.name());

        if (customerByName == null) {
            throw new CustomerNotFoundException(customerDeleteDTO.name());
        }
        if (Objects.equals(customerByName.getPhoneNumber(), customerDeleteDTO.phoneNumber())) {
            entityService.deleteByName(customerDeleteDTO);
        } else throw new NameAndPhoneNotMatchException(customerByName.getName(), customerDeleteDTO.phoneNumber());

    }

    @Override
    public CustomerDTO update(Long id, CustomerSaveAndUpdateDTO customerSaveAndUpdateDTO) {
        Customer updateCustomer = entityService.update(id, customerSaveAndUpdateDTO);
        return CustomerMapper.INSTANCE.toDTO(updateCustomer);
    }
}