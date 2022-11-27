package com.alinazim.account.model.dto.converter;

import com.alinazim.account.model.dto.AccountDto;
import com.alinazim.account.dao.entity.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {
    private final TransactionDtoConverter transactionDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;

    public AccountDtoConverter(TransactionDtoConverter transactionDtoConverter,
                               CustomerDtoConverter customerDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
        this.customerDtoConverter = customerDtoConverter;
    }

    public AccountDto convert(Account from) {
        return new AccountDto(
                from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.converToAccountCustomer(from.getCustomer()),
                Objects.requireNonNull(from.getTransactions()
                        .stream()
                        .map(transactionDtoConverter::converter)
                        .collect(Collectors.toSet()))
        );
    }

}