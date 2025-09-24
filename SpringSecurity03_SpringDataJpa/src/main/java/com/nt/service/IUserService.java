package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.model.UserDetail;


public interface IUserService extends UserDetailsService{
	
	public String saveUsers(UserDetail user);

}
