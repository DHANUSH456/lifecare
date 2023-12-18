package com.valtech.poc.lifecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.poc.lifecare.entity.Users;


@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);
	
	Users findByUserName(String name);

}
