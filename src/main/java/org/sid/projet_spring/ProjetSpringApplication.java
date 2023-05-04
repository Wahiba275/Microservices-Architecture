package org.sid.projet_spring;


import org.sid.projet_spring.entities.BankAccount;
import org.sid.projet_spring.entities.Customer;
import org.sid.projet_spring.enums.AccountType;
import org.sid.projet_spring.repositories.BankAccountRepository;
import org.sid.projet_spring.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringApplication.class, args);
    }
@Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository , CustomerRepository customerRepository){
        return args -> {
            Stream.of("Wahiba" , "Nabila" , "Jawad" , "Anwar" , "Hanae").forEach((c)->{
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);

            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i <10 ; i++) {
                    BankAccount account = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(10000+Math.random()*90000)
                            .createDate(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(account);
                }
            });
        };
 }}
