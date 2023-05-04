package org.sid.projet_spring.service;

import org.sid.projet_spring.dto.BankAccountRequestDto;
import org.sid.projet_spring.dto.BankAccountResponseDto;


public interface AccountService {
    BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
    BankAccountResponseDto updateAccount(String id , BankAccountRequestDto bankAccountDto);
}
