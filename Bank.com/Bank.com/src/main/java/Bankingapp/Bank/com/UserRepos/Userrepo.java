package Bankingapp.Bank.com.UserRepos;

import org.springframework.data.jpa.repository.JpaRepository;

import Bankingapp.Bank.com.Userentity.User;

public interface Userrepo extends JpaRepository<User, String>{

	User findByUsername(String username);

}
