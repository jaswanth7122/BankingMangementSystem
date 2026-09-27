package Bankingapp.Bank.com.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> handleaccountnotFound(AccountNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InsufficientFundException.class)
	public ResponseEntity<String> handleinsufficientfund(InsufficientFundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST) ;
		
	}
	@ExceptionHandler(MinimumDepositException.class)
	public ResponseEntity<String> handleminimundepositException(MinimumDepositException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccountNumberCannotBeSameException.class)
	public ResponseEntity<String> handleAccountsareSameException(AccountNumberCannotBeSameException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
