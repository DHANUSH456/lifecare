package com.valtech.poc.lifecare.model;

import com.valtech.poc.lifecare.entity.SOSCardDetails;
import com.valtech.poc.lifecare.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersModel {

	private int userId;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private String roles;
	private SOSCardDetails sosCardDetails;
	
	public Users getUsersDetail() {
		// TODO Auto-generated method stub
		return new Users(userId, userName, email, password, phoneNumber, roles, sosCardDetails);
	}

}
