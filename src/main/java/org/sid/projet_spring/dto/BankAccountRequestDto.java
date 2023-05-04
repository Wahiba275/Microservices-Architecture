package org.sid.projet_spring.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projet_spring.enums.AccountType;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class BankAccountRequestDto {
    private Double balance;
    private  String currency ;
    private AccountType type ;
}
