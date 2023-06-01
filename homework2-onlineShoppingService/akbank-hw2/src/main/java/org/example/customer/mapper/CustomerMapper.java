package org.example.customer.mapper;

import org.example.customer.Customer;
import org.example.customer.dto.CustomerDTO;
import org.example.customer.dto.CustomerSaveAndUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * This code defines a mapper interface that performs conversions between the Customer class and
 * the CustomerDTO and CustomerSaveAndUpdateDTO classes using the MapStruct library.
 * */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerSaveAndUpdateDTO customerSaveAndUpdateDTO);

    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toDTOList(List<Customer> customerList);
}