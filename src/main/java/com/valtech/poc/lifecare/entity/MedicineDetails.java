package com.valtech.poc.lifecare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicine_info", uniqueConstraints = @UniqueConstraint(columnNames = "medicineName"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	private String medicineName;
	private String description;
	private double price;
	private int count;
	private boolean sosApplicable;
	
	public MedicineDetails(String medicineName, String description, double price, int count, boolean sosApplicable) {
		super();
		this.medicineName = medicineName;
		this.description = description;
		this.price = price;
		this.count = count;
		this.sosApplicable = sosApplicable;
	}

}
