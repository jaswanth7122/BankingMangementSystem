package Bankingapp.Bank.com.Transactionrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Bankingapp.Bank.com.TransactionsHistory.Transactions;

public interface Transactionrepo extends JpaRepository<Transactions, Long> {

	

	List<Transactions> findAllByaccNO(Long accNO);

}
