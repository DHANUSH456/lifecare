package com.valtech.poc.lifecare.service;

import com.valtech.poc.lifecare.entity.SOSCardDetails;
import com.valtech.poc.lifecare.entity.Users;

public interface UsersService {

	long countUserDetails();

	Users createUserDetails(Users users);

	Users findUserByEmail(String email);

	SOSCardDetails findByUserGovernmentUID(String governmentUID);

}