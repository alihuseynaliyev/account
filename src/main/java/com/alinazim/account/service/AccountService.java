package com.alinazim.account.service;

import com.alinazim.account.dao.entity.Account;
import com.alinazim.account.dao.entity.Customer;
import com.alinazim.account.dao.entity.Transaction;
import com.alinazim.account.dao.repository.AccountRepository;
import com.alinazim.account.model.dto.AccountDto;
import com.alinazim.account.model.dto.converter.AccountDtoConverter;
import com.alinazim.account.model.dto.request.CreateAccountRequest;
import com.alinazim.account.model.enums.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    TransactionType.INITIAL,
                    createAccountRequest.getInitialCredit(),
                    LocalDateTime.now(),
                    account);
            account.getTransactions().add(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }

}
