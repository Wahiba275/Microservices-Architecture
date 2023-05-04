package org.sid.projet_spring.web;

import org.sid.projet_spring.dto.BankAccountRequestDto;
import org.sid.projet_spring.dto.BankAccountResponseDto;
import org.sid.projet_spring.entities.BankAccount;
import org.sid.projet_spring.entities.Customer;
import org.sid.projet_spring.mappers.AccountMapper;
import org.sid.projet_spring.repositories.BankAccountRepository;
import org.sid.projet_spring.repositories.CustomerRepository;
import org.sid.projet_spring.service.AccountService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository ;
    private AccountService service ;
    private AccountMapper accountMapper ;
    private CustomerRepository customerRepository ;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService service, AccountMapper accountMapper, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.service = service;
        this.accountMapper = accountMapper;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount (@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account Not Found :)" , id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto bankAccountRequestDto ){
        return  service.addAccount(bankAccountRequestDto);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable  String id ,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow();
        if(bankAccount.getType() != null ) account.setType(bankAccount.getType());
        if(bankAccount.getBalance() != null ) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCurrency() != null ) account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreateDate() != null ) account.setCreateDate(new Date());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}
