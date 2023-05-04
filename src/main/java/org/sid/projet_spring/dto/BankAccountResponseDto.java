package org.sid.projet_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projet_spring.enums.AccountType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDto {
    private    String id ;
    private Date createDate ;
    private Double balance;
    private  String currency ;
    private AccountType type ;
}
