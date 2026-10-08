package Bankingapp.Bank.com.Usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Bankingapp.Bank.com.UserServices.Userservice;
import Bankingapp.Bank.com.Userentity.User;

@RestController
public class UserController {
	
	@Autowired
	Userservice userservice;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@PostMapping("register")
	public User addUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userservice.saveruser(user);
		
	}

}
