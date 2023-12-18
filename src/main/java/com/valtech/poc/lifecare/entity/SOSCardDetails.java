package com.valtech.poc.lifecare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "soscard_info", uniqueConstraints = @UniqueConstraint(columnNames = "sosCardNumber"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SOSCardDetails {

	@Id
	private String governmentUID;
	private String sosCardNumber;
	private double balance;
	private double threshold;

	@OneToOne(targetEntity = Users.class, mappedBy = "sosCardDetails")
	private Users users;
	
	public SOSCardDetails(String governmentUID,String sosCardNumber,double balance,double threshold) {
		super();
		this.governmentUID = governmentUID;
		this.sosCardNumber = sosCardNumber;
		this.balance = balance;
		this.threshold = threshold;
	}
	
}
