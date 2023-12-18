package com.valtech.poc.lifecare.model;

import com.valtech.poc.lifecare.entity.MedicineDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDetailsModel {

	private int medicineId;
	private String medicineName;
	private String description;
	private double price;
	private int count;
	private boolean sosApplicable;

	public MedicineDetailsModel(MedicineDetails details) {
		this.medicineId = details.getMedicineId();
		this.medicineName = details.getMedicineName();
		this.description = details.getDescription();
		this.price = details.getPrice();
		this.count = details.getCount();
		this.sosApplicable = details.isSosApplicable();
	}

}
