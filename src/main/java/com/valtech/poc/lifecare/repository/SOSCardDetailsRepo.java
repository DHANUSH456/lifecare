package com.valtech.poc.lifecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.poc.lifecare.entity.SOSCardDetails;

@Repository
public interface SOSCardDetailsRepo extends JpaRepository<SOSCardDetails, String> {

	SOSCardDetails findByGovernmentUID(String governmentUID);
}
