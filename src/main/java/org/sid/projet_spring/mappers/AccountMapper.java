package org.sid.projet_spring.mappers;

import org.sid.projet_spring.dto.BankAccountResponseDto;
import org.sid.projet_spring.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount , bankAccountResponseDto);
        return bankAccountResponseDto ;
    }
}
