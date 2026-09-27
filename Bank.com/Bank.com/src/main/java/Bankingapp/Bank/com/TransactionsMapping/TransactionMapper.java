package Bankingapp.Bank.com.TransactionsMapping;

import Bankingapp.Bank.com.TransactionsHistory.TransactionDto;
import Bankingapp.Bank.com.TransactionsHistory.Transactions;

public class TransactionMapper {
	
	public static Transactions maptoTransactions(TransactionDto transactionDto) {
		Transactions transactions = new Transactions(
				transactionDto.getTransactionID(),
				transactionDto.getAccNO(),
				transactionDto.getType(),
				transactionDto.getAmount(),
				transactionDto.getBalance(),
				transactionDto.getTransactionDateTime());
		return transactions;
	
		
	}
	public static TransactionDto maptoTransactiosDto(Transactions transactions) {
		TransactionDto transactionDto = new TransactionDto(
				transactions.getTransactionID(),
				transactions.getAccNO(),
				transactions.getType(),
				transactions.getAmount(),
				transactions.getBalance(),
				transactions.getTransactionDateTime());
		return transactionDto;
	}

}
