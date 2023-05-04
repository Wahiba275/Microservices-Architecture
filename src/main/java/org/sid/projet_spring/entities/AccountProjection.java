package org.sid.projet_spring.entities;

import org.sid.projet_spring.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types =  BankAccount.class  , name = "p1")
public interface AccountProjection {
    String getId();
    AccountType getType();
    Double getBalance();

}
