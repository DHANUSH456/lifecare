package com.valtech.poc.lifecare.model;

import com.valtech.poc.lifecare.entity.SOSCardDetails;
import com.valtech.poc.lifecare.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SOSCardDetailsModel {

	private String governmentUID;
	private String sosCardNumber;
	private double balance;
	private double threshold;
	private Users users;

	

	public SOSCardDetails getSosCardDetails() {

		return new SOSCardDetails(governmentUID, sosCardNumber, balance, threshold);
	}

}
