package com.alinazim.account.model.dto;

import com.alinazim.account.dao.entity.Transaction;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private Set<TransactionDto> transactionDtoSet;
    private LocalDateTime creationDate;

}
