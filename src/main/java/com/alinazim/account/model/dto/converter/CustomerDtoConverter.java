package com.alinazim.account.model.dto.converter;

import com.alinazim.account.model.dto.AccountCustomerDto;
import com.alinazim.account.dao.entity.Customer;
import com.alinazim.account.model.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter converter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDto converToAccountCustomer(Customer from) {
        if (from == null) return new AccountCustomerDto("", "", "");
        return new AccountCustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname()
        );
    }


    public CustomerDto converToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(converter::convert).collect(Collectors.toSet())
        );
    }
}
