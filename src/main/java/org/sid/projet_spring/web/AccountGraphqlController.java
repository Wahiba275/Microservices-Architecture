package org.sid.projet_spring.web;

import org.sid.projet_spring.dto.BankAccountRequestDto;
import org.sid.projet_spring.dto.BankAccountResponseDto;
import org.sid.projet_spring.entities.BankAccount;
import org.sid.projet_spring.repositories.BankAccountRepository;
import org.sid.projet_spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService ;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return  bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){return  bankAccountRepository.findById(id)
            .orElseThrow();}
    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id , @Argument BankAccountRequestDto bankAccount){
        return accountService.updateAccount(id , bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument  String id){
        bankAccountRepository.deleteById(id);
    }
}

