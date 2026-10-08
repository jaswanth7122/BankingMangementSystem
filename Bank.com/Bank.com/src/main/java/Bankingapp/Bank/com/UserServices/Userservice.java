package Bankingapp.Bank.com.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Bankingapp.Bank.com.UserRepos.Userrepo;
import Bankingapp.Bank.com.Userentity.User;

@Service
public class Userservice {
	@Autowired
	Userrepo urepo;
	public User saveruser(User user) {
		// TODO Auto-generated method stub
		return urepo.save(user);
	}
	

}
