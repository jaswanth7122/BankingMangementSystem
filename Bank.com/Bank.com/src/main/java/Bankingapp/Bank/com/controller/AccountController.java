package Bankingapp.Bank.com.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bankingapp.Bank.com.Dto.AccountDto;
import Bankingapp.Bank.com.TransactionsHistory.TransactionDto;
import Bankingapp.Bank.com.service.Accountservice;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private Accountservice accountservice;
	
	
	public AccountController(Accountservice accountservice) {
		super();
		this.accountservice = accountservice;
	}

	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountservice.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{accNO}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accNO){
		System.out.println("Controller received account ID: " + accNO);
		AccountDto accountDto = accountservice.getAccountById(accNO);
		return  ResponseEntity.ok(accountDto);
		
	}
	@PutMapping("/{accNO}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long accNO, @RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		AccountDto accountDto = accountservice.depositAmount(accNO, amount);
		return ResponseEntity.ok(accountDto);
		
	}
	
	@PutMapping("/{accNO}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long accNO, @RequestBody Map<String, Double> request){
		Double amount = request.get("amount");
		AccountDto accountDto = accountservice.withdrawAmount(accNO,amount);
		return ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/{accNO}")
	public ResponseEntity<AccountDto> Delete(@PathVariable Long accNO){
		AccountDto accountDto = accountservice.deleteAccount(accNO);
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping("/getallaccounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts = accountservice.getallAccounts();
		return ResponseEntity.ok(accounts);
		
		
	}
	@GetMapping("/transactions/{accNO}")
	public ResponseEntity<List<TransactionDto>> getalltransactionsById(@PathVariable Long accNO){
		List<TransactionDto> transactions = accountservice.getallTransactionsById(accNO);
		return ResponseEntity.ok(transactions);
		
		
	}
	@PutMapping("/{fromaccNo}/{toaccNo}/transfer")
	public ResponseEntity<AccountDto> transferFromaccTotoAcc(@PathVariable Long fromaccNo, @PathVariable Long toaccNo,@RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		return ResponseEntity.ok(accountservice.transfer(fromaccNo, toaccNo, amount));
		
	}
}
