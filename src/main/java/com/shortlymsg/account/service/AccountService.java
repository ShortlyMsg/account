package com.shortlymsg.account.service;

import com.shortlymsg.account.dto.AccountDto;
import com.shortlymsg.account.dto.AccountDtoConverter;
import com.shortlymsg.account.dto.CreateAccountRequest;
import com.shortlymsg.account.model.Account;
import com.shortlymsg.account.model.Customer;
import com.shortlymsg.account.model.Transaction;
import com.shortlymsg.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
                );
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transaction transaction= new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }
}
