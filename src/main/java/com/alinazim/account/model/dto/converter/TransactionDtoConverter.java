package com.alinazim.account.model.dto.converter;

import com.alinazim.account.model.dto.TransactionDto;
import com.alinazim.account.dao.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto converter(Transaction from) {
        return new TransactionDto(
                from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate()
        );
    }
}
