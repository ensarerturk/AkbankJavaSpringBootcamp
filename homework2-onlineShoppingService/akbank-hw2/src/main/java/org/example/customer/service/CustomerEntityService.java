package org.example.customer.service;

import org.example.customer.Customer;
import org.example.customer.dto.CustomerDeleteDTO;
import org.example.customer.dto.CustomerSaveAndUpdateDTO;
import org.example.customer.repository.CustomerRepository;
import org.example.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

/*
 * This class provides basic operations such as saving, updating, deleting and searching customer data.
 * */

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {
    public CustomerEntityService(CustomerRepository repository) {
        super(repository);
    }

    public Customer findByName(String name) {
        return getRepository().findCustomerByName(name);
    }

    public void deleteByName(CustomerDeleteDTO customerDeleteDTO) {
        Customer customerByUsername = getRepository().findCustomerByName(customerDeleteDTO.name());
        getRepository().deleteById(customerByUsername.getId());
    }

    public Customer update(Long id, CustomerSaveAndUpdateDTO customerSaveAndUpdateDTO) {
        Customer customerById = findById(id).orElseThrow();
        customerById.setName(customerSaveAndUpdateDTO.name());
        customerById.setEmail(customerSaveAndUpdateDTO.email());
        customerById.setPhoneNumber(customerSaveAndUpdateDTO.phoneNumber());
        customerById.setStatus(customerSaveAndUpdateDTO.status());
        save(customerById);
        return customerById;
    }
}