package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.model.UserDetail;
import com.nt.repo.IUserDetailsRepo;
@Service
public class UserDetailServiceImpl implements IUserService{
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private IUserDetailsRepo repo;

	// 🔹 Spring Security calls this when authenticating
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//write logic to find username when someone login to page
		
			UserDetail user=repo.findByUname(username)
					.orElseThrow(()->new IllegalArgumentException("User Not Found"));
		//here User is the implemeation of UserDetails
			return User.builder()
					.username(user.getUname())
					.password(user.getPwd())
					.roles(user.getRoles().toArray(new String[0]))
					.build();
	
	}

	@Override
	public String saveUsers(UserDetail user) {
		
		user.setPwd(encoder.encode(user.getPwd()));
		return  repo.save(user).getUnid()+ " is registered";
	}

	

	
	

}
