package com.valtech.poc.lifecare.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.valtech.poc.lifecare.entity.SOSCardDetails;
import com.valtech.poc.lifecare.entity.Users;

public class CustomUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Users users;
	
	private SOSCardDetails details;
	
	public CustomUserDetail(Users users) {
		this.users = users;
	}
	
	public String getName() {

		return users.getUserName();
	}
	
	public String getGovernmentUID() {

		return details.getGovernmentUID();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(() -> users.getRoles());
	}

	@Override
	public String getPassword() {

		return users.getPassword();
	}

	@Override
	public String getUsername() {

		return users.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
