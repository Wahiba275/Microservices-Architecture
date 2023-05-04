package org.sid.projet_spring.service;

import org.sid.projet_spring.dto.BankAccountRequestDto;
import org.sid.projet_spring.dto.BankAccountResponseDto;
import org.sid.projet_spring.entities.BankAccount;
import org.sid.projet_spring.mappers.AccountMapper;
import org.sid.projet_spring.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional

public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper ;
    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createDate(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDto;
    }

    @Override
    public BankAccountResponseDto updateAccount(String id, BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createDate(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDto;
    }

}
