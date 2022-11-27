package com.alinazim.account.model.dto.converter;

import com.alinazim.account.dao.entity.Account;
import com.alinazim.account.model.dto.CustomerAccountDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(
                from.getId(),
                from.getBalance(),
                from.getTransactions().stream().map(converter::converter).collect(Collectors.toSet()),
                from.getCreationDate()
        );
    }
}
