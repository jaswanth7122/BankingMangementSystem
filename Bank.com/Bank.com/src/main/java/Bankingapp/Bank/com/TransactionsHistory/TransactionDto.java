package Bankingapp.Bank.com.TransactionsHistory;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TransactionDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long transactionID;
	Long accNO;
	String type;
	double amount;
	double balance;
	
	@CreationTimestamp
	LocalDateTime transactionDateTime;

	public TransactionDto() {
		super();
	}



	public Long getTransactionID() {
		return transactionID;
	}



	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}



	public TransactionDto(Long transactionID, Long accNO, String type, double amount, double balance,
			LocalDateTime transactionDateTime) {
		super();
		this.transactionID = transactionID;
		this.accNO = accNO;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.transactionDateTime = transactionDateTime;
	}

	public Long getAccNO() {
		return accNO;
	}

	public void setAccNO(Long accNO) {
		this.accNO = accNO;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	
}