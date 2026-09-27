package Bankingapp.Bank.com.service;

import java.util.List;

import Bankingapp.Bank.com.Dto.AccountDto;
import Bankingapp.Bank.com.TransactionsHistory.TransactionDto;

public interface Accountservice {
	
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long accNO);
	AccountDto depositAmount(Long accNO, double amount);
	AccountDto withdrawAmount(Long accNO, Double amount);
	AccountDto deleteAccount(Long accNO);
	List<AccountDto> getallAccounts();
	List<TransactionDto> getallTransactionsById(Long accNO);
	AccountDto transfer(Long fromaccNo, Long toaccNo, double amount);
}
