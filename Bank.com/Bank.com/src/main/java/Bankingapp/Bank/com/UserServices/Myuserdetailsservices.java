package Bankingapp.Bank.com.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Bankingapp.Bank.com.UserRepos.Userrepo;
import Bankingapp.Bank.com.Userentity.User;

@Service
public class Myuserdetailsservices implements UserDetailsService {
	
	@Autowired
	Userrepo urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = urepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Not found user");
		}
		return new UserPrincipal(user);
	}
		
}
