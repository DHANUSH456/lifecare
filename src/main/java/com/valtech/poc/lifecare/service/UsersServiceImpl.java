package com.valtech.poc.lifecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.poc.lifecare.entity.SOSCardDetails;
import com.valtech.poc.lifecare.entity.Users;
import com.valtech.poc.lifecare.repository.SOSCardDetailsRepo;
import com.valtech.poc.lifecare.repository.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SOSCardDetailsRepo sosCardDetailsRepo;

	@Override
	public long countUserDetails() {

		return usersRepo.count();
	}

	@Override
	public Users createUserDetails(Users users) {

		users.setPassword(passwordEncoder.encode(users.getPassword()));
		return usersRepo.save(users);
	}

	@Override
	public Users findUserByEmail(String email) {

		return usersRepo.findByEmail(email);
	}

	@Override
	public SOSCardDetails findByUserGovernmentUID(String governmentUID) {

		return sosCardDetailsRepo.findByGovernmentUID(governmentUID);
	}
}
