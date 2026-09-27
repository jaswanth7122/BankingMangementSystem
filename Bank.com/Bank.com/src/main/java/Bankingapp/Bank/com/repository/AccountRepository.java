package Bankingapp.Bank.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Bankingapp.Bank.com.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
