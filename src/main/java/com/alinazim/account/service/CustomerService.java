package com.alinazim.account.service;

import com.alinazim.account.exception.CustomerNotFoundException;
import com.alinazim.account.dao.entity.Customer;
import com.alinazim.account.dao.repository.CustomerRepository;
import com.alinazim.account.model.dto.CustomerDto;
import com.alinazim.account.model.dto.converter.CustomerDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;


    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.converToCustomerDto(findCustomerById(customerId));
    }
}
