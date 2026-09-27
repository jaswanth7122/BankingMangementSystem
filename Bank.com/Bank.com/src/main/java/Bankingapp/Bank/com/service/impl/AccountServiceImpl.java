package Bankingapp.Bank.com.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Bankingapp.Bank.com.Dto.AccountDto;
import Bankingapp.Bank.com.Exception.AccountNotFoundException;
import Bankingapp.Bank.com.Exception.AccountNumberCannotBeSameException;
import Bankingapp.Bank.com.Exception.InsufficientFundException;
import Bankingapp.Bank.com.Exception.MinimumDepositException;
import Bankingapp.Bank.com.Transactionrepository.Transactionrepo;
import Bankingapp.Bank.com.TransactionsHistory.TransactionDto;
import Bankingapp.Bank.com.TransactionsHistory.Transactions;
import Bankingapp.Bank.com.TransactionsMapping.TransactionMapper;
import Bankingapp.Bank.com.entity.Account;
import Bankingapp.Bank.com.mapper.AccountMapper;
import Bankingapp.Bank.com.repository.AccountRepository;
import Bankingapp.Bank.com.service.Accountservice;
@Service
public class AccountServiceImpl implements Accountservice {
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	@Autowired
	Transactionrepo transactionrepo;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);
		if(account.getBalance() >= 2000) {
			Account savedAccount = accountRepository.save(account);
			Transactions transactions = new Transactions(
					 	savedAccount.getAccNO(),
					    "ACCOUNT CREATED",
					    savedAccount.getBalance(),
					    savedAccount.getBalance(),
					    null);
			transactionrepo.save(transactions);
			return AccountMapper.mapToAccountDto(savedAccount);
		}
		else {
			 throw new MinimumDepositException("Minimum deposit is 2000");
		}
		
			
		
	}

	@Override
	public AccountDto getAccountById(Long accNO) {
		// TODO Auto-generated method stub
		Account account =  accountRepository.findById(accNO).orElseThrow(() -> new AccountNotFoundException("Account does nor exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto depositAmount(Long accNO, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(accNO).orElseThrow(() -> new AccountNotFoundException("did not found"));
		double balance = account.getBalance();
		double total = balance + amount;
		account.setBalance(total);
		System.out.println(account.getAccountHoldername());
		System.out.println(total);
		Account savedAccount = accountRepository.save(account);
		System.out.println(savedAccount);
		Transactions transaction = new Transactions(
			    accNO,
			    "DEPOSIT",
			    amount,
			    total,
			    null
			);
		transactionrepo.save(transaction);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrawAmount(Long accNO, Double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(accNO).orElseThrow(() -> new AccountNotFoundException("did not found"));
		double balance = account.getBalance();
		double total = balance - amount;
		System.out.println(account.getAccountHoldername());
		System.out.println(total);
		
		if(balance >= amount) {
		
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		Transactions transaction = new Transactions(
			    accNO,
			    "WITHDRAW",
			    amount,
			    total,
			    null
			);
		transactionrepo.save(transaction);
		
		return AccountMapper.mapToAccountDto(savedAccount);
		}
		else {
			throw new InsufficientFundException("Insuffcient Funds");
		}
				
		
	}

	@Override
	public AccountDto deleteAccount(Long accNO) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(accNO).orElseThrow(() -> new AccountNotFoundException("did not found"));
		accountRepository.delete(account);
		return AccountMapper.mapToAccountDto(account);
	}
	
	public List<AccountDto> getallAccounts(){
		
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).toList();
		
	}

	@Override
	public List<TransactionDto> getallTransactionsById(Long accNO) {
		// TODO Auto-generated method stub
		List<Transactions> transactions = transactionrepo.findAllByaccNO(accNO);
		
		return transactions.stream().map((transaction)->TransactionMapper.maptoTransactiosDto(transaction)).toList();
		
	}

	@Override
	public AccountDto transfer(Long fromaccNo, Long toaccNo, double amount) {
		// TODO Auto-generated method stub
		Account sender = accountRepository.findById(fromaccNo).orElseThrow(() -> new AccountNotFoundException("sender account does not exist"));
		Account receiver = accountRepository.findById(toaccNo).orElseThrow(()-> new AccountNotFoundException("receiver account does not exist"));
		if(sender.getAccNO() != receiver.getAccNO()) {
			if(sender.getBalance() > amount) {
				double senderBalance = sender.getBalance() - amount;
				sender.setBalance(senderBalance);
				accountRepository.save(sender);
			}
			else {
				throw new InsufficientFundException("Insufficient Funds");
			}
			
			double recevierBalance = receiver.getBalance() + amount;
			receiver.setBalance(recevierBalance);
			accountRepository.save(receiver);
			
		}
		else {
			throw new AccountNumberCannotBeSameException("Both the Account number cannot be Same");
		}
		
		
		return AccountMapper.mapToAccountDto(sender);
		
	}

	
}
