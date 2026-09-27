package Bankingapp.Bank.com.mapper;

import Bankingapp.Bank.com.Dto.AccountDto;
import Bankingapp.Bank.com.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getAccNO(),
				accountDto.getAccountHoldername(),
				accountDto.getBalance()
				);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getAccNO(),
				account.getAccountHoldername(),
				account.getBalance());
		return accountDto;
	}
}
