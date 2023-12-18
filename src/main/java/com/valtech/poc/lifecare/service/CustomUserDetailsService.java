package com.valtech.poc.lifecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.valtech.poc.lifecare.entity.Users;
import com.valtech.poc.lifecare.repository.UsersRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomUserDetail(user);
	}

}
