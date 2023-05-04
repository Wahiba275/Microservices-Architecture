package org.sid.projet_spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projet_spring.enums.AccountType;

import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class BankAccount {
    @Id
    private    String id ;

    private Date createDate ;
    private Double balance;
    private  String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    @ManyToOne
    private Customer customer;

}
