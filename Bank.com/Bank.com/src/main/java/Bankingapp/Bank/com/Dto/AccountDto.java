package Bankingapp.Bank.com.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {
	
	
	private Long accNO;
	private String accountHoldername;
	private Double balance;
	public AccountDto(Long accNO, String accountHoldername, Double balance) {
		super();
		this.accNO = accNO;
		this.accountHoldername = accountHoldername;
		this.balance = balance;
	}
	public Long getAccNO() {
		return accNO;
	}
	public void setAccNO(Long accNO) {
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
