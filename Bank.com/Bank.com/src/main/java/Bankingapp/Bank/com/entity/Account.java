package Bankingapp.Bank.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")

public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_no")
	private Long accNO;
	@Column(name = "account_holder_name")
	private String accountHoldername;
	private Double balance;
	 public Account() {
	    }
	public Account(Long accNO, String accountHoldername, Double balance) {
		super();
		this.accNO = accNO;
		this.accountHoldername = accountHoldername;
		this.balance = balance;
	}
	public Long getAccNO() {
		return accNO;
	}
	public void setAccNo(Long accNO) {
		this.accNO = accNO;
	}
	public String getAccountHoldername() {
		return accountHoldername;
	}
	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	

}
