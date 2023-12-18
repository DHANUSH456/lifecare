package com.valtech.poc.lifecare.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users_info", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String email;
	private String password;
	private String phoneNumber;
	private String roles;

	@OneToOne(targetEntity = SOSCardDetails.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "governmentUID", referencedColumnName = "governmentUID")
	private SOSCardDetails sosCardDetails;

}
